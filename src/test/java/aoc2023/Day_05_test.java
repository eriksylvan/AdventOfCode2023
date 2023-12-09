package aoc2023;

import java.util.ArrayList;


//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day_05_test {

    Day_05 day05 = new Day_05();

    static public String inputFile = "/input_05_test1.txt";
    
    
    @Test
    public void testPartOne_1() {
        ArrayList<String> indata = day05.getInputData(inputFile);

        long expected = 35;
        long actual = day05.day05PartOne(indata);
         assertEquals(expected, actual, "expected: " + expected + " actual: " + actual);
    }









    
    @Test
    public void testPartTwo_1() { 
        ArrayList<String> indata = day05.getInputData(inputFile);

       
        long expected = 46;
        long actual = day05.day05PartTwo(indata);
        assertEquals(expected, actual, "expected: " + expected + " actual: " + actual);
    }
}

