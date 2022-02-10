package com.survey_in.entity;

public class Option {
    private int id;
    private String data;

    public Option(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public Option(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
