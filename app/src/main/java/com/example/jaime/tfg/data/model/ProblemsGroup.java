package com.example.jaime.tfg.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 14/10/2017.
 */

public class ProblemsGroup {

    @Expose
    private int id;
    @SerializedName("nombre")
    @Expose
    private String name;
    @SerializedName("dificultad")
    @Expose
    private String difficulty;
    @SerializedName("idProfesor")
    @Expose
    private String idTeacher;

    public ProblemsGroup(int id, String name, String difficulty, String idTeacher) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;

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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }
}
