package com.example.jaime.tfg.data.interactor.teacher.problemsgroup.problem.insert;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.InsertProblemRequestBody;
import com.example.jaime.tfg.ui.teacher.problemsgroup.problem.insert.InsertProblemPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertProblemInteractorImp {
    private InsertProblemPresenter presenter;
    private ApiService apiService;

    public InsertProblemInteractorImp(InsertProblemPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void insertProblem(String statement, String operation, int points, String help, String operationType, String idTeacher, String idProblemsGroup, String token) {
        final InsertProblemRequestBody requestBody = new InsertProblemRequestBody(statement, operation, points, help, operationType);

        apiService.insertProblem(requestBody, idTeacher, idProblemsGroup, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessInsertProblem(response.body());
                }
                else {
                    presenter.onFailureInsertProblem(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureInsertProblem("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
