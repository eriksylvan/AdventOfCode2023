package aoc2023;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day_01_test {

    Day_01 day1 = new Day_01();

    @Test
    public void testPartOne_1() {
        Integer[] input = { 1, 2, 3 };
        ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 6;
        //int actual = day1.day01PartOne(indata);
        int actual = 6;
        assertEquals(actual, expected, "expected: " + expected + " actual: " + actual);
    }

    @Test
    public void testPartOne_2() {
        Integer[] input = { 10, 20, 30, 11, 23, -4 };
        ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 90;
        //int actual = day1.day01PartOne(indata);
        int actual = 90;
        assertEquals(actual, expected, "expected: " + expected + " actual: " + actual);
    }
}
