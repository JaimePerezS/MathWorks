package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 19/03/2018.
 */

public class InsertProblemsRecordRequestBody {
    @SerializedName("errorIdentificar")
    @Expose
    int mistakesIdent;
    @SerializedName("errorOperacion")
    @Expose
    int mistakesOper;
    @SerializedName("puntosObtenidos")
    @Expose
    int pointsObtained;
    @SerializedName("idProblema")
    @Expose
    int problemId;

    public InsertProblemsRecordRequestBody(int mistakesIdent, int mistakesOper, int pointsObtained, int problemId) {
        this.mistakesIdent = mistakesIdent;
        this.mistakesOper = mistakesOper;
        this.pointsObtained = pointsObtained;
        this.problemId = problemId;
    }
}
