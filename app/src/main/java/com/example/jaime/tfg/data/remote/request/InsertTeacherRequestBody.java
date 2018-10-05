package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 01/12/2017.
 */

public class InsertTeacherRequestBody {
    @SerializedName("nombre")
    @Expose
    String name;
    @SerializedName("apellidos")
    @Expose
    String surname;
    @SerializedName("correoElectronico")
    @Expose
    String email;
    @SerializedName("contrasena")
    @Expose
    String password;

    public InsertTeacherRequestBody(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
