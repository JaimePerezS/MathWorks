package com.example.jaime.tfg.data.interactor.teacher.problemsgroup.insert;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.InsertProblemsGroupRequestBody;
import com.example.jaime.tfg.ui.teacher.problemsgroup.insert.InsertProblemsGroupPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertProblemsGroupInteractorImp {
    private InsertProblemsGroupPresenter presenter;
    private ApiService apiService;

    public InsertProblemsGroupInteractorImp(InsertProblemsGroupPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void insertProblemsGroup(String newName, String newDifficulty, String idTeacher, String token) {
        InsertProblemsGroupRequestBody requestBody = new InsertProblemsGroupRequestBody(newName, newDifficulty);

        apiService.insertProblemsGroup(requestBody, idTeacher, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessInsertProblemsGroup(response.body());
                }
                else {
                    presenter.onFailureInsertProblemsGroup(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureInsertProblemsGroup("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
