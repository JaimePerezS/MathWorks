package com.example.jaime.tfg.ui.teacher.classroom.student;

import com.example.jaime.tfg.data.model.Student;

import java.util.List;

/**
 * Created by Jaime on 04/12/2017.
 */

public interface ShowStudentsView {
    void showStudents(List<Student> students);

    void showSuccessToast(String message);
    void showErrorToast(String message);

    void showProgress(String title, String message);
    void hideProgress();

    void clearRecycler();
}
