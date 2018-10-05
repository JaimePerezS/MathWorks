package com.example.jaime.tfg.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 15/03/2018.
 */

public class ProblemsRecord {
    private int id;
    @SerializedName("errorIdentificar")
    @Expose
    private int mistakesIdent;
    @SerializedName("errorOperacion")
    @Expose
    private int mistakesOper;
    @SerializedName("enunciado")
    @Expose
    private String statement;
    @SerializedName("solucion")
    @Expose
    private String solution;
    @SerializedName("puntosObtenidos")
    @Expose
    private int pointsObtained;
    @SerializedName("idProblema")
    @Expose
    private int idOperation;
    @SerializedName("idRegistro")
    @Expose
    private int idRecord;

    public ProblemsRecord(int id, int mistakesIdent, int mistakesOper, String statement, String solution, int pointsObtained) {
        this.id = id;
        this.mistakesIdent = mistakesIdent;
        this.mistakesOper = mistakesOper;
        this.statement = statement;
        this.solution = solution;
        this.pointsObtained = pointsObtained;
    }

    public ProblemsRecord(int mistakesIdent, int mistakesOper, int pointsObtained, int idOperation) {
        this.mistakesIdent = mistakesIdent;
        this.mistakesOper = mistakesOper;
        this.pointsObtained = pointsObtained;
        this.idOperation = idOperation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMistakesIdent() {
        return mistakesIdent;
    }

    public void setMistakesIdent(int mistakesIdent) {
        this.mistakesIdent = mistakesIdent;
    }

    public int getMistakesOper() {
        return mistakesOper;
    }

    public void setMistakesOper(int mistakesOper) {
        this.mistakesOper = mistakesOper;
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

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public int getPointsObtained() {
        return pointsObtained;
    }

    public void setPointsObtained(int pointsObtained) {
        this.pointsObtained = pointsObtained;
    }
}
