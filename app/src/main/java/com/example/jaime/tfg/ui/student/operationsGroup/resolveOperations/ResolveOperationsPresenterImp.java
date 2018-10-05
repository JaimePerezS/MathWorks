package com.example.jaime.tfg.ui.student.operationsGroup.resolveOperations;

import com.example.jaime.tfg.data.interactor.student.operationsGroup.resolveOperations.ResolveOperationsInteractorImp;
import com.example.jaime.tfg.data.model.Operation;
import com.example.jaime.tfg.data.model.OperationsRecord;

import java.util.List;


/**
 * Created by Jaime on 06/02/2018.
 */

public class ResolveOperationsPresenterImp implements ResolveOperationsPresenter {
    private ResolveOperationsView view;
    private ResolveOperationsInteractorImp interactor;

    public ResolveOperationsPresenterImp(ResolveOperationsView view) {
        this.view = view;
        this.interactor = new ResolveOperationsInteractorImp(this);
    }

    @Override
    public void getOperations(String idStudent, String idOperationsGroup, String token) {
        view.showProgress("Cargando operaciones", "Cargando...");
        interactor.getOperations(idStudent, idOperationsGroup, token);
    }

    @Override
    public void onSuccessGetOperations(List<Operation> operationList) {
        view.hideProgress();
        view.loadOperations(operationList);
    }

    @Override
    public void onFailureGetOperations(String message) {
        view.hideProgress();
        view.showErrorToast(message);
        view.finish();
    }

    @Override
    public void updatePoints(String idStudent, int points, String token) {
        interactor.updatePoints(idStudent, points, token);
    }

    @Override
    public void onFailureUpdatePoints(String message) {
        view.showErrorToast(message);
    }

    @Override
    public void insertOperationsGroupRecord(String date, int points, final List<OperationsRecord> operationsRecordList, final String idStudent, final String idOperationsGroup, final String token) {
        view.showProgress("Guardando progresos", "Guardando...");
        interactor.insertOperationsGroupRecord(date, points, operationsRecordList, idStudent, idOperationsGroup, token);
    }

    @Override
    public void onSuccessInsertOperationsGroupRecord(String message) {
        view.hideProgress();
    }

    @Override
    public void onFailureInsertOperationsGroupRecord(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
