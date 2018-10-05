package com.example.jaime.tfg.ui.main.fragment;

/**
 * Created by Jaime on 03/12/2017.
 */

public interface SignInPresenter {

    void sigIn(String name, String surname, String email, String password);

    void onSuccessSignIn(String message);
    void onFailureSignIn(String message);
}
