package com.example.jaime.tfg.data.remote;

/**
 * Created by Jaime on 28/11/2017.
 */

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://tfg-matematicas.000webhostapp.com/";

    public static ApiService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
