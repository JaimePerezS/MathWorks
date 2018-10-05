package com.example.jaime.tfg.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 05/03/2018.
 */

public class InsertStudentVisibilityOperationsGroup {

    @SerializedName("idAlumno")
    @Expose
    String idStudent;

    public InsertStudentVisibilityOperationsGroup(String idStudent) {
        this.idStudent = idStudent;
    }

}
