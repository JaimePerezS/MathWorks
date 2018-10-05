package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 01/12/2017.
 */

public class UpdateTeacherRequestBody {
    @SerializedName("nombre")
    @Expose
    String name;
    @SerializedName("apellidos")
    @Expose
    String surname;

    public UpdateTeacherRequestBody(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
