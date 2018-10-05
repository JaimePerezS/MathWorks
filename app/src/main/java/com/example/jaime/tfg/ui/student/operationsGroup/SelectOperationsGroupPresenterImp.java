package com.example.jaime.tfg.ui.student.operationsGroup;


import com.example.jaime.tfg.data.interactor.student.operationsGroup.SelectOperationsGroupInteractorImp;
import com.example.jaime.tfg.data.model.OperationsGroup;

import java.util.List;

/**
 * Created by Jaime on 12/01/2018.
 */

public class SelectOperationsGroupPresenterImp implements SelectOperationsGroupPresenter{
    private SelectOperationsGroupView view;
    private SelectOperationsGroupInteractorImp interactor;

    public SelectOperationsGroupPresenterImp(SelectOperationsGroupView view) {
        this.view = view;
        this.interactor = new SelectOperationsGroupInteractorImp(this);
    }

    @Override
    public void getOperationsGroups(String idStudent, String token) {
        view.showProgress("Cargando grupos de operaciones", "Cargando...");
        interactor.getOperationsGroups(idStudent, token);
    }

    @Override
    public void onSuccessGetOperationsGroups(List<OperationsGroup> operationsGroupList) {
        view.hideProgress();
        view.showOperationsGroup(operationsGroupList);
    }

    @Override
    public void onFailureGetOperationsGroups(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
