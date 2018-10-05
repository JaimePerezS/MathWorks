package com.example.jaime.tfg.ui.teacher.classroom.student;

import com.example.jaime.tfg.data.interactor.teacher.classroom.student.ShowStudentsInteractorImp;
import com.example.jaime.tfg.data.model.Student;

import java.util.List;

/**
 * Created by Jaime on 04/12/2017.
 */

public class ShowStudentsPresenterImp implements ShowStudentsPresenter{
    private ShowStudentsView view;
    private ShowStudentsInteractorImp interactor;

    public ShowStudentsPresenterImp(ShowStudentsView view) {
        this.view = view;
        this.interactor = new ShowStudentsInteractorImp(this);
    }

    @Override
    public void getStudents(String idTeacher, String idClassroom, String token) {
        view.showProgress("Obteniendo alumnos", "Cargando...");
        interactor.getStudents(idTeacher, idClassroom, token);
    }

    @Override
    public void onSuccessGetStudents(List<Student> studentList) {
        view.hideProgress();
        view.showStudents(studentList);
    }

    @Override
    public void onFailureGetStudents(String message) {
        view.hideProgress();
        view.showErrorToast(message);
        view.clearRecycler();
    }

    @Override
    public void deleteStudent(String idStudent, String idTeacher, String idClassroom, String token) {
        view.showProgress("Eliminando alumno", "Eliminando");
        interactor.deleteStudent(idStudent, idTeacher, idClassroom, token);
    }

    @Override
    public void onSuccessDeleteStudent(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
    }

    @Override
    public void onFailureDeleteStudent(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
