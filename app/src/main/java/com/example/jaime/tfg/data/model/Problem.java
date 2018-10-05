package com.example.jaime.tfg.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 22/10/2017.
 */

public class Problem {

    @Expose
    private int id;
    @SerializedName("enunciado")
    @Expose
    private String statement;
    @SerializedName("operacion")
    @Expose
    private String operation;
    @SerializedName("solucion")
    @Expose
    private String solution;
    @SerializedName("puntos")
    @Expose
    private int puntos;
    @SerializedName("tipoOperacion")
    @Expose
    private String operationType;
    @SerializedName("ayuda")
    @Expose
    private String help;
    @SerializedName("idGrupoProblemas")
    private String idProblemsGroup;

    public Problem(int id, String statement, String operation, int puntos, String operationType, String help, String idProblemsGroup) {
        this.id = id;
        this.statement = statement;
        this.operation = operation;
        this.puntos = puntos;
        this.operationType = operationType;
        this.help = help;
        this.idProblemsGroup = idProblemsGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getIdProblemsGroup() {
        return idProblemsGroup;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public void setIdProblemsGroup(String idProblemsGroup) {
        this.idProblemsGroup = idProblemsGroup;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
