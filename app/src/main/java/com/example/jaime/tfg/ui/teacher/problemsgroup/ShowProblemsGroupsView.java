package com.example.jaime.tfg.ui.teacher.problemsgroup;

import com.example.jaime.tfg.data.model.ProblemsGroup;

import java.util.List;

/**
 * Created by Jaime on 12/12/2017.
 */

public interface ShowProblemsGroupsView {
    void showProblemsGroup(List<ProblemsGroup> problemsGroup);

    void showSuccessToast(String message);
    void showErrorToast(String message);

    void showProgress(String title, String message);
    void hideProgress();

    void clearRecycler();
}
