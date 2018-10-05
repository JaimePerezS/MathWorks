package com.example.jaime.tfg.ui.teacher.problemsgroup.problem;

import com.example.jaime.tfg.data.interactor.teacher.problemsgroup.problem.ShowProblemsInteractorImp;
import com.example.jaime.tfg.data.model.Problem;

import java.util.List;

/**
 * Created by Jaime on 13/12/2017.
 */

public class ShowProblemsPresenterImp implements ShowProblemsPresenter {
    private ShowProblemsView view;
    private ShowProblemsInteractorImp interactor;

    public ShowProblemsPresenterImp(ShowProblemsView view) {
        this.view = view;
        this.interactor = new ShowProblemsInteractorImp(this);
    }

    @Override
    public void getProblems(String idTeacher, String idProblemsGroup, String token) {
        view.showProgress("Cargando problemas", "Cargando...");
        interactor.getProblems(idTeacher, idProblemsGroup, token);
    }

    @Override
    public void onSuccessGetProblems(List<Problem> problemList) {
        view.hideProgress();
        view.showProblems(problemList);
    }

    @Override
    public void onFailureGetProblems(String message) {
        view.hideProgress();
        view.showErrorToast(message);
        view.clearRecycler();
    }

    @Override
    public void onClickDeleteProblem(String idTeacher, String idProblemsGroup, String idProblem, String token) {
        view.showProgress("Eliminando problema", "Eliminando...");
        interactor.deleteProblem(idTeacher, idProblemsGroup, idProblem, token);
    }

    @Override
    public void onSuccessDeleteProblem(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
    }

    @Override
    public void onFailureDeleteProblem(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
