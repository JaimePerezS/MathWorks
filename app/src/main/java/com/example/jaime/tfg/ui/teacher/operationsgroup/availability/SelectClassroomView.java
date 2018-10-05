package com.example.jaime.tfg.ui.teacher.operationsgroup.availability;

import com.example.jaime.tfg.data.model.Classroom;

import java.util.List;

/**
 * Created by Jaime on 23/01/2018.
 */

public interface SelectClassroomView {
    void showClassrooms(List<Classroom> classrooms);

    void showSuccessToast(String message);
    void showErrorToast(String message);

    void showProgress(String title, String message);
    void hideProgress();
}
