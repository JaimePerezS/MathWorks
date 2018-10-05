package com.example.jaime.tfg.data.interactor.teacher.operationsGroup.operation;

import com.example.jaime.tfg.data.model.Operation;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.ui.teacher.operationsgroup.operation.ShowOperationsPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowOperationsInteractorImp {
    private ShowOperationsPresenter presenter;
    private ApiService apiService;

    public ShowOperationsInteractorImp(ShowOperationsPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getOperations(String idTeacher, String idOperationsGroup, String token) {

        apiService.getOperations(idTeacher, idOperationsGroup, token).enqueue(new Callback<List<Operation>>() {
            @Override
            public void onResponse(Call<List<Operation>> call, Response<List<Operation>> response) {
                if(response.isSuccessful()){
                    presenter.onSuccessGetOperations(response.body());
                }
                else {
                    try {
                        presenter.onFailureGetOperations(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Operation>> call, Throwable t) {
                presenter.onFailureGetOperations("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }

    public void deleteOperation(String idTeacher, String idOperationsGroup, String idOperation, String token) {

        apiService.deleteOperation(idTeacher, idOperationsGroup, idOperation, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessDeleteOperation(response.body());
                } else {
                    presenter.onFailureDeleteOperation(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureDeleteOperation("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
