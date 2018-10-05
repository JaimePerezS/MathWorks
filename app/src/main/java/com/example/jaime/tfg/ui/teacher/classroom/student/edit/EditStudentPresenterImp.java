package com.example.jaime.tfg.ui.teacher.classroom.student.edit;

import com.example.jaime.tfg.data.interactor.teacher.classroom.student.edit.EditStudentInteractorImp;

/**
 * Created by Jaime on 04/12/2017.
 */

public class EditStudentPresenterImp implements EditStudentPresenter{
    private EditStudentView view;
    private EditStudentInteractorImp interactor;

    public EditStudentPresenterImp(EditStudentView view) {
        this.view = view;
        this.interactor = new EditStudentInteractorImp(this);
    }

    @Override
    public void onClickEditStudent(String name, String surname, String idTeacher, String idClassroom, String idStudent, String token) {
        view.showProgress("Actualizando datos del alumno", "Actualizando...");
        interactor.updateStudent(name, surname, idTeacher, idClassroom, idStudent, token);
    }

    @Override
    public void onSuccessEditStudent(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
        view.finish();
    }

    @Override
    public void onFailureEditStudent(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
