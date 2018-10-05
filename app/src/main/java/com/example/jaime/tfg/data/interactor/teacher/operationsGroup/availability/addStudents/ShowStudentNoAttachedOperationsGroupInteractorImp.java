package com.example.jaime.tfg.data.interactor.teacher.operationsGroup.availability.addStudents;

import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.InsertStudentVisibilityOperationsGroup;
import com.example.jaime.tfg.ui.teacher.operationsgroup.availability.addstudents.ShowStudentNoAttachedOperationsGroupPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowStudentNoAttachedOperationsGroupInteractorImp {

    private ShowStudentNoAttachedOperationsGroupPresenter presenter;
    private ApiService apiService;

    public ShowStudentNoAttachedOperationsGroupInteractorImp(ShowStudentNoAttachedOperationsGroupPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getStudentsNoAttachedOperationsGroup(String idTeacher, String idClassroom, String idOperationsGrup, String token) {

        apiService.getStudentsNoAttachedOperationsGroup(idTeacher, idOperationsGrup, idClassroom, token).enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessGetStudentsNoAttachedOperationsGroup(response.body());
                } else {
                    try {
                        presenter.onFailureGetStudentsNoAttachedOperationsGroup(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                presenter.onFailureGetStudentsNoAttachedOperationsGroup("Error al conectar al servidor, intentalo mas tarde");
            }
        });

    }

    public void addVisibility(String idTeacher, String idOperationsGroup, String idClassroom, String idStudent, String token) {

        final InsertStudentVisibilityOperationsGroup requestBody = new InsertStudentVisibilityOperationsGroup(idStudent);

        apiService.insertStudentVisibilityOperationsGroup(requestBody, idTeacher, idOperationsGroup, idClassroom, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessAddVisibility(response.body());
                } else {
                    presenter.onFailureAddVisibility(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureAddVisibility("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
