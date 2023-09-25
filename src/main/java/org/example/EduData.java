package org.example;

public class EduData extends ResponseData{
    String degree;

    public EduData(String degree) {
        super("edu");
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    public String toString(){
        return degree + ": " + count;
    }
}
