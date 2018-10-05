package com.example.jaime.tfg.ui.teacher.classroom.insert;

/**
 * Created by Jaime on 03/12/2017.
 */

public interface InsertClassroomView {

    void showSuccessToast(String message);
    void showErrorToast(String message);

    void finish();

    void showProgress(String title, String message);
    void hideProgress();
}
