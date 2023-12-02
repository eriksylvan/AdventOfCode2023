package aoc2023;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day_01_test {

    Day_01 day1 = new Day_01();

    @Test
    public void testPartOne_1() {
        String[] input = { "1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet" };
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(input));

        int expected = 142;
        int actual = day1.day01PartOne(indata);
        assertEquals(actual, expected, "expected: " + expected + " actual: " + actual);
    }

    @Test
    public void testPartTwo_2() {
        String[] input = { "two1nine", "eightwothree", "abcone2threexyz", "xtwone3four", "4nineeightseven2", "zoneight234", "7pqrstsixteen" };
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(input));

        int expected = 281;
        int actual = day1.day01PartOne(indata);
        assertEquals(actual, expected, "expected: " + expected + " actual: " + actual);
    }
}
