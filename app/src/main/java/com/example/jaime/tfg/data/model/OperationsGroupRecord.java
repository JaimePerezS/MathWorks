package com.example.jaime.tfg.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 15/03/2018.
 */

public class OperationsGroupRecord {
    private int id;
    @SerializedName("fecha")
    @Expose
    private String date;
    @SerializedName("puntosObtenidos")
    @Expose
    private int pointsObtained;
    @SerializedName("idGrupoOperaciones")
    @Expose
    private String idOperationsGroup;
    @SerializedName("idAlumno")
    @Expose
    private String idStudent;
    @SerializedName("nombre")
    @Expose
    private String name;
    @SerializedName("dificultad")
    @Expose
    private String difficulty;
    @SerializedName("puntos")
    @Expose
    private String points;

    public OperationsGroupRecord(int id, String date, int pointsObtained, String idOperationsGroup, String idStudent, String name, String difficulty, String points) {
        this.id = id;
        this.date = date;
        this.pointsObtained = pointsObtained;
        this.idOperationsGroup = idOperationsGroup;
        this.idStudent = idStudent;
        this.name = name;
        this.difficulty = difficulty;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPoints() {
        return pointsObtained;
    }

    public void setPoints(int pointsObtained) {
        this.pointsObtained = pointsObtained;
    }

    public String getIdOperationsGroup() {
        return idOperationsGroup;
    }

    public void setIdOperationsGroup(String idOperationsGroup) {
        this.idOperationsGroup = idOperationsGroup;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }
    public int getPointsObtained() {
        return pointsObtained;
    }

    public void setPointsObtained(int pointsObtained) {
        this.pointsObtained = pointsObtained;
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

    public void setPoints(String points) {
        this.points = points;
    }
}
