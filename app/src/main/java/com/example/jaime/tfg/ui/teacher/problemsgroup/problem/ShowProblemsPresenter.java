package com.example.jaime.tfg.ui.teacher.problemsgroup.problem;

import com.example.jaime.tfg.data.model.Problem;

import java.util.List;

/**
 * Created by Jaime on 13/12/2017.
 */

public interface ShowProblemsPresenter {
    void getProblems(String idTeacher, String idProblemsGroup, String token);
    void onSuccessGetProblems(List<Problem> problemList);
    void onFailureGetProblems(String message);

    void onClickDeleteProblem(String idTeacher, String idProblemsGroup, String idProblem, String token);
    void onSuccessDeleteProblem(String message);
    void onFailureDeleteProblem(String message);
}
