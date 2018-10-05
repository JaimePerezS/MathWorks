package com.example.jaime.tfg.ui.teacher.classroom.student.edit;

/**
 * Created by Jaime on 04/12/2017.
 */

public interface EditStudentView {
    void showSuccessToast(String message);
    void showErrorToast(String message);

    void finish();

    void showProgress(String title, String message);
    void hideProgress();
}
