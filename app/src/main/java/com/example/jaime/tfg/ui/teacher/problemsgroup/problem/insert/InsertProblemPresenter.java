package com.example.jaime.tfg.ui.teacher.problemsgroup.problem.insert;

/**
 * Created by Jaime on 13/12/2017.
 */

public interface InsertProblemPresenter {
    void onClickInsertProblem(String statement, String operation, int points, String help, String operationType, String idTeacher, String idProblemsGroup, String token);

    void onSuccessInsertProblem(String message);
    void onFailureInsertProblem(String message);
}
