package com.example.jaime.tfg.ui.teacher.classroom.student.progress.problemsGroup;

import com.example.jaime.tfg.data.model.ProblemsGroupRecord;

import java.util.List;

public interface ShowProblemsGroupRecordTeacherView {
    void showProblemsGroupRecord(List<ProblemsGroupRecord> problemsGroupRecordList);

    void showErrorToast(String messsage);

    void showProgress(String title, String message);
    void hideProgress();
}
