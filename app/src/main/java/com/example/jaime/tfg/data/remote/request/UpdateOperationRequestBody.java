package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 02/12/2017.
 */

public class UpdateOperationRequestBody {
    @SerializedName("enunciado")
    @Expose
    String statement;

    @SerializedName("puntos")
    @Expose
    int points;


    public UpdateOperationRequestBody(String statement, int points) {
        this.statement = statement;
        this.points = points;
    }
}
