package com.example.jaime.tfg.ui.student.problemsGroup;

import com.example.jaime.tfg.data.model.ProblemsGroup;

import java.util.List;

/**
 * Created by Jaime on 11/01/2018.
 */

public interface SelectProblemsGroupPresenter {
    void getProblemsGroups(String idStudent, String token);

    void onSuccessGetProblemsGroups(List<ProblemsGroup> problemsGroupList);
    void onFailureGetProblemsGroups(String message);
}
