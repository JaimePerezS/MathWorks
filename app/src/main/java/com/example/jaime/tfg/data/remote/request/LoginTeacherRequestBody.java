package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 30/11/2017.
 */

public class LoginTeacherRequestBody {
    @SerializedName("correoElectronico")
    @Expose
    String email;
    @SerializedName("contrasena")
    @Expose
    String password;

    public LoginTeacherRequestBody(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
