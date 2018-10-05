package com.example.jaime.tfg.ui.teacher.problemsgroup.availability;

import com.example.jaime.tfg.data.model.Student;

import java.util.List;

/**
 * Created by Jaime on 01/03/2018.
 */

public interface StudentsPresenter {
    void getStudentsAttached(String idTeacher, String idClassroom, String idProblemsGroup, String token);
    void onSuccessGetStudentsAttached(List<Student> studentList);
    void onFailureGetStudentsAttached(String message);

    void onClickHideAvailability(String idTeacher, String idProblemsGroup, String idClassroom, String idStudent, String token);
    void onSuccessHideAvailability(String message);
    void onFailureHideAvailability(String message);
}
