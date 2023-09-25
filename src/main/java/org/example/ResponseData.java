package org.example;

public class ResponseData {
    String type;
    int count=0;

    public ResponseData(String type){
        this.type = type;
    }

    public void countUp(){
        count++;
    }

    public int displayCount(){
        return count;
    }
}
