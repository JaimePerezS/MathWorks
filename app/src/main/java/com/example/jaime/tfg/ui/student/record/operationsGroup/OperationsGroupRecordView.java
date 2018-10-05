package com.example.jaime.tfg.ui.student.record.operationsGroup;

import com.example.jaime.tfg.data.model.OperationsGroupRecord;

import java.util.List;

/**
 * Created by Jaime on 21/03/2018.
 */

public interface OperationsGroupRecordView {
    void showOperationsGroupRecord(List<OperationsGroupRecord> operationsGroupRecordList);

    void showErrorToast(String message);
}
