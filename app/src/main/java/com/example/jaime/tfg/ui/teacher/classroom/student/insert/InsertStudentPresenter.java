package com.example.jaime.tfg.ui.teacher.classroom.student.insert;

/**
 * Created by Jaime on 04/12/2017.
 */

public interface InsertStudentPresenter {
    void onClickInsertStudent(String name, String surname, String idTeacher, String idClassroom, String token);

    void onSuccessInsertStudent(String message);
    void onFailureInsertStudent(String message);
}
