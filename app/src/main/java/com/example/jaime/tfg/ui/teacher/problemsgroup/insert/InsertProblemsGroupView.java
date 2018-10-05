package com.example.jaime.tfg.ui.teacher.problemsgroup.insert;

/**
 * Created by Jaime on 09/12/2017.
 */

public interface InsertProblemsGroupView {
    void showSuccessToast(String message);
    void showErrorToast(String message);

    void finish();

    void showProgress(String title, String message);
    void hideProgress();
}
