package com.example.jaime.tfg.ui.teacher.operationsgroup.edit;

import com.example.jaime.tfg.data.interactor.teacher.operationsGroup.edit.EditOperationsGroupInteractorImp;

/**
 * Created by Jaime on 05/12/2017.
 */

public class EditOperationsGroupPresenterImp implements EditOperationsGroupPresenter{
    private EditOperationsGroupView view;
    private EditOperationsGroupInteractorImp interactor;

    public EditOperationsGroupPresenterImp(EditOperationsGroupView view) {
        this.view = view;
        this.interactor = new EditOperationsGroupInteractorImp(this);
    }

    @Override
    public void onClickUpdateOperationsGroup(String newName, String newDifficulty, String idTeacher, String idOperationsGroup, String token) {
        view.showProgress("Actualizando grupo de operaciones", "Actualizando...");
        interactor.updateOperationsGroup(newName, newDifficulty, idTeacher, idOperationsGroup, token);
    }

    @Override
    public void onSuccessUpdateOperationsGroup(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
        view.finish();
    }

    @Override
    public void onFailureUpdateOperationsGroup(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
