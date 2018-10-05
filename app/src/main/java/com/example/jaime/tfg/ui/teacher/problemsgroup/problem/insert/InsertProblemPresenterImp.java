package com.example.jaime.tfg.ui.teacher.problemsgroup.problem.insert;

import com.example.jaime.tfg.data.interactor.teacher.problemsgroup.problem.insert.InsertProblemInteractorImp;

/**
 * Created by Jaime on 13/12/2017.
 */

public class InsertProblemPresenterImp implements InsertProblemPresenter{
    private InsertProblemView view;
    private InsertProblemInteractorImp interactor;

    public InsertProblemPresenterImp(InsertProblemView view) {
        this.view = view;
        this.interactor = new InsertProblemInteractorImp(this);
    }

    @Override
    public void onClickInsertProblem(String statement, String operation, int points, String help, String operationType, String idTeacher, String idProblemsGroup, String token) {
        view.showProgress("Guardando nuevo problema", "Guardando...");
        interactor.insertProblem(statement, operation, points, help, operationType, idTeacher, idProblemsGroup, token);
    }

    @Override
    public void onSuccessInsertProblem(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
        view.finish();
    }

    @Override
    public void onFailureInsertProblem(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
