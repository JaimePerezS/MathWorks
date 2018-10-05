package com.example.jaime.tfg.ui.student.operationsGroup.resolveOperations;

import com.example.jaime.tfg.data.model.Operation;
import com.example.jaime.tfg.data.model.OperationsRecord;

import java.util.List;

/**
 * Created by Jaime on 06/02/2018.
 */

public interface ResolveOperationsPresenter {
    void getOperations(String idStudent, String idOperationsGroup, String token);
    void onSuccessGetOperations(List<Operation> operationList);
    void onFailureGetOperations(String message);

    void updatePoints(String idStudent, int points, String token);
    void onFailureUpdatePoints(String message);

    void insertOperationsGroupRecord(String date, int points, List<OperationsRecord> operationsRecordList, String idStudent, String idOperationsGroup, String token);
    void onSuccessInsertOperationsGroupRecord(String message);
    void onFailureInsertOperationsGroupRecord(String message);
}
