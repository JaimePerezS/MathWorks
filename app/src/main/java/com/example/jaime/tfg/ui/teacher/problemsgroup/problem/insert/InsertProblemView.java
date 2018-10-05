package com.example.jaime.tfg.ui.teacher.problemsgroup.problem.insert;

/**
 * Created by Jaime on 13/12/2017.
 */

public interface InsertProblemView {
    void showSuccessToast(String message);
    void showErrorToast(String message);

    void finish();

    void showProgress(String title, String message);
    void hideProgress();
}
