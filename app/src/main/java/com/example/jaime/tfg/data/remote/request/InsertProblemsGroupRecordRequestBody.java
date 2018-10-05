package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 22/03/2018.
 */

public class InsertProblemsGroupRecordRequestBody {
    @SerializedName("idGrupoProblemas")
    @Expose
    private String idProblemsGroup;
    @SerializedName("fecha")
    @Expose
    private String date;
    @SerializedName("puntosObtenidos")
    @Expose
    private int points;

    public InsertProblemsGroupRecordRequestBody(String idProblemsGroup, String date, int points) {
        this.idProblemsGroup = idProblemsGroup;
        this.date = date;
        this.points = points;
    }
}
