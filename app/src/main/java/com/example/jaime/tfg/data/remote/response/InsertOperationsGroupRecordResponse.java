package com.example.jaime.tfg.data.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 19/03/2018.
 */

public class InsertOperationsGroupRecordResponse {
    @SerializedName("LAST_INSERT_ID()")
    @Expose
    String idRecord;

    public InsertOperationsGroupRecordResponse(String idRecord) {
        this.idRecord = idRecord;
    }

    public String getIdRecord() {
        return idRecord;
    }
}
