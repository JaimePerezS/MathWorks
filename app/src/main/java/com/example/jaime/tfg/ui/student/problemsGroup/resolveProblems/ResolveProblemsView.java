package com.example.jaime.tfg.ui.student.problemsGroup.resolveProblems;

import com.example.jaime.tfg.data.model.Problem;

import java.util.List;

/**
 * Created by Jaime on 11/02/2018.
 */

public interface ResolveProblemsView {
    void loadProblems(List<Problem> problems);

    void showErrorToast(String message);
    void showSuccessToast(String message);

    void showProgress(String title, String message);
    void hideProgress();

    void finish();
}
