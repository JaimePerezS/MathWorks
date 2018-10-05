package com.example.jaime.tfg.ui.teacher.classroom.student.progress.problemsGroup;

import com.example.jaime.tfg.data.model.ProblemsRecord;

import java.util.List;

public interface ShowProblemsRecordTeacherPresenter {
    void getProblemsRecord(String idTeacher, String idClassroom, String idStudent, String idProblemsGroup, String idRecord, String token);

    void onSuccessGetProblemsRecord(List<ProblemsRecord> problemsRecordList);
    void onFailureGetProblemsRecord(String message);
}
