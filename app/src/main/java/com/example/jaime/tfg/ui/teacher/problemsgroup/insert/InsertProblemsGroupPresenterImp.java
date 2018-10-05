package com.example.jaime.tfg.ui.teacher.problemsgroup.insert;

import com.example.jaime.tfg.data.interactor.teacher.problemsgroup.insert.InsertProblemsGroupInteractorImp;

/**
 * Created by Jaime on 09/12/2017.
 */

public class InsertProblemsGroupPresenterImp implements InsertProblemsGroupPresenter {
    private InsertProblemsGroupView view;
    private InsertProblemsGroupInteractorImp interactor;

    public InsertProblemsGroupPresenterImp(InsertProblemsGroupView view) {
        this.view = view;
        this.interactor = new InsertProblemsGroupInteractorImp(this);
    }

    @Override
    public void onClickInsertProblemsGroup(String newName, String newDifficulty, String idTeacher, String token) {
        view.showProgress("Guardando nuevo problema", "Guardando...");
        interactor.insertProblemsGroup(newName, newDifficulty, idTeacher, token);
    }

    @Override
    public void onSuccessInsertProblemsGroup(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
        view.finish();
    }

    @Override
    public void onFailureInsertProblemsGroup(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
