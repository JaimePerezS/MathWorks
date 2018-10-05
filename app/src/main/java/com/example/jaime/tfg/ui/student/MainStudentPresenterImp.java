package com.example.jaime.tfg.ui.student;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;

/**
 * Created by Jaime on 18/01/2018.
 */

public class MainStudentPresenterImp implements MainStundentPresenter{

    MainStudentView view;
    ApiService apiService;

    public MainStudentPresenterImp (MainStudentView view) {
        this.view = view;
    }
    @Override
    public void getPoints(String idStudent) {
        apiService = ApiUtils.getAPIService();
    }

    @Override
    public void getAvatar(String idStudent) {
        apiService = ApiUtils.getAPIService();
    }
}
