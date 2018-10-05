package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 09/01/2018.
 */

public class LoginStudentRequestBody {
    @SerializedName("idPublico")
    @Expose
    String id;

    public LoginStudentRequestBody(String id) {
        this.id = id;
    }
}
