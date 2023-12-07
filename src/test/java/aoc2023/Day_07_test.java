package aoc2023;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day_07_test {

    Day_07 day07 = new Day_07();

    String[] testData = {   
                        "32T3K 765",
                        "T55J5 684",
                        "KK677 28",
                        "KTJJT 220",
                        "QQQJA 483",
                        "AAAAA 0",
                        "ABABA 0",
                        "12345 0"};
    
    @Test
    public void testPartOne_1() {
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(testData));


        int expected = 6440;
        int actual = day07.day07PartOne(indata);
        assertEquals(expected, actual, "expected: " + expected + " actual: " + actual);
    }

    @Disabled
    @Test
    public void testPartTwo_1() { 
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(testData));

        int expected = 0;
        int actual = day07.day07PartOne(indata);
        assertEquals(expected, actual, "expected: " + expected + " actual: " + actual);
    }
}

