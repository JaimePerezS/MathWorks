package com.example.jaime.tfg.ui.teacher.problemsgroup.availability;

import com.example.jaime.tfg.data.interactor.teacher.problemsgroup.availability.StudentsInteractorImp;
import com.example.jaime.tfg.data.model.Student;

import java.util.List;

/**
 * Created by Jaime on 01/03/2018.
 */

public class StudentsPresenterImp implements StudentsPresenter{

    private StudentsView view;
    private StudentsInteractorImp interactor;

    public StudentsPresenterImp(StudentsView view) {
        this.view = view;
        this.interactor = new StudentsInteractorImp(this);
    }

    @Override
    public void getStudentsAttached(String idTeacher, String idClassroom, String idProblemsGroup, String token) {
        view.showProgress("Cargando alumnos", "Cargando...");
        interactor.getStudentsAttached(idTeacher, idClassroom, idProblemsGroup, token);
    }

    @Override
    public void onSuccessGetStudentsAttached(List<Student> studentList) {
        view.hideProgress();
        view.showStudents(studentList);
    }

    @Override
    public void onFailureGetStudentsAttached(String message) {
        view.hideProgress();
        view.showErrorToast(message);
        view.clearRecycler();
    }

    @Override
    public void onClickHideAvailability(String idTeacher, String idProblemsGroup, String idClassroom, String idStudent, String token) {
        view.showProgress("Realizando operación", "Guardando cambios...");
        interactor.hideAvailability(idTeacher, idProblemsGroup, idClassroom, idStudent, token);
    }

    @Override
    public void onSuccessHideAvailability(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
    }

    @Override
    public void onFailureHideAvailability(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
