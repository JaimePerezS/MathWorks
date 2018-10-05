package com.example.jaime.tfg.ui.main.fragment;

import com.example.jaime.tfg.data.model.Student;

/**
 * Created by Jaime on 15/12/2017.
 */

public interface LoginStudentsPresenter {
    void validateCredentials(String idStudent);
    void onSuccessLogin(Student session);
    void onFailureLogin(String message);
}
