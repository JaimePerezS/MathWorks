package com.example.jaime.tfg.data.interactor.teacher.problemsgroup.problem;

import com.example.jaime.tfg.data.model.Problem;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.ui.teacher.problemsgroup.problem.ShowProblemsPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowProblemsInteractorImp {
    private ShowProblemsPresenter presenter;
    private ApiService apiService;

    public ShowProblemsInteractorImp(ShowProblemsPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getProblems(final String idTeacher, final String idProblemsGroup, final String token) {

        apiService.getProblems(idTeacher, idProblemsGroup, token).enqueue(new Callback<List<Problem>>() {
            @Override
            public void onResponse(Call<List<Problem>> call, Response<List<Problem>> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessGetProblems(response.body());
                }
                else {
                    try {
                        presenter.onFailureGetProblems(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Problem>> call, Throwable t) {
                presenter.onFailureGetProblems("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }

    public void deleteProblem(String idTeacher, String idProblemsGroup, String idProblem, String token) {

        apiService.deleteProblem(idTeacher, idProblemsGroup, idProblem, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessDeleteProblem(response.body());
                } else {
                    presenter.onFailureDeleteProblem(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureDeleteProblem("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}

