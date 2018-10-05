package com.example.jaime.tfg.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 15/03/2018.
 */

public class OperationsRecord {
    private int id;
    @SerializedName("error")
    @Expose
    private int mistakes;
    @SerializedName("enunciado")
    @Expose
    private String statement;
    @SerializedName("solucion")
    @Expose
    private String solution;
    @SerializedName("puntosObtenidos")
    @Expose
    private int pointsObtained;
    @SerializedName("idOperacion")
    @Expose
    private int idOperation;
    @SerializedName("idRegistro")
    @Expose
    private int idRecord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMistakes() {
        return mistakes;
    }

    public void setMistakes(int mistakes) {
        this.mistakes = mistakes;
    }

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public OperationsRecord(int id, int mistakes, String statement, String solution, int pointsObtained) {
        this.id = id;
        this.mistakes = mistakes;
        this.statement = statement;
        this.solution = solution;
        this.pointsObtained = pointsObtained;
    }

    public OperationsRecord(int mistakes, int pointsObtained, int idOperation) {
        this.mistakes = mistakes;
        this.pointsObtained = pointsObtained;
        this.idOperation = idOperation;
    }

    public int getPointsObtained() {
        return pointsObtained;
    }

    public void setPointsObtained(int pointsObtained) {
        this.pointsObtained = pointsObtained;
    }
}
