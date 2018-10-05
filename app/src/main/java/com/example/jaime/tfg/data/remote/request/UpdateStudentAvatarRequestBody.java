package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 19/01/2018.
 */

public class UpdateStudentAvatarRequestBody {
    @SerializedName("idAvatar")
    @Expose
    String idAvatar;

    public UpdateStudentAvatarRequestBody(String idAvatar) {
        this.idAvatar = idAvatar;
    }
}
