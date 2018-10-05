package com.example.jaime.tfg.ui.teacher.problemsgroup;

import com.example.jaime.tfg.data.model.ProblemsGroup;

import java.util.List;

/**
 * Created by Jaime on 12/12/2017.
 */

public interface ShowProblemsGroupsPresenter {
    void getProblemsGroups(String idTeacher, String token);
    void onSuccessGetProblemsGroup(List<ProblemsGroup> problemsGroupList);
    void onFailureGetProblemsGroup(String message);

    void deleteProblemsGroup(String idTeacher, String idProblemsGroup, String token);
    void onSuccessDeleteProblemsGroup(String message);
    void onFailureDeleteProblemsGroup(String message);
}
