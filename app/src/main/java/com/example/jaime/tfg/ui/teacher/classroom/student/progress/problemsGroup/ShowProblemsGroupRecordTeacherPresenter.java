package com.example.jaime.tfg.ui.teacher.classroom.student.progress.problemsGroup;

import com.example.jaime.tfg.data.model.ProblemsGroupRecord;

import java.util.List;

public interface ShowProblemsGroupRecordTeacherPresenter {
    void getProblemsGroupRecord(String idTeacher, String idClassroom, String idStudent, String token);

    void onSuccessGetProblemsGroupRecord(List<ProblemsGroupRecord> problemsGroupRecordList);
    void onFailureGetProblemsGroupRecord(String message);
}
