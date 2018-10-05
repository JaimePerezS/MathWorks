package com.example.jaime.tfg.ui.main.fragment;

import com.example.jaime.tfg.data.interactor.main.SignInInteratorImp;
import com.example.jaime.tfg.data.remote.ApiService;

/**
 * Created by Jaime on 03/12/2017.
 */

public class SignInPresenterImp implements SignInPresenter {

    private SignInView view;
    private SignInInteratorImp interactor;
    private ApiService apiService;

    public SignInPresenterImp(SignInView view) {
        this.view = view;
        this.interactor = new SignInInteratorImp(this);
    }

    @Override
    public void sigIn(String name, String surname, String email, String password) {
        view.showProgress("Registro", "Registrando usuario...");
        interactor.insertTeacher(name, surname, email, password);
    }

    @Override
    public void onSuccessSignIn(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
    }

    @Override
    public void onFailureSignIn(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
