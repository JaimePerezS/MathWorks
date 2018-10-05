package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 02/12/2017.
 */

public class UpdateStudentRequestBody {

    @SerializedName("nombre")
    @Expose
    String name;

    @SerializedName("apellidos")
    @Expose
    String surname;

    public UpdateStudentRequestBody(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
