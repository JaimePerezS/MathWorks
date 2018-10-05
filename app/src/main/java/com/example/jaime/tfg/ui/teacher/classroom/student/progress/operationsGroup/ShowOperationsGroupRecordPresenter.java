package com.example.jaime.tfg.ui.teacher.classroom.student.progress.operationsGroup;

import com.example.jaime.tfg.data.model.OperationsGroupRecord;

import java.util.List;

public interface ShowOperationsGroupRecordPresenter {
    void getOperationsGroupRecord(String idTeacher, String idClassroom, String idStudent, String token);

    void onSuccessGetOperationsGroupRecord(List<OperationsGroupRecord> operationsGroupRecordList);
    void onFailureGetOperationsGroupRecord(String message);
}
