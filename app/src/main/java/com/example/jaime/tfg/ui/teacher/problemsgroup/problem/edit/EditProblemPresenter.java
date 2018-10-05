package com.example.jaime.tfg.ui.teacher.problemsgroup.problem.edit;

/**
 * Created by Jaime on 13/12/2017.
 */

public interface EditProblemPresenter {
    void onClickUpdateProblem(String newStatement, int newPoints, String newSolution, String newHelp, String newOperationType, String idTeacher, String idProblemsGroup, String idProblem, String token);

    void onSuccessUpdateProblem(String message);
    void onFailureUpdateProblem(String message);
}
