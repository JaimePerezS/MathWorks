package com.example.jaime.tfg.ui.student.problemsGroup;

import com.example.jaime.tfg.data.model.ProblemsGroup;

import java.util.List;

/**
 * Created by Jaime on 11/01/2018.
 */

public interface SelectProblemsGroupView {
    void showProblemsGroup(List<ProblemsGroup> problemsGroupList);
    void showErrorToast(String message);

    void showProgress(String title, String messsage);
    void hideProgress();
}
