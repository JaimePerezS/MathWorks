package com.example.jaime.tfg.ui.teacher.problemsgroup.availability.addStudents;

import com.example.jaime.tfg.data.interactor.teacher.problemsgroup.availability.addStudents.ShowStudentNoAttachedProblemsGroupInteractorImp;
import com.example.jaime.tfg.data.model.Student;

import java.util.List;

/**
 * Created by Jaime on 06/03/2018.
 */

public class ShowStudentNoAttachedProblemsGroupPresenterImp implements ShowStudentNoAttachedProblemsGroupPresenter {

    private ShowStudentNoAttachedProblemsGroupView view;
    private ShowStudentNoAttachedProblemsGroupInteractorImp interactor;

    public ShowStudentNoAttachedProblemsGroupPresenterImp(ShowStudentNoAttachedProblemsGroupView view) {
        this.view = view;
        this.interactor = new ShowStudentNoAttachedProblemsGroupInteractorImp(this);
    }

    @Override
    public void getStudentsNoAttachedProblemsGroup(String idTeacher, String idClassroom, String idProblemsGroup, String token) {
        view.showProgress("Obteniendo alumnos", "Cargando...");
        interactor.getStudentsNoAttachedProblemsGroup(idTeacher, idClassroom, idProblemsGroup, token);
    }

    @Override
    public void onSuccessGetStudentsNoAttachedProblemsGroup(List<Student> studentList) {
        view.hideProgress();
        view.showStudentsNoAttached(studentList);
    }

    @Override
    public void onFailureGetStudentsNoAttachedProblemsGroup(String message) {
        view.hideProgress();
        view.showErrorToast(message);
        view.clearRecycler();
    }

    @Override
    public void onClickAddVisibility(String idTeacher, String idProblemsGroup, String idClassroom, String idStudent, String token) {
        view.showProgress("Realizando operación", "Guardando cambios...");
        interactor.addVisibility(idTeacher, idProblemsGroup, idClassroom, idStudent, token);
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
