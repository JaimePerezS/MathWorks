package com.example.jaime.tfg.ui.teacher.operationsgroup.operation.insert;

import com.example.jaime.tfg.data.interactor.teacher.operationsGroup.operation.insert.InsertOperationInteractorImp;

/**
 * Created by Jaime on 06/12/2017.
 */

public class InsertOperationPresenterImp implements InsertOperationPresenter{
    private InsertOperationView view;
    private InsertOperationInteractorImp interactor;

    public InsertOperationPresenterImp( InsertOperationView view) {
        this.view = view;
        this.interactor = new InsertOperationInteractorImp(this);
    }

    @Override
    public void onClickInsertOperation(String statement, int points, String idTeacher, String idOperationsGroup, String token) {
        view.showProgress("Guardando operación", "Guardando...");
        interactor.insertOperation(statement, points, idTeacher, idOperationsGroup, token);
    }

    @Override
    public void onSuccessInsertOperation(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
        view.finish();
    }

    @Override
    public void onFailureInsertOperation(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
