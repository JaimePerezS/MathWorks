package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 02/12/2017.
 */

public class InsertProblemRequestBody {
    @SerializedName("enunciado")
    @Expose
    String statement;

    @SerializedName("operacion")
    @Expose
    String operation;

    @SerializedName("puntos")
    @Expose
    int points;

    @SerializedName("ayuda")
    @Expose
    String help;

    @SerializedName("tipoOperacion")
    @Expose
    String operationType;

    public InsertProblemRequestBody(String statement, String operation, int points, String help, String operationType) {
        this.statement = statement;
        this.operation = operation;
        this.points = points;
        this.help = help;
        this.operationType = operationType;
    }
}
