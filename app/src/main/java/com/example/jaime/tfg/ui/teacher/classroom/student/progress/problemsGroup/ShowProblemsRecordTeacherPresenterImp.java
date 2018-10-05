package com.example.jaime.tfg.ui.teacher.classroom.student.progress.problemsGroup;

import com.example.jaime.tfg.data.interactor.teacher.classroom.student.progress.problemsGroup.ShowProblemsRecordTeacherInteractorImp;
import com.example.jaime.tfg.data.model.ProblemsRecord;

import java.util.List;

public class ShowProblemsRecordTeacherPresenterImp implements ShowProblemsRecordTeacherPresenter {
    ShowProblemsRecordTeacherView view;
    ShowProblemsRecordTeacherInteractorImp interactor;

    public ShowProblemsRecordTeacherPresenterImp(ShowProblemsRecordTeacherView view) {
        this.view = view;
        this.interactor = new ShowProblemsRecordTeacherInteractorImp(this);
    }

    @Override
    public void getProblemsRecord(String idTeacher, String idClassroom, String idStudent, String idProblemsGroup, String idRecord, String token) {
        view.showProgress("Cargando progresos", "Cargando...");
        interactor.getProblemsRecord(idTeacher, idClassroom, idStudent, idProblemsGroup, idRecord, token);
    }

    @Override
    public void onSuccessGetProblemsRecord(List<ProblemsRecord> problemsRecordList) {
        view.hideProgress();
        view.showProblemsRecord(problemsRecordList);
    }

    @Override
    public void onFailureGetProblemsRecord(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
