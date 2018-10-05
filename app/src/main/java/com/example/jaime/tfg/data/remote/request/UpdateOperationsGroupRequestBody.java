package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 02/12/2017.
 */

public class UpdateOperationsGroupRequestBody {
    @SerializedName("nombre")
    @Expose
    String name;

    @SerializedName("dificultad")
    @Expose
    String difficulty;

    public UpdateOperationsGroupRequestBody(String name, String difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }
}
