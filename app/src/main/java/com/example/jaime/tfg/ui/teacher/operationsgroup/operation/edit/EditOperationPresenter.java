package com.example.jaime.tfg.ui.teacher.operationsgroup.operation.edit;

/**
 * Created by Jaime on 06/12/2017.
 */

public interface EditOperationPresenter {
    void OnClickUpdateOperation(String newStatement, int newPoints, String idTeacher, String idOperationsGroup, String idOperation, String token);
    void onSuccessUpdateOperation(String message);
    void onFailureUpdateOperation(String message);
}
