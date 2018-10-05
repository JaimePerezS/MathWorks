package com.example.jaime.tfg.ui.teacher.operationsgroup.availability;

import com.example.jaime.tfg.data.model.Student;

import java.util.List;

/**
 * Created by Jaime on 01/03/2018.
 */

public interface StudentsView {
    void showStudents(List<Student> studentList);

    void showErrorToast(String message);
    void showSuccessToast(String message);

    void showProgress(String title, String message);
    void hideProgress();

    void clearRecycler();
}
