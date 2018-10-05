package com.example.jaime.tfg.ui.student.record.problemsGroup;

import com.example.jaime.tfg.data.model.ProblemsGroupRecord;
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

public class ProblemsGroupRecordPresenterImp implements ProblemsGroupRecordPresenter {

    private ProblemsGroupRecordView view;

    private ApiService apiService;

    public ProblemsGroupRecordPresenterImp(ProblemsGroupRecordView view) {
        this.view = view;
    }

    @Override
    public void getProblemsGroupRecord(String idStudent, String token) {

        apiService = ApiUtils.getAPIService();

        apiService.getProblemsGroupRecords(idStudent, token).enqueue(new Callback<List<ProblemsGroupRecord>>() {
            @Override
            public void onResponse(Call<List<ProblemsGroupRecord>> call, Response<List<ProblemsGroupRecord>> response) {
                if(response.isSuccessful()) {
                    view.showProblemsGroupRecord(response.body());
                } else {
                    try {
                        view.showErrorToast(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<List<ProblemsGroupRecord>> call, Throwable t) {

            }
        });

    }
}
