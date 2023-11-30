package com.devsuperior.DSCommerce.DTO;

import java.time.Instant;

public class CustomError {
    private Instant timeStamp;
    private Integer status;
    private String error;
    private String caminho;

    public CustomError(Instant timeStamp, Integer status, String error, String caminho) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.caminho = caminho;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getCaminho() {
        return caminho;
    }
}
