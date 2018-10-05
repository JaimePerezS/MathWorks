package com.example.jaime.tfg.ui.teacher.operationsgroup.operation;

import com.example.jaime.tfg.data.interactor.teacher.operationsGroup.operation.ShowOperationsInteractorImp;
import com.example.jaime.tfg.data.model.Operation;

import java.util.List;

/**
 * Created by Jaime on 06/12/2017.
 */

public class ShowOperationsPresenterImp implements ShowOperationsPresenter{
    private ShowOperationsView view;
    private ShowOperationsInteractorImp interactor;

    public ShowOperationsPresenterImp(ShowOperationsView view) {
        this.view = view;
        this.interactor = new ShowOperationsInteractorImp(this);
    }

    @Override
    public void getOperations(String idTeacher, String idOperationsGroup, String token) {
        view.showProgress("Cargando operaciones", "Cargando...");
        interactor.getOperations(idTeacher, idOperationsGroup, token);
    }

    @Override
    public void onSuccessGetOperations(List<Operation> operationList) {
        view.hideProgress();
        view.showOperations(operationList);
    }

    @Override
    public void onFailureGetOperations(String message) {
        view.hideProgress();
        view.showErrorToast(message);
        view.clearRecycler();
    }

    @Override
    public void onClickDeleteOperation(String idTeacher, String idOperationsGroup, String idOperation, String token) {
        view.showProgress("Eliminando operación", "Eliminando...");
        interactor.deleteOperation(idTeacher, idOperationsGroup, idOperation, token);
    }

    @Override
    public void onSuccessDeleteOperation(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
    }

    @Override
    public void onFailureDeleteOperation(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
