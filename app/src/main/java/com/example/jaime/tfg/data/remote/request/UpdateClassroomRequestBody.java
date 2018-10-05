package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 01/12/2017.
 */

public class UpdateClassroomRequestBody {
    @SerializedName("nombre")
    @Expose
    String name;

    public UpdateClassroomRequestBody(String name) {
        this.name = name;
    }
}
