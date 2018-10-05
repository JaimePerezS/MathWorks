package com.example.jaime.tfg.ui.student.record.operationsGroup;

import com.example.jaime.tfg.data.model.OperationsRecord;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jaime on 21/03/2018.
 */

public class OperationsRecordPresenterImp implements OperationsRecordPresenter {
    OperationsRecordView view;
    ApiService apiService;

    public OperationsRecordPresenterImp(OperationsRecordView view) {
        this.view = view;
    }

    @Override
    public void getOperationsRecord(String idStudent, String idOperationsGroup, String idRecord, String token) {
        apiService = ApiUtils.getAPIService();

        apiService.getOperationsRecord(idStudent, idOperationsGroup, idRecord, token).enqueue(new Callback<List<OperationsRecord>>() {
            @Override
            public void onResponse(Call<List<OperationsRecord>> call, Response<List<OperationsRecord>> response) {
                if(response.isSuccessful()) {
                    view.showOperationsRecord(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<OperationsRecord>> call, Throwable t) {

            }
        });
    }
}
