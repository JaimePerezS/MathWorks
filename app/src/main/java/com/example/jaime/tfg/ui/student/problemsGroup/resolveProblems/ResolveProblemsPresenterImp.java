package com.example.jaime.tfg.ui.student.problemsGroup.resolveProblems;

import com.example.jaime.tfg.data.interactor.student.problemsGroup.resolveProblems.ResolveProblemsInteractorImp;
import com.example.jaime.tfg.data.model.Problem;
import com.example.jaime.tfg.data.model.ProblemsRecord;

import java.util.List;

/**
 * Created by Jaime on 11/02/2018.
 */

public class ResolveProblemsPresenterImp implements ResolveProblemsPresenter{

    private ResolveProblemsView view;
    private ResolveProblemsInteractorImp interactor;

    public ResolveProblemsPresenterImp(ResolveProblemsView view) {
        this.view = view;
        this.interactor = new ResolveProblemsInteractorImp(this);
    }

    @Override
    public void getProblems(String idStudent, String idProblemsGroup, String token) {
        view.showProgress("Cargando problemas", "Cargando...");
        interactor.getProblems(idStudent, idProblemsGroup, token);
    }

    @Override
    public void onSuccessGetProblems(List<Problem> problemList) {
        view.hideProgress();
        view.loadProblems(problemList);
    }

    @Override
    public void onFailureGetProblems(String message) {
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
    public void insertProblemsGroupRecord(String date, int points, final List<ProblemsRecord> problemsRecordList, final String student, final String idProblemsGroup, final String token) {
        view.showProgress("Guardando progresos","Guardando...");
        interactor.insertProblemsGroupRecord(date, points, problemsRecordList, student, idProblemsGroup, token);
    }

    @Override
    public void onSuccessInsertProblemsGroupRecord(String message) {
        view.hideProgress();
    }

    @Override
    public void onFailureInsertProblemsGroupRecord(String message) {
        view.hideProgress();
        view.showErrorToast(message);
        view.finish();
    }
}
