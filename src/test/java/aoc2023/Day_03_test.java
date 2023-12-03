package aoc2023;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day_03_test {

    Day_03 day03 = new Day_03();

    String[] testData = {      
                        "467..114..",
                        "...*......",
                        "..35..633.",
                        "......#..1",
                        "617*......",
                        ".....+.58.",
                        "..592.....",
                        "......755.",
                        "...$.*....",
                        ".664.598.."};

    @Test
    public void testPartOne_1() {
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(testData));

        int expected = 4361;
        int actual = day03.day03PartOne(indata);
        assertEquals(expected, actual, "expected: " + expected + " actual: " + actual);
    }

    @Disabled
    @Test
    public void testPartTwo_1() {
       
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(testData));

        int expected = 2286;
        int actual = day03.day03PartTwo(indata);
        assertEquals(actual, expected, "expected: " + expected + " actual: " + actual);
    }

}
