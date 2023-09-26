package org.example;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

    static FileInputStream fis;
    static XSSFWorkbook wb;
    static XSSFSheet sheet;

    static AgeData[] age = new AgeData[6];
    static EduData[] edu = new EduData[5];

    static Response[] responses = new Response[114];

    public static void main(String[] args) {
        try {
            for(int i = 0; i < 6; i++){
                switch(i){
                    case 0: age[i] = new AgeData( "14 or younger"); edu[i] = new EduData("Current High School Student");
                        break;
                    case 1: age[i] = new AgeData( "15-18"); edu[i] = new EduData("High School Diploma/ GED");
                        break;
                    case 2: age[i] = new AgeData( "19-25"); edu[i] = new EduData("Undergraduate's");
                        break;
                    case 3: age[i] = new AgeData( "26-35"); edu[i] = new EduData("Graduate's Degrees/Masters");
                        break;
                    case 4: age[i] = new AgeData( "36-57"); edu[i] = new EduData("PhD/Doctorate");
                        break;
                    case 5: age[i] = new AgeData( "58 or older");
                        break;
                }
            }
            wb = new XSSFWorkbook(new File("C:\\Users\\spenc\\OneDrive\\Documents\\RandomShit\\SwerveTesting\\HUNCH_SURVEY_DATA\\src\\main\\java\\org\\example\\Problem Survey - HUNCH AI Assistant  (Responses).xlsx"));
            sheet = wb.cloneSheet(0);

            for (int i = 0; i < 114; i++) {
                Row row = sheet.getRow(i+1);
                responses[i] = new Response(row.getCell(0).getDateCellValue().toString(),row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue(),row.getCell(3).getStringCellValue(),row.getCell(4).getStringCellValue(),row.getCell(5).getStringCellValue(),(int)row.getCell(6).getNumericCellValue() ,(int)row.getCell(7).getNumericCellValue(), row.getCell(8).getStringCellValue());

            }
            counting();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void counting(){
        for(Response r : responses){
            if(r.age == null || r.edu == null) {
                System.out.println(r.toString());
            }

            switch (r.age){
                case "14 or younger" -> age[0].countUp();
                case "15-18" -> age[1].countUp();
                case "19-25" -> age[2].countUp();
                case "26-35" -> age[3].countUp();
                case "36-57" -> age[4].countUp();
                case "58 or older" -> age[5].countUp();
            }

            switch (r.edu){
                case "Current High School Student" -> edu[0].countUp();
                case "High School Diploma/ GED" -> edu[1].countUp();
                case "Undergraduate's" -> edu[2].countUp();
                case "Graduate's Degrees/Masters" -> edu[3].countUp();
                case "PhD/Doctorate" -> edu[4].countUp();
            }
        }
        results();
    }

    public static void results(){
        for(AgeData a : age){
            System.out.println(a.toString());
        }

        for(EduData e : edu){
            System.out.println(e.toString());
        }

        analyze();
        analyzeAgain();
    }

    public static void analyze(){
        int[][] eduRes = new int[5][5];

        for (Response r : responses){
            switch (r.edu){
                case "Current High School Student"-> {
                    switch (r.usefulAI) {
                        case 1 -> eduRes[0][0]++;
                        case 2 -> eduRes[0][1]++;
                        case 3 -> eduRes[0][2]++;
                        case 4 -> eduRes[0][3]++;
                        case 5 -> eduRes[0][4]++;
                        default -> {}
                    }
                }
                case "High School Diploma/ GED"-> {
                    switch (r.usefulAI) {
                        case 1 -> eduRes[1][0]++;
                        case 2 -> eduRes[1][1]++;
                        case 3 -> eduRes[1][2]++;
                        case 4 -> eduRes[1][3]++;
                        case 5 -> eduRes[1][4]++;
                        default -> {}
                    }
                }
                case "Undergraduate's" ->{
                    switch (r.usefulAI) {
                        case 1 -> eduRes[2][0]++;
                        case 2 -> eduRes[2][1]++;
                        case 3 -> eduRes[2][2]++;
                        case 4 -> eduRes[2][3]++;
                        case 5 -> eduRes[2][4]++;
                        default -> {}
                    }
                }
                case "Graduate's Degrees/Masters" ->{
                    switch (r.usefulAI) {
                        case 1 -> eduRes[3][0]++;
                        case 2 -> eduRes[3][1]++;
                        case 3 -> eduRes[3][2]++;
                        case 4 -> eduRes[3][3]++;
                        case 5 -> eduRes[3][4]++;
                        default -> {}
                    }
                }
                case "PhD/Doctorate" ->{
                    switch (r.usefulAI) {
                        case 1 -> eduRes[4][0]++;
                        case 2 -> eduRes[4][1]++;
                        case 3 -> eduRes[4][2]++;
                        case 4 -> eduRes[4][3]++;
                        case 5 -> eduRes[4][4]++;
                        default -> {}
                    }
                }
            }
        }
        
        System.out.println();
        System.out.println("Current High School Student:\n 1: " + eduRes[0][0] + " 2:" + eduRes[0][1]+ " 3:" + eduRes[0][2]+ " 4:" + eduRes[0][3]+ " 5:" + eduRes[0][4]);
        System.out.println("High School Diploma/ GED:\n 1: " + eduRes[1][0] + " 2:" + eduRes[1][1]+ " 3:" + eduRes[1][2]+ " 4:" + eduRes[1][3]+ " 5:" + eduRes[1][4]);
        System.out.println("Undergraduate's:\n 1: " + eduRes[2][0] + " 2:" + eduRes[2][1]+ " 3:" + eduRes[2][2]+ " 4:" + eduRes[2][3]+ " 5:" + eduRes[2][4]);
        System.out.println("Graduate's Degrees/Masters:\n 1: " + eduRes[3][0] + " 2:" + eduRes[3][1]+ " 3:" + eduRes[3][2]+ " 4:" + eduRes[3][3]+ " 5:" + eduRes[3][4]);
        System.out.println("PhD/Doctorate:\n 1: " + eduRes[4][0] + " 2:" + eduRes[4][1]+ " 3:" + eduRes[4][2]+ " 4:" + eduRes[4][3]+ " 5:" + eduRes[4][4]);

    }

    public static void analyzeAgain(){
        int[][] eduRes = new int[6][5];

        for (Response r : responses){
            switch (r.age){
                case "14 or younger"-> {
                    switch (r.dailyAI) {
                        case 1 -> eduRes[0][0]++;
                        case 2 -> eduRes[0][1]++;
                        case 3 -> eduRes[0][2]++;
                        case 4 -> eduRes[0][3]++;
                        case 5 -> eduRes[0][4]++;
                        default -> {}
                    }
                }
                case "15-18"-> {
                    switch (r.dailyAI) {
                        case 1 -> eduRes[1][0]++;
                        case 2 -> eduRes[1][1]++;
                        case 3 -> eduRes[1][2]++;
                        case 4 -> eduRes[1][3]++;
                        case 5 -> eduRes[1][4]++;
                        default -> {}
                    }
                }
                case "19-25" ->{
                    switch (r.dailyAI) {
                        case 1 -> eduRes[2][0]++;
                        case 2 -> eduRes[2][1]++;
                        case 3 -> eduRes[2][2]++;
                        case 4 -> eduRes[2][3]++;
                        case 5 -> eduRes[2][4]++;
                        default -> {}
                    }
                }
                case "26-35" ->{
                    switch (r.dailyAI) {
                        case 1 -> eduRes[3][0]++;
                        case 2 -> eduRes[3][1]++;
                        case 3 -> eduRes[3][2]++;
                        case 4 -> eduRes[3][3]++;
                        case 5 -> eduRes[3][4]++;
                        default -> {}
                    }
                }
                case "36-57" ->{
                    switch (r.dailyAI) {
                        case 1 -> eduRes[4][0]++;
                        case 2 -> eduRes[4][1]++;
                        case 3 -> eduRes[4][2]++;
                        case 4 -> eduRes[4][3]++;
                        case 5 -> eduRes[4][4]++;
                        default -> {}
                    }
                }
                case "58 or older" ->{
                    switch (r.dailyAI) {
                        case 1 -> eduRes[5][0]++;
                        case 2 -> eduRes[5][1]++;
                        case 3 -> eduRes[5][2]++;
                        case 4 -> eduRes[5][3]++;
                        case 5 -> eduRes[5][4]++;
                        default -> {}
                    }
                }
            }
        }

        System.out.println();
        System.out.println("14 or younger:\n 1: " + eduRes[0][0] + " 2:" + eduRes[0][1]+ " 3:" + eduRes[0][2]+ " 4:" + eduRes[0][3]+ " 5:" + eduRes[0][4]);
        System.out.println("15-18:\n 1: " + eduRes[1][0] + " 2:" + eduRes[1][1]+ " 3:" + eduRes[1][2]+ " 4:" + eduRes[1][3]+ " 5:" + eduRes[1][4]);
        System.out.println("19-25:\n 1: " + eduRes[2][0] + " 2:" + eduRes[2][1]+ " 3:" + eduRes[2][2]+ " 4:" + eduRes[2][3]+ " 5:" + eduRes[2][4]);
        System.out.println("26-35:\n 1: " + eduRes[3][0] + " 2:" + eduRes[3][1]+ " 3:" + eduRes[3][2]+ " 4:" + eduRes[3][3]+ " 5:" + eduRes[3][4]);
        System.out.println("36-57:\n 1: " + eduRes[4][0] + " 2:" + eduRes[4][1]+ " 3:" + eduRes[4][2]+ " 4:" + eduRes[4][3]+ " 5:" + eduRes[4][4]);
        System.out.println("58 or older:\n 1: " + eduRes[5][0] + " 2:" + eduRes[5][1]+ " 3:" + eduRes[5][2]+ " 4:" + eduRes[5][3]+ " 5:" + eduRes[5][4]);

    }



}