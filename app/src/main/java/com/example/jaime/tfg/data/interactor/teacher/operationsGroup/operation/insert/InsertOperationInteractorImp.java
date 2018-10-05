package com.example.jaime.tfg.data.interactor.teacher.operationsGroup.operation.insert;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.InsertOperationRequestBody;
import com.example.jaime.tfg.ui.teacher.operationsgroup.operation.insert.InsertOperationPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertOperationInteractorImp {
    private InsertOperationPresenter presenter;
    private ApiService apiService;

    public InsertOperationInteractorImp(InsertOperationPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void insertOperation(String statement, int points, String idTeacher, String idOperationsGroup, String token) {
        final InsertOperationRequestBody requestBody = new InsertOperationRequestBody(statement, points);

        apiService.insertOperation(requestBody, idTeacher, idOperationsGroup, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessInsertOperation(response.body());
                } else {
                    presenter.onFailureInsertOperation(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureInsertOperation("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
