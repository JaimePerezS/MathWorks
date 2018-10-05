package com.example.jaime.tfg.data.interactor.teacher.classroom.student.insert;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.InsertStudentRequestBody;
import com.example.jaime.tfg.ui.teacher.classroom.student.insert.InsertStudentPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertStudentInteractorImp {
    private InsertStudentPresenter presenter;
    private ApiService apiService;

    public InsertStudentInteractorImp(InsertStudentPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void insertStudent(String name, String surname, String idTeacher, String idClassroom, String token) {
        final InsertStudentRequestBody requestBody = new InsertStudentRequestBody(name, surname);

        apiService.insertStudent(requestBody, idTeacher, idClassroom, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    presenter.onSuccessInsertStudent(response.body());
                }
                else {
                    presenter.onFailureInsertStudent(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureInsertStudent("Error al conectar al servidor, intentalo mas tarde");
            }
        });

    }
}
