package com.example.jaime.tfg.ui.teacher.classroom.student.insert;

import com.example.jaime.tfg.data.interactor.teacher.classroom.student.insert.InsertStudentInteractorImp;

/**
 * Created by Jaime on 04/12/2017.
 */

public class InsertStudentPresenterImp implements InsertStudentPresenter{

    private InsertStudentView view;
    private InsertStudentInteractorImp interactor;

    public InsertStudentPresenterImp(InsertStudentView view) {
        this.view = view;
        this.interactor = new InsertStudentInteractorImp(this);
    }

    @Override
    public void onClickInsertStudent(String name, String surname, String idTeacher, String idClassroom, String token) {
        view.showProgress("Insertando Alumno", "Guardando datos...");
        interactor.insertStudent(name, surname, idTeacher, idClassroom, token);
    }

    @Override
    public void onSuccessInsertStudent(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
        view.finish();
    }

    @Override
    public void onFailureInsertStudent(String message) {
        view.hideProgress();
        view.showErrorToast(message);
        view.finish();
    }
}
