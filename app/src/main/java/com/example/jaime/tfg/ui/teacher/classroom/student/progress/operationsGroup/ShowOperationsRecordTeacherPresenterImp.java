package com.example.jaime.tfg.ui.teacher.classroom.student.progress.operationsGroup;

import com.example.jaime.tfg.data.interactor.teacher.classroom.student.progress.operationsGroup.ShowOperationsRecordTeacherInteractorImp;
import com.example.jaime.tfg.data.model.OperationsRecord;

import java.util.List;

public class ShowOperationsRecordTeacherPresenterImp implements ShowOperationsRecordTeacherPresenter {
    private ShowOperationsRecordTeacherView view;
    private ShowOperationsRecordTeacherInteractorImp interactor;

    public ShowOperationsRecordTeacherPresenterImp(ShowOperationsRecordTeacherView view) {
        this.view = view;
        this.interactor = new ShowOperationsRecordTeacherInteractorImp(this);
    }

    public void getOperationsRecord(String idTeacher, String idClassroom, String idStudent, String idOperationsGroup, String idRecord, String token) {
        view.showProgress("Cargando operaciones realizadas","Cargando...");
        interactor.getOperationsRecord(idTeacher, idClassroom, idStudent, idOperationsGroup, idRecord, token);
    }

    @Override
    public void onSuccessGetOperationsRecord(List<OperationsRecord> operationsRecordList) {
        view.hideProgress();
        view.showOperationsRecord(operationsRecordList);
    }

    @Override
    public void onFailureGetOperationsRecord(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
