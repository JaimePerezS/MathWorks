package com.example.jaime.tfg.ui.teacher.classroom.insert;

import com.example.jaime.tfg.data.interactor.teacher.classroom.insert.InsertClassroomInteractorImp;

/**
 * Created by Jaime on 03/12/2017.
 */

public class InsertClassroomPresenterImp implements InsertClassroomPresenter {

    private InsertClassroomView view;
    private InsertClassroomInteractorImp interactor;

    public InsertClassroomPresenterImp(InsertClassroomView view) {
        this.view = view;
        this.interactor = new InsertClassroomInteractorImp(this);
    }

    @Override
    public void onClickInsertClassroom(String name, String idTeacher, String idUuid) {
        view.showProgress("Creando clase", "Creando...");
        interactor.insertClassroom(name, idTeacher, idUuid);
    }

    @Override
    public void onSuccessInsertClassroom(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
        view.finish();
    }

    @Override
    public void onFailureInsertClassroom(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
