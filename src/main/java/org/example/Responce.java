package org.example;

public class Responce {
    String time,name, age, edu, astroSpace, typesAI, inSpace;
    int dailyAI, usefulAI;

    public Responce(String time, String name, String age, String edu, String astroSpace, String typesAI, int dailyAI, int usefulAI, String inSpace){
        this.time = time;
        this.name = name;
        this.age = age;
        this.edu = edu;
        this.astroSpace = astroSpace;
        this.typesAI = typesAI;
        this.dailyAI = dailyAI;
        this.usefulAI = usefulAI;
        this.inSpace = inSpace;
    }

    public String toString(){
        return (time + ", " + name + ", "+age + ", " + edu + ", "+astroSpace + ", " + typesAI + ", "+dailyAI
                + ", " + usefulAI + ", " + inSpace);
    }


}
