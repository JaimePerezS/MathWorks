package com.example.jaime.tfg.data.interactor.student.problemsGroup;

import com.example.jaime.tfg.data.model.ProblemsGroup;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.ui.student.problemsGroup.SelectProblemsGroupPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectProblemsGroupInteractorImp {
    private SelectProblemsGroupPresenter presenter;
    private ApiService apiService;

    public SelectProblemsGroupInteractorImp(SelectProblemsGroupPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getProblemsGroups(String idStudent, String token) {

        apiService.getProblemsGroupsByStudentId(idStudent, token).enqueue(new Callback<List<ProblemsGroup>>() {
            @Override
            public void onResponse(Call<List<ProblemsGroup>> call, Response<List<ProblemsGroup>> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessGetProblemsGroups(response.body());
                } else {
                    try {
                        presenter.onFailureGetProblemsGroups(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ProblemsGroup>> call, Throwable t) {
                presenter.onFailureGetProblemsGroups("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
