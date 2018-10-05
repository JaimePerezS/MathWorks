package com.example.jaime.tfg.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 15/03/2018.
 */

public class ProblemsGroupRecord {
    private int id;
    @SerializedName("fecha")
    @Expose
    private String date;
    @SerializedName("puntosObtenidos")
    @Expose
    private int pointsObtained;
    @SerializedName("idGrupoProblemas")
    @Expose
    private String idProblemsGroup;
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

    public ProblemsGroupRecord(int id, String date, int pointsObtained, String idProblemsGroup, String idStudent, String name, String difficulty, String points) {
        this.id = id;
        this.date = date;
        this.pointsObtained = pointsObtained;
        this.idProblemsGroup = idProblemsGroup;
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

    public int getPointsObtained() {
        return pointsObtained;
    }

    public void setPointsObtained(int pointsObtained) {
        this.pointsObtained = pointsObtained;
    }

    public String getIdProblemsGroup() {
        return idProblemsGroup;
    }

    public void setIdProblemsGroup(String idProblemsGroup) {
        this.idProblemsGroup = idProblemsGroup;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
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

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
