package com.example.jaime.tfg.ui.teacher.operationsgroup;

import com.example.jaime.tfg.data.interactor.teacher.operationsGroup.ShowOperationsGroupInteractorImp;
import com.example.jaime.tfg.data.model.OperationsGroup;

import java.util.List;

/**
 * Created by Jaime on 06/12/2017.
 */

public class ShowOperationsGroupPresenterImp implements ShowOperationsGroupPresenter{
    private ShowOperationsGroupView view;
    private ShowOperationsGroupInteractorImp interactor;

    public ShowOperationsGroupPresenterImp(ShowOperationsGroupView view) {
        this.view = view;
        this.interactor = new ShowOperationsGroupInteractorImp(this);
    }

    @Override
    public void getOperationsGroup(String idTeacher, String token) {
        view.showProgress("Cargando grupos de operaciones", "Cargando...");
        interactor.getOperationsGroup(idTeacher, token);
    }

    @Override
    public void onSuccessGetOperationsGroup(List<OperationsGroup> operationsGroups) {
        view.hideProgress();
        view.showOperationsGroup(operationsGroups);
    }

    @Override
    public void onFailureGetOperationsGroup(String message) {
        view.hideProgress();
        view.showErrorToast(message);
        view.clearRecycler();
    }

    @Override
    public void onClickDeleteOperationsGroup(String idTeacher, String idOperationsGroup, String token) {
        view.showProgress("Eliminando grupos de operaciones", "Eliminando...");
        interactor.deleteOperationsGroup(idTeacher, idOperationsGroup, token);
    }

    @Override
    public void onSuccessDeleteOperationsGroup(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
    }

    @Override
    public void onFailureDeleteOperationsGroup(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
