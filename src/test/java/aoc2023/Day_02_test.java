package aoc2023;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day_02_test {

    Day_02 day02 = new Day_02();

    String[] testData = {      "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
                            };

    @Test
    public void testPartOne_1() {
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(testData));

        int expected = 8;
        int actual = day02.day02PartOne(indata);
        assertEquals(actual, expected, "expected: " + expected + " actual: " + actual);
    }

    @Test
    public void testPartTwo_1() {
       
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(testData));

        int expected = 2286;
        int actual = day02.day02PartTwo(indata);
        assertEquals(actual, expected, "expected: " + expected + " actual: " + actual);
    }

}
