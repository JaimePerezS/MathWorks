package com.example.jaime.tfg.ui.teacher.classroom.student.progress.operationsGroup;

import com.example.jaime.tfg.data.model.OperationsRecord;

import java.util.List;

public interface ShowOperationsRecordTeacherPresenter {
    void getOperationsRecord(String idTeacher, String idClassroom, String idStudent, String idOperationsGroup, String idRecord, String token);

    void onSuccessGetOperationsRecord(List<OperationsRecord> operationsRecordList);
    void onFailureGetOperationsRecord(String message);
}
