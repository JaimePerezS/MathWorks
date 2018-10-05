package com.example.jaime.tfg.ui.main.fragment;

import com.example.jaime.tfg.data.model.Teacher;

/**
 * Created by Jaime on 03/12/2017.
 */

public interface LoginTeachersPresenter {

    void validateCredentials(String email, String password);

    void onSuccessLogin(Teacher teacher);
    void onFailureLogin(String message);
}
