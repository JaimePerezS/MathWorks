package com.example.jaime.tfg.ui.teacher.operationsgroup.availability.addstudents;

import com.example.jaime.tfg.data.model.Student;

import java.util.List;

/**
 * Created by Jaime on 06/03/2018.
 */

public interface ShowStudentNoAttachedOperationsGroupPresenter {
    void getStudentsNoAttachedOperationsGroup(String idTeacher, String idClassroom, String idOperationsGrup, String token);
    void onSuccessGetStudentsNoAttachedOperationsGroup(List<Student> studentList);
    void onFailureGetStudentsNoAttachedOperationsGroup(String message);

    void addVisibility(String idTeacher, String idOperationsGroup, String idClassroom, String idStudent, String token);
    void onSuccessAddVisibility(String message);
    void onFailureAddVisibility(String message);
}
