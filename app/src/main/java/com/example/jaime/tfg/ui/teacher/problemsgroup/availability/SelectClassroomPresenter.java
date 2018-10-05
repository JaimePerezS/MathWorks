package com.example.jaime.tfg.ui.teacher.problemsgroup.availability;

import com.example.jaime.tfg.data.model.Classroom;

import java.util.List;

/**
 * Created by Jaime on 23/01/2018.
 */

public interface SelectClassroomPresenter {
    void getClassrooms(String idTeacher, String token);

    void onSuccessGetClassrooms(List<Classroom> classroomList);
    void onFailureGetClassrooms(String message);
}
