package aoc2023;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_01
 * https://adventofcode.com/2023/day/1
 */
public class Day_01 {

    String inputFile = "input/input_01.txt";

    public ArrayList<Integer> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_01.class.getResourceAsStream(inputFile));
        ArrayList<Integer> inp = new ArrayList<>();
        while (inputScanner.hasNextInt()) {
            inp.add(inputScanner.nextInt());
        }
        inputScanner.close();
        return inp;
    }

    public int day01PartOne(ArrayList<Integer> numbersList) {
        int sum = 0;
        // Sum of all integers in a list
        for (int f : numbersList) {
            sum += f;
        }
        return sum;
    }

    // Copilot test
    // a function that takes a list of integers and returns the higest number
    public int highestNumber(ArrayList<Integer> numbersList) {

        int highest = Integer.MIN_VALUE;
        for (int f : numbersList) {
            if (f > highest) {
                highest = f;
            }
        }
        return highest;
    }



    public static void main(String[] args) {
        System.out.println("Advent of code 2023, Day 1\n");
        Day_01 day_01 = new Day_01();
        int answer1;
        ArrayList<Integer> inp = day_01.getInputData();
        answer1 = day_01.day01PartOne(inp);
        System.out.println("Solution Part one: " + answer1);        
    }
}

/*
Advent of code 2023, Day 1
Solution Part one: 
Solution Part two: 
*/
