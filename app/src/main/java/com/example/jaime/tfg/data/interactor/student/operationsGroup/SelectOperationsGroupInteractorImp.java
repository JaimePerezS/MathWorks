package com.example.jaime.tfg.data.interactor.student.operationsGroup;

import com.example.jaime.tfg.data.model.OperationsGroup;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.ui.student.operationsGroup.SelectOperationsGroupPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectOperationsGroupInteractorImp {
    private SelectOperationsGroupPresenter presenter;
    private ApiService apiService;

    public SelectOperationsGroupInteractorImp(SelectOperationsGroupPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getOperationsGroups(String idStudent, String token) {
        apiService = ApiUtils.getAPIService();

        apiService.getOperationsGroupsByStudentId(idStudent, token).enqueue(new Callback<List<OperationsGroup>>() {
            @Override
            public void onResponse(Call<List<OperationsGroup>> call, Response<List<OperationsGroup>> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessGetOperationsGroups(response.body());
                } else {
                    try {
                        presenter.onFailureGetOperationsGroups(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<OperationsGroup>> call, Throwable t) {
                presenter.onFailureGetOperationsGroups("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
