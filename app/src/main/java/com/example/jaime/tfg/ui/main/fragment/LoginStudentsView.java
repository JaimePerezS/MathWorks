package com.example.jaime.tfg.ui.main.fragment;

import android.content.Context;

/**
 * Created by Jaime on 15/12/2017.
 */

public interface LoginStudentsView {
    Context getContext();
    void navigateToMainStudent();

    void showProgress(String title, String message);
    void hideProgress();

    void showErrorToast(String message);
}
