package com.example.jaime.tfg.ui.teacher.classroom.student.edit;

/**
 * Created by Jaime on 04/12/2017.
 */

public interface EditStudentPresenter {
    void onClickEditStudent(String name, String surname, String idTeacher, String idClassroom, String idStudent, String token);

    void onSuccessEditStudent(String message);
    void onFailureEditStudent(String message);
}
