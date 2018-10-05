package com.example.jaime.tfg.ui.teacher.classroom;

import com.example.jaime.tfg.data.model.Classroom;

import java.util.List;

/**
 * Created by Jaime on 03/12/2017.
 */

public interface ShowClassroomView {
    void showClassrooms(List<Classroom> classrooms);

    void showSuccessToast(String message);
    void showErrorToast(String message);

    void showProgress(String title, String message);
    void hideProgress();

    void clearRecycler();
}
