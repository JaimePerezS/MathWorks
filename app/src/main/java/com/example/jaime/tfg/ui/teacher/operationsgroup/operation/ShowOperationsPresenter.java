package com.example.jaime.tfg.ui.teacher.operationsgroup.operation;

import com.example.jaime.tfg.data.model.Operation;

import java.util.List;

/**
 * Created by Jaime on 06/12/2017.
 */

public interface ShowOperationsPresenter {
    void getOperations(String idTeacher, String idOperationsGroup, String token);
    void onSuccessGetOperations(List<Operation> operationList);
    void onFailureGetOperations(String message);

    void onClickDeleteOperation(String idTeacher, String idOperationsGroup, String idOperation, String token);
    void onSuccessDeleteOperation(String message);
    void onFailureDeleteOperation(String message);

}
