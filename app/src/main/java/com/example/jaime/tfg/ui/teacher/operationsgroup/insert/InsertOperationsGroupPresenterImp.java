package com.example.jaime.tfg.ui.teacher.operationsgroup.insert;

import com.example.jaime.tfg.data.interactor.teacher.operationsGroup.insert.InsertOperationsGroupInteractorImp;

/**
 * Created by Jaime on 06/12/2017.
 */

public class InsertOperationsGroupPresenterImp implements InsertOperationsGroupPresenter{
    private InsertOperationsGroupView view;
    private InsertOperationsGroupInteractorImp interactor;

    public InsertOperationsGroupPresenterImp(InsertOperationsGroupView view) {
        this.view = view;
        this.interactor = new InsertOperationsGroupInteractorImp(this);
    }

    @Override
    public void onClickInsertOperationsGroup(String name, String difficulty, String idTeacher, String token) {
        view.showProgress("Guardando grupo de operaciones", "Guardando...");
        interactor.insertOperationsGroup(name, difficulty, idTeacher, token);
    }

    @Override
    public void onSuccessInsertOperationsGroup(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
        view.finish();
    }

    @Override
    public void onFailureInsertOperationsGroup(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
