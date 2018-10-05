package com.example.jaime.tfg.ui.teacher.operationsgroup.insert;

/**
 * Created by Jaime on 06/12/2017.
 */

public interface InsertOperationsGroupPresenter {
    void onClickInsertOperationsGroup(String name, String difficulty, String idTeacher, String token);

    void onSuccessInsertOperationsGroup(String message);
    void onFailureInsertOperationsGroup(String message);
}
