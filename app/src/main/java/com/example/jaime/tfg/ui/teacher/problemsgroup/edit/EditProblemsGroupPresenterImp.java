package com.example.jaime.tfg.ui.teacher.problemsgroup.edit;

import com.example.jaime.tfg.data.interactor.teacher.problemsgroup.edit.EditProblemsGroupInteractorImp;

/**
 * Created by Jaime on 09/12/2017.
 */

public class EditProblemsGroupPresenterImp implements EditProblemsGroupPresenter {
    private EditProblemsGroupView view;
    private EditProblemsGroupInteractorImp interactor;

    public EditProblemsGroupPresenterImp(EditProblemsGroupView view) {
        this.view = view;
        this.interactor = new EditProblemsGroupInteractorImp(this);
    }

    @Override
    public void onClickUpdateProblem(String newName, String newDifficulty, String idTeacher, String idProblemsGroup, String token) {
        view.showProgress("Actualizando problema", "Actualizando...");
        interactor.updateProblem(newName, newDifficulty, idTeacher, idProblemsGroup, token);
    }

    @Override
    public void onSuccessUpdateProblem(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
        view.finish();
    }

    @Override
    public void onFailureUpdateProblem(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
