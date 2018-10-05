package com.example.jaime.tfg.data.interactor.teacher.problemsgroup.availability;

import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.ui.teacher.problemsgroup.availability.StudentsPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentsInteractorImp {
    private StudentsPresenter presenter;
    private ApiService apiService;

    public StudentsInteractorImp(StudentsPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getStudentsAttached(String idTeacher, String idClassroom, String idProblemsGrup, String token) {

        apiService.getStudentsAttachedProblemsGroup(idTeacher, idProblemsGrup, idClassroom, token).enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessGetStudentsAttached(response.body());
                } else {
                    try {
                        presenter.onFailureGetStudentsAttached(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                presenter.onFailureGetStudentsAttached("Error al conectar al servidor, intentalo mas tarde");
            }
        });

    }

    public void hideAvailability(String idTeacher, String idProblemsGroup, String idClassroom, String idStudent, String token) {

        apiService.deleteStudentVisibilityProblemsGroup(idTeacher, idProblemsGroup, idClassroom, idStudent, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessHideAvailability(response.body());
                } else {
                    presenter.onFailureHideAvailability(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureHideAvailability("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
