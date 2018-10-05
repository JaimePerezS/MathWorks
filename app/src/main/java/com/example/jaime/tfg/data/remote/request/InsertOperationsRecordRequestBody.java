package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 18/03/2018.
 */

public class InsertOperationsRecordRequestBody {
    @SerializedName("error")
    @Expose
    int mistakes;

    @SerializedName("puntosObtenidos")
    @Expose
    int pointsObtained;

    @SerializedName("idOperacion")
    @Expose
    int operationId;

    public InsertOperationsRecordRequestBody(int mistakes, int pointsObtained, int operationId) {
        this.mistakes = mistakes;
        this.pointsObtained = pointsObtained;
        this.operationId = operationId;
    }
}
