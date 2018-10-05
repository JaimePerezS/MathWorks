package com.example.jaime.tfg.data.interactor.teacher.problemsgroup;

import com.example.jaime.tfg.data.model.ProblemsGroup;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.ui.teacher.problemsgroup.ShowProblemsGroupsPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowProblemsGroupInteractorImp {
    private ShowProblemsGroupsPresenter presenter;
    private ApiService apiService;

    public ShowProblemsGroupInteractorImp(ShowProblemsGroupsPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getProblemsGroups(String idTeacher, String token) {

        apiService.getProblemsGroups(idTeacher, token).enqueue(new Callback<List<ProblemsGroup>>() {
            @Override
            public void onResponse(Call<List<ProblemsGroup>> call, Response<List<ProblemsGroup>> response) {
                if(response.isSuccessful()){
                    presenter.onSuccessGetProblemsGroup(response.body());
                }
                else {
                    try {
                        presenter.onFailureGetProblemsGroup(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ProblemsGroup>> call, Throwable t) {
                presenter.onFailureGetProblemsGroup("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }

    public void deleteProblemsGroup(String idTeacher, String idProblemsGroup, String token) {

        apiService.deleteProblemsGroup(idTeacher, idProblemsGroup, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessDeleteProblemsGroup(response.body());
                } else {
                    presenter.onFailureDeleteProblemsGroup(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureDeleteProblemsGroup("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
