package com.example.jaime.tfg.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 06/10/2017.
 */

public class Classroom {

    private int id;

    @SerializedName("nombre")
    @Expose
    private String name;

    @SerializedName("idProfesor")
    @Expose
    private String idTeacher;

    public Classroom(int id, String name, String idTeacher) {
        this.id = id;
        this.name = name;
        this.idTeacher = idTeacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }
}
