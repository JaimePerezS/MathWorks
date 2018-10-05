package com.example.jaime.tfg.ui.teacher.problemsgroup.insert;

/**
 * Created by Jaime on 09/12/2017.
 */

public interface InsertProblemsGroupPresenter {
    void onClickInsertProblemsGroup(String newName, String newDifficulty, String idTeacher, String token);

    void onSuccessInsertProblemsGroup(String message);
    void onFailureInsertProblemsGroup(String message);
}
