package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 01/02/2018.
 */

public class InsertAvatarBougthRequestBody {
    @SerializedName("idAlumno")
    @Expose
    String idStudent;

    @SerializedName("idAvatar")
    @Expose
    String idAvatar;

    public InsertAvatarBougthRequestBody(String idStudent, String idAvatar) {
        this.idStudent = idStudent;
        this.idAvatar = idAvatar;
    }
}
