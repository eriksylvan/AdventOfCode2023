package aoc2023;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day_06_test {

    Day_06 day06 = new Day_06();

    //static public String inputFile = "/input_06_test1.txt";
    
    
    @Test
    public void testPartOne_1() {
        //ArrayList<String> indata = day06.getInputData(inputFile);
        Integer[] time = new Integer[]{7, 15, 30};
        Integer[] dist = new Integer[]{9,  40,  200};

        long expected = 288;
        long actual = day06.day06PartOne(time, dist);
        assertEquals(expected, actual, "expected: " + expected + " actual: " + actual);
    }

    
    @Test
    public void testPartTwo_1() { 
        //ArrayList<String> indata = day06.getInputData(inputFile);

       
        long time = 71530;
        long dist = 940200;

        long expected = 71503;
        long actual = day06.day06PartTwo(time, dist);
        assertEquals(expected, actual, "expected: " + expected + " actual: " + actual);
    }
}

