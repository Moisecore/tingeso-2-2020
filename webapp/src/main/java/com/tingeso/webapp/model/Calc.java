package com.tingeso.webapp.model;

public class Calc {

    private double num1;
    private double num2;
    private String oper;
    private String res;

    public Calc(double num1, double num2, String oper, String res) {
        this.num1 = num1;
        this.num2 = num2;
        this.oper = oper;
        this.res = res;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
