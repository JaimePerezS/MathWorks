package com.example.jaime.tfg.ui.student.record.operationsGroup;

import com.example.jaime.tfg.data.model.OperationsGroupRecord;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jaime on 21/03/2018.
 */

public class OperationsGroupRecordPresenterImp implements OperationsGroupRecordPresenter{

    private OperationsGroupRecordView view;

    private ApiService apiService;

    public OperationsGroupRecordPresenterImp(OperationsGroupRecordView view) {
        this.view = view;
    }

    @Override
    public void getOperationsGroupRecord(String idStudent, String token) {
        apiService = ApiUtils.getAPIService();

        apiService.getOperationsGroupRecords(idStudent, token).enqueue(new Callback<List<OperationsGroupRecord>>() {
            @Override
            public void onResponse(Call<List<OperationsGroupRecord>> call, Response<List<OperationsGroupRecord>> response) {
                if(response.isSuccessful()) {
                    view.showOperationsGroupRecord(response.body());
                } else {
                    try {
                        view.showErrorToast(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<OperationsGroupRecord>> call, Throwable t) {

            }
        });
    }
}
