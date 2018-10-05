package com.example.jaime.tfg.data.interactor.teacher.operationsGroup;

import com.example.jaime.tfg.data.model.OperationsGroup;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.ui.teacher.operationsgroup.ShowOperationsGroupPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowOperationsGroupInteractorImp {
    private ShowOperationsGroupPresenter presenter;
    private ApiService apiService;

    public ShowOperationsGroupInteractorImp(ShowOperationsGroupPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getOperationsGroup(String idTeacher, String token) {

        apiService.getOperationsGroups(idTeacher, token).enqueue(new Callback<List<OperationsGroup>>() {
            @Override
            public void onResponse(Call<List<OperationsGroup>> call, Response<List<OperationsGroup>> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessGetOperationsGroup(response.body());
                }
                else {
                    try {
                        presenter.onFailureGetOperationsGroup(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<OperationsGroup>> call, Throwable t) {
                presenter.onFailureGetOperationsGroup("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }

    public void deleteOperationsGroup(String idTeacher, String idOperationsGroup, String token) {

        apiService.deleteOperationsGroup(idTeacher, idOperationsGroup, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessDeleteOperationsGroup(response.body());
                } else {
                    presenter.onFailureDeleteOperationsGroup(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureDeleteOperationsGroup("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
