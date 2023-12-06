        package aoc2023;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Collections;
import java.util.stream.LongStream;
import java.time.Instant;

/**
 * Day_06
 * https://adventofcode.com/2023/day/3
 */
public class Day_06 {

    // static public String inputFile = "/input_06.txt";

    /*
    public ArrayList<String> getInputData(String fileName) {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_06.class.getResourceAsStream(fileName));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            inp.add(line);
        }
        inputScanner.close();
        return inp;
    }
     */

    // function takes input int presstime, int time and return int distance 
    public int distance(int presstime, int time) {
        int distance = 0;
        int timepassed = presstime;
        while (timepassed < time) {
            distance += presstime;
            timepassed++;
        }
        return distance;
    }

    
    public int day06PartOne(Integer[] time, Integer[] distance) {
        ArrayList<Integer> winlist = new ArrayList<>();
        
        for (int i = 0; i < time.length; i++) {
            int wins = 0;
            for (int j = 0; j < time[time.length - 1]; j++) {
                int d = distance(j, time[i]);
                if (d > distance[i]) {
                    wins ++;
                }

            }
            winlist.add(wins);
        }
        // multiply all values in winlist
        int sum = 1;
        for (int i = 0; i < winlist.size(); i++) {
            sum *= winlist.get(i);
        }
        return sum;
    }



    public long distanceL(long presstime, long time) {
        long distance = 0;
        long timepassed = presstime;
        while (timepassed < time) {
            distance += presstime;
            timepassed++;
        }
        return distance;
    }

    public long day06PartTwo(Long time,Long distance ) {
        long wins = 0;

        long min_presstime = 0;
        long max_presstime = time;


        


        while(max_presstime-min_presstime > 1) {
            long new_presstime = (min_presstime + max_presstime) / 2;
            long d = distanceL(new_presstime, time);
            if (d > distance) {
                max_presstime = new_presstime;
            }
            else {
                min_presstime = new_presstime;
            }
            //System.out.println("min: " + min_presstime + " max: " + max_presstime);
            
        }
        long a = max_presstime;
        
        min_presstime = 0;
        max_presstime = time;
        while(max_presstime-min_presstime > 1) {
           
            long new_presstime = (min_presstime + max_presstime) / 2L;
            long d = distanceL(new_presstime, time);
            if (d < distance) {
                max_presstime = new_presstime;
            }
            else {
                min_presstime = new_presstime;
            }
            // System.out.println("min: " + min_presstime + " max: " + max_presstime);
            
        }
        long b = min_presstime;
        
        return b-a+1;
    }
    

    public static void main(String[] args) {

        System.out.println("Advent of code 2023, Day 06\n");
        Day_06 day_06 = new Day_06();
        int answer1;
        long answer2;

        //ArrayList<String> inp = day_06.getInputData(inputFile);
        
        answer1 = day_06.day06PartOne(new Integer[]{47, 84, 74, 67}, new Integer[]{207, 1394, 1209, 1014});

        System.out.println("Solution Part one: " + answer1);

        
        answer2 = day_06.day06PartTwo(47847467L,     207139412091014L);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
Advent of code 2023, Day 06

Solution Part one: 741000
Solution Part two: 38220708
  
 */
