package com.example.jaime.tfg.ui.teacher.classroom.insert;

/**
 * Created by Jaime on 03/12/2017.
 */

public interface InsertClassroomPresenter {

    void onClickInsertClassroom(String name, String idTeacher, String idUuid);

    void onSuccessInsertClassroom(String message);
    void onFailureInsertClassroom(String message);

}
