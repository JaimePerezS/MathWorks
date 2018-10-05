package com.example.jaime.tfg.ui.teacher.operationsgroup.availability.addstudents;

import com.example.jaime.tfg.data.interactor.teacher.operationsGroup.availability.addStudents.ShowStudentNoAttachedOperationsGroupInteractorImp;
import com.example.jaime.tfg.data.model.Student;

import java.util.List;

/**
 * Created by Jaime on 06/03/2018.
 */

public class ShowStudentNoAttachedOperationsGroupPresenterImp implements ShowStudentNoAttachedOperationsGroupPresenter {

    private ShowStudentNoAttachedOperationsGroupView view;
    private ShowStudentNoAttachedOperationsGroupInteractorImp interactor;

    public ShowStudentNoAttachedOperationsGroupPresenterImp(ShowStudentNoAttachedOperationsGroupView view) {
        this.view = view;
        this.interactor = new ShowStudentNoAttachedOperationsGroupInteractorImp(this);
    }

    @Override
    public void getStudentsNoAttachedOperationsGroup(String idTeacher, String idClassroom, String idOperationsGrup, String token) {
        view.showProgress("Cargando alumnos", "Cargando...");
        interactor.getStudentsNoAttachedOperationsGroup(idTeacher, idClassroom, idOperationsGrup, token);
    }

    @Override
    public void onSuccessGetStudentsNoAttachedOperationsGroup(List<Student> studentList) {
        view.hideProgress();
        view.showStudentsNoAttached(studentList);
    }

    @Override
    public void onFailureGetStudentsNoAttachedOperationsGroup(String message) {
        view.hideProgress();
        view.showErrorToast(message);
        view.clearRecycler();
    }

    @Override
    public void addVisibility(String idTeacher, String idOperationsGroup, String idClassroom, String idStudent, String token) {
        view.showProgress("Realizando operación","Guardando cambios...");
        interactor.addVisibility(idTeacher, idOperationsGroup, idClassroom, idStudent, token);
    }

    @Override
    public void onSuccessAddVisibility(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
    }

    @Override
    public void onFailureAddVisibility(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
