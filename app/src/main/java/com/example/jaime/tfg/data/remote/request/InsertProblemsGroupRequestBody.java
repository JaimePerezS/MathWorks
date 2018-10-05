package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 02/12/2017.
 */

public class InsertProblemsGroupRequestBody {
    @SerializedName("nombre")
    @Expose
    String name;

    @SerializedName("dificultad")
    @Expose
    String difficulty;

    public InsertProblemsGroupRequestBody(String name, String difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }
}
