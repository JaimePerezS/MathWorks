package com.example.jaime.tfg.ui.teacher.classroom.student.progress.problemsGroup;

import com.example.jaime.tfg.data.model.ProblemsRecord;

import java.util.List;

public interface ShowProblemsRecordTeacherView {
    void showProblemsRecord(List<ProblemsRecord> problemsRecords);

    void showErrorToast(String message);

    void showProgress(String title, String message);
    void hideProgress();
}
