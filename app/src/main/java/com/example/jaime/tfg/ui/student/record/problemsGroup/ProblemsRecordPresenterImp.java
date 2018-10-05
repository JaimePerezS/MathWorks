package com.example.jaime.tfg.ui.student.record.problemsGroup;

import com.example.jaime.tfg.data.model.ProblemsRecord;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jaime on 21/03/2018.
 */

public class ProblemsRecordPresenterImp implements ProblemsRecordPresenter{

    private ProblemsRecordView view;

    private ApiService apiService;

    public ProblemsRecordPresenterImp(ProblemsRecordView view) {
        this.view = view;
    }

    @Override
    public void getProblemsRecord(String idStudent, String idProblemsGroup, String idRecord, String token) {
        apiService = ApiUtils.getAPIService();

        apiService.getProblemsRecord(idStudent, idProblemsGroup, idRecord, token).enqueue(new Callback<List<ProblemsRecord>>() {
            @Override
            public void onResponse(Call<List<ProblemsRecord>> call, Response<List<ProblemsRecord>> response) {
                if(response.isSuccessful()) {
                    view.showProblemsRecord(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ProblemsRecord>> call, Throwable t) {

            }
        });
    }
}
