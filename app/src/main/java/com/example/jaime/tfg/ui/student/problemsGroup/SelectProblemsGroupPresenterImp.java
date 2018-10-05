package com.example.jaime.tfg.ui.student.problemsGroup;

import com.example.jaime.tfg.data.interactor.student.problemsGroup.SelectProblemsGroupInteractorImp;
import com.example.jaime.tfg.data.model.ProblemsGroup;

import java.util.List;

/**
 * Created by Jaime on 11/01/2018.
 */

public class SelectProblemsGroupPresenterImp implements SelectProblemsGroupPresenter{
    private SelectProblemsGroupView view;
    private SelectProblemsGroupInteractorImp interactor;

    public SelectProblemsGroupPresenterImp(SelectProblemsGroupView view) {
        this.view = view;
        this.interactor = new SelectProblemsGroupInteractorImp(this);
    }

    @Override
    public void getProblemsGroups(String idStudent, String token) {
        view.showProgress("Cargando grupos de problemas", "Cargando...");
        interactor.getProblemsGroups(idStudent, token);
    }

    @Override
    public void onSuccessGetProblemsGroups(List<ProblemsGroup> problemsGroupList) {
        view.hideProgress();
        view.showProblemsGroup(problemsGroupList);
    }

    @Override
    public void onFailureGetProblemsGroups(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
