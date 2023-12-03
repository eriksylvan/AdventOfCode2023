package aoc2023;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_02
 * https://adventofcode.com/2023/day/2
 */
public class Day_02 {

    public String inputFile = "/input_02.txt";

    public ArrayList<String> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_02.class.getResourceAsStream(inputFile));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            inp.add(line);
        }
        inputScanner.close();
        return inp;
    }

    
     public int day02PartOne(ArrayList<String> games) {
        int sum = 0;

        for (String g : games) {
           //split string by ':' into array of strings
            String[] game = g.trim().split(":");

            String[] round = game[1].trim().split(";");
            boolean validRound = true;
            for (String r:round){
                String[] cubes = r.trim().split(",");
                for (String c:cubes){
                    String[] noOfCubes = c.trim().split(" ");
                    if ("red".equals(noOfCubes[1])){
                        if (Integer.parseInt(noOfCubes[0]) <= 12) {

                        }
                        else {
                            //System.err.println(" red does not fit in 12"); 
                             // game not valid
                            validRound = false;
                            break;
                        }
                    }
                    if ("green".equals(noOfCubes[1])){
                        if (Integer.parseInt(noOfCubes[0]) <= 13) {
                            //System.err.println(" green fits in 13"); 
                        }
                        else {
                            //System.err.println(" green does not fit in 13"); 
                             // game not valid
                            validRound = false;
                            break;
                        }
                    }
                    if ("blue".equals(noOfCubes[1])){
                        if (Integer.parseInt(noOfCubes[0]) <= 14) {
                            //System.err.println(" blue fits in 14"); 
                        }
                        else {
                            //System.err.println(" blue does not fit in 14"); 
                            // game not valid
                            validRound = false;
                            break;
                        }
                    }
                }
                if (!validRound) {
                   
                    break;
                }
            }
            if (validRound) {
                //System.out.println("valid game");
                sum+= Integer.parseInt(game[0].trim().split(" ")[1]);

            }
        }
        return sum;
    }


    public int day02PartTwo(ArrayList<String> games) {
        int sum = 0;
        //loop through calibrationList 
        for (String g : games) {
           //System.out.println(g);
           //split string by ':' into array of strings
            String[] game = g.trim().split(":");
            String[] round = game[1].trim().split(";");
            int max_red = 0, max_green = 0, max_blue = 0; 
            for (String r:round){
                String[] cubes = r.trim().split(",");
                for (String c:cubes){
                    String[] noOfCubes = c.trim().split(" ");
                    String color = noOfCubes[1];
                    int cubesno = Integer.parseInt(noOfCubes[0]);
                    if ("red".equals(color)){
                        if (cubesno > max_red) {
                            max_red = cubesno;
                        }                   
                    }
                    if ("green".equals(color)){
                        if (cubesno > max_green) {
                           max_green = cubesno;
                        }             
                    }
                    if ("blue".equals(color)){
                        if (cubesno > max_blue) {
                            max_blue = cubesno;
                        }
                    }
                }
                
            }
            sum += max_red * max_green * max_blue;
        }
        return sum;
    }




    public static void main(String[] args) {

        System.out.println("Advent of code 2023, Day 02\n");
        Day_02 day_02 = new Day_02();
        int answer1,answer2;

        ArrayList<String> inp = day_02.getInputData();
        answer1 = day_02.day02PartOne(inp);

        System.out.println("Solution Part one: " + answer1);
        answer2 = day_02.day02PartTwo(inp);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
Advent of code 2023, Day 02

Solution Part one: 2317
Solution Part two: 74804
*/
