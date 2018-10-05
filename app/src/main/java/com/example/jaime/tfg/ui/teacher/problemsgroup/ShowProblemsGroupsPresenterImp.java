package com.example.jaime.tfg.ui.teacher.problemsgroup;

import com.example.jaime.tfg.data.interactor.teacher.problemsgroup.ShowProblemsGroupInteractorImp;
import com.example.jaime.tfg.data.model.ProblemsGroup;

import java.util.List;


/**
 * Created by Jaime on 12/12/2017.
 */

public class ShowProblemsGroupsPresenterImp implements ShowProblemsGroupsPresenter{
    private ShowProblemsGroupsView view;
    private ShowProblemsGroupInteractorImp interactor;

    public ShowProblemsGroupsPresenterImp(ShowProblemsGroupsView view) {
        this.view = view;
        this.interactor = new ShowProblemsGroupInteractorImp(this);
    }

    @Override
    public void getProblemsGroups(String idTeacher, String token) {
        view.showProgress("Cargando grupos de problemas", "Cargando...");
        interactor.getProblemsGroups(idTeacher, token);
    }

    @Override
    public void onSuccessGetProblemsGroup(List<ProblemsGroup> problemsGroupList) {
        view.hideProgress();
        view.showProblemsGroup(problemsGroupList);
    }

    @Override
    public void onFailureGetProblemsGroup(String message) {
        view.hideProgress();
        view.showErrorToast(message);
        view.clearRecycler();
    }

    @Override
    public void deleteProblemsGroup(String idTeacher, String idProblemsGroup, String token) {
        view.showProgress("Eliminando grupo de problemas", "Eliminando...");
        interactor.deleteProblemsGroup(idTeacher, idProblemsGroup, token);
    }

    @Override
    public void onSuccessDeleteProblemsGroup(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
    }

    @Override
    public void onFailureDeleteProblemsGroup(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
