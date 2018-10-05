package com.example.jaime.tfg.ui.student.firstAvatarSelection;

/**
 * Created by Jaime on 19/01/2018.
 */

public interface FirstSelectAvatarView {
    void showSuccessToast(String messsage);
    void showErrorToast(String message);

    void finish();

    void showProgress(String title, String message);
    void hideProgress();
}
