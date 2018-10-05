package com.example.jaime.tfg.ui.teacher.operationsgroup.operation.insert;

/**
 * Created by Jaime on 06/12/2017.
 */

public interface InsertOperationPresenter {
    void onClickInsertOperation(String statement, int points, String idTeacher, String idOperationsGroup, String token);

    void onSuccessInsertOperation(String message);
    void onFailureInsertOperation(String message);
}
