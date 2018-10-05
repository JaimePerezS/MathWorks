package com.example.jaime.tfg.ui.teacher.problemsgroup.edit;

/**
 * Created by Jaime on 09/12/2017.
 */

public interface EditProblemsGroupPresenter {
    void onClickUpdateProblem(String newName, String newDifficulty, String idTeacher, String idProblemsGroup, String token);
    void onSuccessUpdateProblem(String message);
    void onFailureUpdateProblem(String message);
}
