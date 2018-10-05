package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 02/02/2018.
 */

public class UpdateStudentPointsRequestBody {
    @SerializedName("id")
    @Expose
    String idStudent;
    @SerializedName("puntuacion")
    int points;

    public UpdateStudentPointsRequestBody(String idStudent, int points) {
        this.idStudent = idStudent;
        this.points = points;
    }
}
