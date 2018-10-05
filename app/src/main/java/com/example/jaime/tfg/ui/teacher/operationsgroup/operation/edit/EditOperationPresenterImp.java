package com.example.jaime.tfg.ui.teacher.operationsgroup.operation.edit;

import com.example.jaime.tfg.data.interactor.teacher.operationsGroup.operation.edit.EditOperationInteractorImp;

/**
 * Created by Jaime on 06/12/2017.
 */

public class EditOperationPresenterImp implements EditOperationPresenter{
    private EditOperationView view;
    private EditOperationInteractorImp interactor;

    public EditOperationPresenterImp(EditOperationView view) {
        this.view = view;
        this.interactor = new EditOperationInteractorImp(this);
    }

    @Override
    public void OnClickUpdateOperation(String newStatement, int newPoints, String idTeacher, String idOperationsGroup, String idOperation, String token) {
        view.showProgress("Actualizando operación", "Actualizando...");
        interactor.updateOperation(newStatement, newPoints, idTeacher, idOperationsGroup, idOperation, token);
    }

    @Override
    public void onSuccessUpdateOperation(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
        view.finish();
    }

    @Override
    public void onFailureUpdateOperation(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
