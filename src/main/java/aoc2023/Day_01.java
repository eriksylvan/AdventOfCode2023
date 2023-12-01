package aoc2023;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_01
 * https://adventofcode.com/2023/day/1
 */
public class Day_01 {

    public String inputFile = "/input_01.txt";

    public ArrayList<String> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_01.class.getResourceAsStream(inputFile));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
           // System.out.println(line);
            inp.add(line);
        }
        inputScanner.close();
        return inp;
    }

    public int day01PartOne(ArrayList<String> calibrationList) {
        int sum = 0;
        ArrayList<Integer> numbersList = new ArrayList<>();
        
        //loop through calibrationList
        for (String s : calibrationList) {
            //find first numeric character in s
            int i = 0;
            while (!Character.isDigit(s.charAt(i))) {
                i++;
            }
            String firstNumber = s.substring(i,i+1);
            //find last numeric character in s
            int j = s.length() - 1; // last index of s
            while (!Character.isDigit(s.charAt(j))) {
                j--;
            }
            String lastNumber = s.substring(j,j+1);
            numbersList.add(Integer.parseInt(firstNumber + lastNumber));
        }
        //return sum of all integers in numbersList
        for (int f : numbersList) {
            sum += f;
        } 
        return sum;
    }

     public int day01PartTwo(ArrayList<String> calibrationList) {
        int sum = 0;
        ArrayList<Integer> numbersList = new ArrayList<>();
        
        //loop through calibrationList
        for (String s : calibrationList) {

            s = s.replaceAll("zero", "zero0zero");
            s = s.replaceAll("one", "one1one");
            s = s.replaceAll("two", "two2two");
            s = s.replaceAll("three", "three3three");
            s = s.replaceAll("four", "four4four");
            s = s.replaceAll("five", "five5five");
            s = s.replaceAll("six", "six6six");
            s = s.replaceAll("seven", "seven7seven");
            s = s.replaceAll("eight", "eight8eight");
            s = s.replaceAll("nine", "nine9nine");

            //find first numeric character in s
            int i = 0;
            while (!Character.isDigit(s.charAt(i))) {
                i++;
            }
            String firstNumber = s.substring(i,i+1);
            //find last numeric character in s
            int j = s.length() - 1; // last index of s
            while (!Character.isDigit(s.charAt(j))) {
                j--;
            }
            String lastNumber = s.substring(j,j+1);
            //print firstNumber + lastNumber
            //System.out.println(firstNumber + lastNumber);
            numbersList.add(Integer.parseInt(firstNumber + lastNumber));
        }
        //return sum of all integers in numbersList
        for (int f : numbersList) {
            sum += f;
        } 
        return sum;
    }


    



    public static void main(String[] args) {

        System.out.println("Advent of code 2023, Day 1\n");
        Day_01 day_01 = new Day_01();
        int answer1,answer2;

        ArrayList<String> inp = day_01.getInputData();
        answer1 = day_01.day01PartOne(inp);

        System.out.println("Solution Part one: " + answer1);
        answer2 = day_01.day01PartTwo(inp);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
Advent of code 2023, Day 1
Solution Part one: 55017
Solution Part two: 53539
*/
