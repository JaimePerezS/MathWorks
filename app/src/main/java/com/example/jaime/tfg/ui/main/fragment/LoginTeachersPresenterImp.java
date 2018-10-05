package com.example.jaime.tfg.ui.main.fragment;

import com.example.jaime.tfg.data.interactor.main.LoginTeachersInteractorImp;
import com.example.jaime.tfg.data.model.Teacher;

/**
 * Created by Jaime on 03/12/2017.
 */

public class LoginTeachersPresenterImp implements LoginTeachersPresenter {

    private LoginTeachersView view;
    private LoginTeachersInteractorImp interactor;

    public LoginTeachersPresenterImp(LoginTeachersView view) {
        this.view = view;
        interactor = new LoginTeachersInteractorImp(this);
    }

    @Override
    public void validateCredentials(String email, String password) {
        view.showProgress("Comprobando Credenciales", "Comprobando...");

        interactor.loginTeacher(email, password);
    }

    @Override
    public void onSuccessLogin(Teacher teacher) {
        interactor.createTeacherSession(teacher, view.getContext());

        view.hideProgress();
        view.navigateToMainTeacher();
    }

    @Override
    public void onFailureLogin(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
