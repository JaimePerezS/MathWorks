package com.example.jaime.tfg.ui.teacher.classroom.student.progress.operationsGroup;

import com.example.jaime.tfg.data.model.OperationsRecord;

import java.util.List;

public interface ShowOperationsRecordTeacherView {
    void showOperationsRecord(List<OperationsRecord> operationsRecordList);

    void showErrorToast(String message);

    void showProgress(String title, String message);
    void hideProgress();
}
