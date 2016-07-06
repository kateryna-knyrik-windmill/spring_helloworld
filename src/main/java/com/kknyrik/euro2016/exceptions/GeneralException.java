package com.kknyrik.euro2016.exceptions;

public class GeneralException extends Exception {

    private String criteria;
    private String value;

    GeneralException(){
    }

    GeneralException(String criteria, String value){
        this.criteria = criteria;
        this.value = value;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
