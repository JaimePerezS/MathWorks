package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 17/03/2018.
 */

public class InsertOperationsGroupRecordRequestBody {
    @SerializedName("idGrupoOperaciones")
    @Expose
    private String idOperationsGroup;
    @SerializedName("fecha")
    @Expose
    private String date;
    @SerializedName("puntosObtenidos")
    @Expose
    private int points;

    public InsertOperationsGroupRecordRequestBody(String idOperationsGroup, String date, int points) {
        this.idOperationsGroup = idOperationsGroup;
        this.date = date;
        this.points = points;
    }
}
