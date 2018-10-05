package com.example.jaime.tfg.data.interactor.teacher.operationsGroup.insert;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.InsertOperationsGroupRequestBody;
import com.example.jaime.tfg.ui.teacher.operationsgroup.insert.InsertOperationsGroupPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertOperationsGroupInteractorImp {
    private InsertOperationsGroupPresenter presenter;
    private ApiService apiService;

    public InsertOperationsGroupInteractorImp(InsertOperationsGroupPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void insertOperationsGroup(final String name, String difficulty, String idTeacher, String token) {
        final InsertOperationsGroupRequestBody requestBody = new InsertOperationsGroupRequestBody(name, difficulty);

        apiService.insertOperationsGroup(requestBody, idTeacher, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    presenter.onSuccessInsertOperationsGroup(response.body());
                }
                else {
                    presenter.onFailureInsertOperationsGroup(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureInsertOperationsGroup("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
