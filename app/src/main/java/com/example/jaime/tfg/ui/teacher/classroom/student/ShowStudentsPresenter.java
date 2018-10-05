package com.example.jaime.tfg.ui.teacher.classroom.student;

import com.example.jaime.tfg.data.model.Student;

import java.util.List;

/**
 * Created by Jaime on 04/12/2017.
 */

public interface ShowStudentsPresenter {

    void getStudents(String idTeacher, String idClassroom, String token);
    void onSuccessGetStudents(List<Student> studentList);
    void onFailureGetStudents(String message);

    void deleteStudent(String idStudent, String idTeacher, String idClassroom, String token);
    void onSuccessDeleteStudent(String message);
    void onFailureDeleteStudent(String message);
}
