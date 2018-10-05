package com.example.jaime.tfg.ui.teacher.operationsgroup.availability;

import com.example.jaime.tfg.data.interactor.teacher.operationsGroup.availability.SelectClassroomInteractorImp;
import com.example.jaime.tfg.data.model.Classroom;

import java.util.List;

/**
 * Created by Jaime on 23/01/2018.
 */

public class SelectClassroomPresenterImp implements SelectClassroomPresenter {
    private SelectClassroomView view;
    private SelectClassroomInteractorImp interactor;

    public SelectClassroomPresenterImp(SelectClassroomView view) {
        this.view = view;
        this.interactor = new SelectClassroomInteractorImp(this);
    }

    @Override
    public void getClassrooms(String idTeacher, String token) {
       view.showProgress("Cargando clases", "Cargando...");
       interactor.getClassrooms(idTeacher, token);
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
    }
}
