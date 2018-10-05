package com.example.jaime.tfg.ui.teacher.problemsgroup.problem.edit;

import com.example.jaime.tfg.data.interactor.teacher.problemsgroup.problem.edit.EditProblemInteractorImp;

/**
 * Created by Jaime on 13/12/2017.
 */

public class EditProblemPresenterImp implements EditProblemPresenter {
    private EditProblemView view;
    private EditProblemInteractorImp interactor;

    public EditProblemPresenterImp(EditProblemView view) {
        this.view = view;
        this.interactor = new EditProblemInteractorImp(this);
    }

    @Override
    public void onClickUpdateProblem(String newStatement, int newPoints, String newOperation, String newHelp, String newOperationType, String idTeacher, String idProblemsGroup, String idProblem, String token) {
        view.showProgress("Actualizando problema", "Guardando cambios...");
        interactor.updateProblem(newStatement, newOperation, newPoints, newHelp, newOperationType, idTeacher, idProblemsGroup, idProblem, token);
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
