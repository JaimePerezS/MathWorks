package com.example.jaime.tfg.ui.teacher.classroom.student.progress.operationsGroup;

import com.example.jaime.tfg.data.interactor.teacher.classroom.student.progress.operationsGroup.ShowOperationsGroupRecordInteractorImp;
import com.example.jaime.tfg.data.model.OperationsGroupRecord;

import java.util.List;

public class ShowOperationsGroupRecordPresenterImp implements ShowOperationsGroupRecordPresenter {
    private ShowOperationsGroupRecordView view;
    private ShowOperationsGroupRecordInteractorImp interactor;

    public ShowOperationsGroupRecordPresenterImp(ShowOperationsGroupRecordView view) {
        this.view = view;
        this.interactor = new ShowOperationsGroupRecordInteractorImp(this);
    }

    @Override
    public void getOperationsGroupRecord(String idTeacher, String idClassroom, String idStudent, String token) {
        view.showProgress("Cargando progresos", "Cargando...");
        interactor.getOperationsGroupRecord(idTeacher, idClassroom, idStudent, token);
    }

    @Override
    public void onSuccessGetOperationsGroupRecord(List<OperationsGroupRecord> operationsGroupRecordList) {
        view.hideProgress();
        view.showOperationsGroupRecord(operationsGroupRecordList);
    }

    @Override
    public void onFailureGetOperationsGroupRecord(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
