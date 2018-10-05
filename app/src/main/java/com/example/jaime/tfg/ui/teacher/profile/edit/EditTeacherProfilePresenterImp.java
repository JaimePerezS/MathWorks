package com.example.jaime.tfg.ui.teacher.profile.edit;

import com.example.jaime.tfg.data.interactor.teacher.profile.edit.EditTeacherProfileInteractorImp;

/**
 * Created by Jaime on 04/12/2017.
 */

public class EditTeacherProfilePresenterImp implements EditTeacherProfilePresenter{
    private EditTeacherProfileView view;
    private EditTeacherProfileInteractorImp interactor;

    public EditTeacherProfilePresenterImp(EditTeacherProfileView view) {
        this.view = view;
        this.interactor = new EditTeacherProfileInteractorImp(this);
    }

    @Override
    public void onClickUpdateTeacher(String newName, String newSurname, String idTeacher, String token) {
        view.showProgress("Actualizando perfil", "Actualizando...");
        interactor.updateTeacher(newName, newSurname, idTeacher, token);
    }

    @Override
    public void onSuccessUpdateTeacher(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
        view.finish();
    }

    @Override
    public void onFailureUpdateTeacher(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
