package org.example;

public class AgeData extends ResponseData{
    String ageRange;
    public AgeData(String ageRange) {
        super("age");
        this.ageRange = ageRange;
    }

    public String getRange(){
        return ageRange;
    }

    public void setRange(String ageRange){
        this.ageRange = ageRange;
    }

    public String toString(){
        return ageRange + ": " + count;
    }

}
