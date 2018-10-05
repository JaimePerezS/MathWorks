package com.example.jaime.tfg.ui.main.fragment;

import android.content.Context;

/**
 * Created by Jaime on 03/12/2017.
 */

public interface LoginTeachersView {

    void showErrorToast(String message);

    void showProgress(String title, String message);
    void hideProgress();

    void navigateToMainTeacher();
    Context getContext();
}
