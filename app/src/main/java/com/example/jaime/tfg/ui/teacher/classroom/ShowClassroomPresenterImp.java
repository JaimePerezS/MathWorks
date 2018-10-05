package com.example.jaime.tfg.ui.teacher.classroom;

import com.example.jaime.tfg.data.interactor.teacher.classroom.ShowClassroomInteractorImp;
import com.example.jaime.tfg.data.model.Classroom;

import java.util.List;

/**
 * Created by Jaime on 03/12/2017.
 */

public class ShowClassroomPresenterImp implements ShowClassroomPresenter {

    private ShowClassroomView view;
    private ShowClassroomInteractorImp interactor;

    public ShowClassroomPresenterImp(ShowClassroomView view) {
        this.view = view;
        this.interactor = new ShowClassroomInteractorImp(this);
    }

    @Override
    public void getClassrooms(String idTeacher, String token) {
        view.showProgress("Cargando clases", "Cargando...");
        interactor.getClassrooms(idTeacher, token);
    }

    @Override
    public void onClickDeleteClassroom(String idTeacher, String idClassroom, String token) {
        view.showProgress("Eliminando clase", "Eliminando...");
        interactor.deleteClassroom(idTeacher, idClassroom, token);
    }

    @Override
    public void onSuccessGetClassrooms(List<Classroom> classroomList) {
        view.hideProgress();
        view.showClassrooms(classroomList);
    }

    @Override
    public void onFailureGetClassrooms(String message) {
        view.hideProgress();
        view.showErrorToast(message);
        view.clearRecycler();
    }

    @Override
    public void onSuccessDeleteClassroom(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
    }

    @Override
    public void onFailureDeleteClassroom(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
