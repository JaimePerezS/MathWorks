package com.example.jaime.tfg.ui.main.fragment;

import com.example.jaime.tfg.data.interactor.main.LoginStudentsInteractorImp;
import com.example.jaime.tfg.data.local.StudentSessionManager;
import com.example.jaime.tfg.data.model.Student;

/**
 * Created by Jaime on 15/12/2017.
 */

public class LoginStudentsPresenterImp implements LoginStudentsPresenter {

    LoginStudentsView view;
    LoginStudentsInteractorImp interactor;
    private StudentSessionManager session;

    public LoginStudentsPresenterImp(LoginStudentsView view) {
        this.view = view;
        this.interactor = new LoginStudentsInteractorImp(this);
    }

    @Override
    public void validateCredentials(String idStudent) {
        view.showProgress("Comprobando Credenciales", "Comprobando...");
        interactor.loginStudent(idStudent);
    }

    @Override
    public void onSuccessLogin(Student student) {
        session = new StudentSessionManager(view.getContext());
        session.login(student);

        view.hideProgress();

        view.navigateToMainStudent();

    }

    @Override
    public void onFailureLogin(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
