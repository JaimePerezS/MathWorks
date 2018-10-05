package com.example.jaime.tfg.ui.teacher.classroom;

import com.example.jaime.tfg.data.model.Classroom;

import java.util.List;

/**
 * Created by Jaime on 03/12/2017.
 */

public interface ShowClassroomPresenter {

    void getClassrooms(String idTeacher, String token);
    void onClickDeleteClassroom(String idTeacher, String idClassroom, String token);

    void onSuccessGetClassrooms(List<Classroom> classroomList);
    void onFailureGetClassrooms(String message);

    void onSuccessDeleteClassroom(String message);
    void onFailureDeleteClassroom(String message);
}
