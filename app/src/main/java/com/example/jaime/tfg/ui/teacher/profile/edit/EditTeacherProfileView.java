package com.example.jaime.tfg.ui.teacher.profile.edit;

/**
 * Created by Jaime on 04/12/2017.
 */

public interface EditTeacherProfileView {
    void showSuccessToast(String message);
    void showErrorToast(String message);

    void finish();

    void showProgress(String title, String message);
    void hideProgress();
}
