package aoc2023;

import java.util.ArrayList;
import java.util.Arrays;

//mport org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day_04_test {

    Day_04 day04 = new Day_04();

    String[] testData = {      
                        "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
                        "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
                        "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
                        "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
                        "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
                        "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11"};

    
    @Test
    public void testPartOne_1() {
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(testData));

        int expected = 13;
        int actual = day04.day04PartOne(indata);
         assertEquals(expected, actual, "expected: " + expected + " actual: " + actual);
    }


        @Test
    public void testPartOne_2() {
        String[] testData2 = {      "Card   1: 98 16 95 90 53 33 43  7 46 45 | 85 15 78 57 34 10 46 90 33 13  8 54  4 37 25 63 55 41  7 82 69 16 30 76  2", // 5
                                    "Card   2: 55 34 32 64 52 76 54  8 36 94 | 94 95 76 66 38 26 80 54 32 91 19 64 21 55 36 96 52 82 15 56 70 89 46 71 74", // 8
                                    "Card   3: 35 26 78 89 82 92 37 10  3 43 | 41 81 62 52 92 63 26 57 28 55 93 30 72 71 99 84 96 60 82 78 73 65 43 50 25", // 5
                                    "Card   4: 71 27 75 73 79 83 44 55 31 49 | 74 79 17 38 28 41 88 25 61 55 12 40 43 44  6 73 71 83 49 75 67 80 27 10 31", // 10
                                    "Card   5: 26 10 58 57 85 65 42 23 97 30 | 65 26 85 97 31 10 23 88 58 16 80 22 67 44  7 77 30 69 34 42 24 57 66 27 99", // 10
                                    "Card   6: 56 24 39 96 36 46 48 94 30 58 | 16 24 99 48 73 30 91  7 87 57 23 49 69 39 94 63 17 58 56  9 34 36 31 46 96", // 10
                                    "Card   7: 82 75 29 17 66 41 25 52 98  5 | 30 41 73 66 25 57 47 22 89 34 75 21  5 63 90 85 13 38 82 17 29 71 98 52  1", // 10
                                    "Card   8: 45 56 10 72 89 61 64 32 82  7 | 64 32 45 67 84 28  2 56 10 82 55 72  6 61 97 91 89  7 22 70 88  3 41 98 13", // 10
                                    "Card   9: 92 39 44 48 96 72 43 78 98 86 | 76 87  9 45 98 47 31 44 34 92 43 54 72 39 50 96 77 86 62 13 16  6 78 48  8", // 10
                                    "Card  10: 66 44 15 56 88 27 54 51  5 92 | 44 92 18 56 22 85 40 76 90 83  5 13 35 59 27 65 62 15 95 94 81 39 88 54  6"}; // 8

    



        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(testData2));

        int expected = (int) (Math.pow(2, 4)+Math.pow(2, 7)+Math.pow(2, 4)+Math.pow(2, 9)*6+Math.pow(2, 7));
        int actual = day04.day04PartOne(indata);
         assertEquals(expected, actual, "expected: " + expected + " actual: " + actual);
    }







    
    @Test
    public void testPartTwo_1() { 
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(testData));

        int expected = 30;
        int actual = day04.day04PartTwo(indata);
        assertEquals(expected, actual, "expected: " + expected + " actual: " + actual);
    }
}

