package com.example.calculator.models;

public class Result {
    private float result;
    private String status;

    public void setResult(float result) {
        this.result = result;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getResult() {
        return this.result;
    }

    public String getStatus() {
        return this.status;
    }
    public Result(){
        setResult(0);
        setStatus("pending");
    }
}
