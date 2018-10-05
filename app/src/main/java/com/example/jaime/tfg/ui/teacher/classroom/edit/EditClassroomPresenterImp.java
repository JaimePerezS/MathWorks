package com.example.jaime.tfg.ui.teacher.classroom.edit;

import com.example.jaime.tfg.data.interactor.teacher.classroom.edit.EditClassroomInteractorImp;

/**
 * Created by Jaime on 02/12/2017.
 */

public class EditClassroomPresenterImp implements EditClassroomPresenter{

    private EditClasroomView view;
    private EditClassroomInteractorImp interactor;

    public EditClassroomPresenterImp(EditClasroomView view) {
        this.view = view;
        this.interactor = new EditClassroomInteractorImp(this);
    }

    @Override
    public void onUpdateClassroomClick(String newName, String idTeacher, String idClassroom, String idUuid) {
        view.showProgress("Actualizando Clase", "Actualizando");
        interactor.updateClassroom(newName, idTeacher, idClassroom, idUuid);
    }

    @Override
    public void onUpdateClassroomSuccess(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
        view.finish();
    }

    @Override
    public void onUpdateClassroomFailure(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
