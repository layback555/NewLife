package com.swufe.newlife;

public class Reg {
    private int id;
    private String curname;
    private String curtel;
    private String curpassword;

    public Reg() {
        this.curname = curname;
        this.curtel = curtel;
        this.curpassword = curpassword;
    }
    public Reg(String curname,String curpassword){
        this.curname="";
        this.curpassword="";
    }
    public Reg(String curname, String curtel, String curpassword){
        this.curname = "";
        this.curtel = "";
        this.curpassword = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurname() {
        return curname;
    }

    public void setCurname(String curname) {
        this.curname = curname;
    }

    public String getCurtel() {
        return curtel;
    }

    public void setCurtel(String curtel) {
        this.curtel = curtel;
    }

    public String getCurpassword() {
        return curpassword;
    }

    public void setCurpassword(String curpassword) {
        this.curpassword = curpassword;
    }
}
