package com.example.jaime.tfg.ui.teacher.classroom.edit;

/**
 * Created by Jaime on 02/12/2017.
 */

public interface EditClasroomView {

    void showSuccessToast(String message);
    void showErrorToast(String message);

    void finish();

    void showProgress(String title, String message);
    void hideProgress();
}
