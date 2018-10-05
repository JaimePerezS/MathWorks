package com.example.jaime.tfg.ui.teacher.problemsgroup.problem;

import com.example.jaime.tfg.data.model.Problem;

import java.util.List;

/**
 * Created by Jaime on 13/12/2017.
 */

public interface ShowProblemsView {
    void showProblems(List<Problem> problems);

    void showSuccessToast(String message);
    void showErrorToast(String message);

    void showProgress(String title, String message);
    void hideProgress();

    void clearRecycler();
}
