package com.devsuperior.DSCommerce.DTO;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {
    private List<FieldMessage> fieldMessageList = new ArrayList<>();

    public ValidationError(Instant timeStamp, Integer status, String error, String caminho) {
        super(timeStamp, status, error, caminho);
    }

    public List<FieldMessage> getFieldMessageList() {
        return fieldMessageList;
    }

    public void addError(String fieldName, String message) {
        fieldMessageList.add(new FieldMessage(fieldName, message));
    }
}
