package com.example.jaime.tfg.data.interactor.teacher.problemsgroup.availability.addStudents;

import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.InsertStudentVisibilityProblemsGroup;
import com.example.jaime.tfg.ui.teacher.problemsgroup.availability.addStudents.ShowStudentNoAttachedProblemsGroupPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowStudentNoAttachedProblemsGroupInteractorImp {
    private ShowStudentNoAttachedProblemsGroupPresenter presenter;
    private ApiService apiService;

    public ShowStudentNoAttachedProblemsGroupInteractorImp(ShowStudentNoAttachedProblemsGroupPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getStudentsNoAttachedProblemsGroup(String idTeacher, String idClassroom, String idProblemsGrup, String token) {

        apiService.getStudentsNoAttachedProblemsGroup(idTeacher, idProblemsGrup, idClassroom, token).enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessGetStudentsNoAttachedProblemsGroup(response.body());
                } else {
                    try {
                        presenter.onFailureGetStudentsNoAttachedProblemsGroup(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                presenter.onFailureGetStudentsNoAttachedProblemsGroup("Error al conectar al servidor, intentalo mas tarde");
            }
        });

    }

    public void addVisibility(String idTeacher, String idProblemsGroup, String idClassroom, String idStudent, String token) {

        final InsertStudentVisibilityProblemsGroup requestBody = new InsertStudentVisibilityProblemsGroup(idStudent);

        apiService.insertStudentVisibilityProblemsGroup(requestBody, idTeacher, idProblemsGroup, idClassroom, token).enqueue(new Callback<String>() {
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
