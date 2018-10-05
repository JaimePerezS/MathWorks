package com.example.jaime.tfg.ui.teacher.problemsgroup.availability.addStudents;

import com.example.jaime.tfg.data.model.Student;

import java.util.List;

/**
 * Created by Jaime on 06/03/2018.
 */

public interface ShowStudentNoAttachedProblemsGroupPresenter {
    void getStudentsNoAttachedProblemsGroup(String idTeacher, String idClassroom, String idProblemsGroup, String token);
    void onSuccessGetStudentsNoAttachedProblemsGroup(List<Student> studentList);
    void onFailureGetStudentsNoAttachedProblemsGroup(String message);

    void onClickAddVisibility(String idTeacher, String idProblemsGroup, String idClassroom, String idStudent, String token);
    void onSuccessAddVisibility(String message);
    void onFailureAddVisibility(String message);
}
