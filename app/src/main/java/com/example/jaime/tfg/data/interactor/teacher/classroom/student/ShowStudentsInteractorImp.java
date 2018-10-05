package com.example.jaime.tfg.data.interactor.teacher.classroom.student;

import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.ui.teacher.classroom.student.ShowStudentsPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowStudentsInteractorImp {
    private ShowStudentsPresenter presenter;
    private ApiService apiService;

    public ShowStudentsInteractorImp(ShowStudentsPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getStudents(String idTeacher, String idClassroom, String token) {
        apiService.getStudents(idTeacher, idClassroom, token).enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                if(response.isSuccessful()){
                    presenter.onSuccessGetStudents(response.body());
                }
                else {
                    try {
                        presenter.onFailureGetStudents(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                presenter.onFailureGetStudents("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }

    public void deleteStudent(String idStudent, String idTeacher, String idClassroom, String token) {

        apiService.deleteStudent(idStudent, idTeacher, idClassroom, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessDeleteStudent(response.body());
                } else {
                    presenter.onFailureDeleteStudent(response.body());
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureDeleteStudent("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
