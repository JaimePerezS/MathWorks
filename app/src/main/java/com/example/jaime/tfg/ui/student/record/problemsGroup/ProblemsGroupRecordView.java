package com.example.jaime.tfg.ui.student.record.problemsGroup;

import com.example.jaime.tfg.data.model.ProblemsGroupRecord;

import java.util.List;

/**
 * Created by Jaime on 21/03/2018.
 */

public interface ProblemsGroupRecordView {
    void showProblemsGroupRecord(List<ProblemsGroupRecord> problemsGroupRecordList);

    void showErrorToast(String message);
}
