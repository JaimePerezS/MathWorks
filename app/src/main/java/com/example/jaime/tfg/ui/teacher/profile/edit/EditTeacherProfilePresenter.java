package com.example.jaime.tfg.ui.teacher.profile.edit;

/**
 * Created by Jaime on 04/12/2017.
 */

public interface EditTeacherProfilePresenter {
    void onClickUpdateTeacher(String newName, String newSurname, String idTeacher, String token);

    void onSuccessUpdateTeacher(String message);
    void onFailureUpdateTeacher(String message);
}
