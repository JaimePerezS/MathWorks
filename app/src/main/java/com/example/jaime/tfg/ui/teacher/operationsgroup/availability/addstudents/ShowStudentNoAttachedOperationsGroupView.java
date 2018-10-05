package com.example.jaime.tfg.ui.teacher.operationsgroup.availability.addstudents;

import com.example.jaime.tfg.data.model.Student;

import java.util.List;

/**
 * Created by Jaime on 06/03/2018.
 */

public interface ShowStudentNoAttachedOperationsGroupView {
    void showStudentsNoAttached(List<Student> students);

    void showSuccessToast(String message);
    void showErrorToast(String message);

    void showProgress(String title, String message);
    void hideProgress();

    void clearRecycler();
}
