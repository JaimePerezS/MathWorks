package com.example.jaime.tfg.ui.student.problemsGroup.resolveProblems;

import com.example.jaime.tfg.data.model.Problem;
import com.example.jaime.tfg.data.model.ProblemsRecord;

import java.util.List;

/**
 * Created by Jaime on 11/02/2018.
 */

public interface ResolveProblemsPresenter {
    void getProblems(String idStudent, String idProblemsGroup, String token);
    void onSuccessGetProblems(List<Problem> problemList);
    void onFailureGetProblems(String message);

    void updatePoints(String idStudent, int points, String token);
    void onFailureUpdatePoints(String message);

    void insertProblemsGroupRecord(String date, int points, List<ProblemsRecord> problemsRecordList, String student, String idProblemsGroup, String token);
    void onSuccessInsertProblemsGroupRecord(String message);
    void onFailureInsertProblemsGroupRecord(String message);
}
