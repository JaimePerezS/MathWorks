package com.example.jaime.tfg.ui.teacher.classroom.edit;

/**
 * Created by Jaime on 02/12/2017.
 */

public interface EditClassroomPresenter {

    void onUpdateClassroomClick(String newName, String idTeacher, String idClassroom, String idUuid);

    void onUpdateClassroomSuccess(String message);
    void onUpdateClassroomFailure(String message);
}
