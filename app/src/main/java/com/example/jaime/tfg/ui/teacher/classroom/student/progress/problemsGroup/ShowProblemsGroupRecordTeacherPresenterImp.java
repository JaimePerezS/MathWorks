package com.example.jaime.tfg.ui.teacher.classroom.student.progress.problemsGroup;

import com.example.jaime.tfg.data.interactor.teacher.classroom.student.progress.problemsGroup.ShowProblemsGroupRecordTeacherInteractorImp;
import com.example.jaime.tfg.data.model.ProblemsGroupRecord;

import java.util.List;

public class ShowProblemsGroupRecordTeacherPresenterImp implements ShowProblemsGroupRecordTeacherPresenter {
    private ShowProblemsGroupRecordTeacherView view;
    private ShowProblemsGroupRecordTeacherInteractorImp interactor;

    public ShowProblemsGroupRecordTeacherPresenterImp(ShowProblemsGroupRecordTeacherView view) {
        this.view = view;
        this.interactor = new ShowProblemsGroupRecordTeacherInteractorImp(this);
    }

    @Override
    public void getProblemsGroupRecord(String idTeacher, String idClassroom, String idStudent, String token) {
        view.showProgress("Cargando progresos", "Cargando...");
        interactor.getOperationsGroupRecord(idTeacher, idClassroom, idStudent, token);
    }

    @Override
    public void onSuccessGetProblemsGroupRecord(List<ProblemsGroupRecord> problemsGroupRecordList) {
        view.hideProgress();
        view.showProblemsGroupRecord(problemsGroupRecordList);
    }

    @Override
    public void onFailureGetProblemsGroupRecord(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
