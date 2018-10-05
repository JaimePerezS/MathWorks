package com.example.jaime.tfg.ui.teacher.classroom.student.progress.operationsGroup;

import com.example.jaime.tfg.data.model.OperationsGroupRecord;

import java.util.List;

public interface ShowOperationsGroupRecordView {
    void showOperationsGroupRecord(List<OperationsGroupRecord> operationsGroupRecordList);

    void showErrorToast(String message);

    void showProgress(String title, String message);
    void hideProgress();
}
