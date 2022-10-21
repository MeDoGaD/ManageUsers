package com.cis.manageAccounts.errors;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ValidationError {
    private List<String>errors;
    private String uri;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy >> hh:mm:ss  :)")
    private Date timestamp;

    public ValidationError() {
        errors=new ArrayList<>();
        timestamp=new Date();
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public void addError(String error)
    {
        this.errors.add(error);
    }
}
