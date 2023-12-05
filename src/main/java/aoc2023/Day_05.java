package aoc2023;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Collections;
import java.util.stream.LongStream;
import java.time.Instant;

/**
 * Day_05
 * https://adventofcode.com/2023/day/3
 */
public class Day_05 {

    static public String inputFile = "/input_05.txt";

    public ArrayList<String> getInputData(String fileName) {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_05.class.getResourceAsStream(fileName));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            inp.add(line);
        }
        inputScanner.close();
        return inp;
    }

    public long day05PartOne(ArrayList<String> almanack) {
        int sum = 0;

        ArrayList<Long> seeds = new ArrayList<>();

        ArrayList<ArrayList<Long[]>> maps = new ArrayList<>();

        String[] seedstr = almanack.get(0).split(": ")[1].trim().split("\s+");
        for (String s : seedstr) {
            seeds.add(Long.parseLong(s));
        }

        int mapIndex = -1;
        // print out seeds
        System.out.println(seeds);
        // loop through the rest of the almanack
        for (int i = 1; i < almanack.size(); i++) {
            if (almanack.get(i).equals("")) {
                continue;
            }
            String[] parts = almanack.get(i).split(" ");
            // if part[] is "map:" then continue
            if (parts[1].equals("map:")) {
                mapIndex++;
                maps.add(new ArrayList<>());
                continue;
            }

            long[] dataRow = new long[3];
            for (int j = 0; j < 3; j++) {
                dataRow[j] = Long.parseLong(parts[j]);
            }
            maps.get(mapIndex).add(new Long[] { dataRow[0], dataRow[1], dataRow[2] });
        }

        // System.out.println(maps);
        // for each map

        /*
         * for (int i = 0; i < maps.size(); i++) {
         * for (int j = 0; j < maps.get(i).size(); j++) {
         * for (int st : maps.get(i).get(j)) {
         * System.out.println("map: " + i + " row: " + j + " seed: " + st);
         * }
         * }
         * }
         */

        ArrayList<Long> mappedValues = new ArrayList<>();
        // for all seeds
        for (long s : seeds) {
            // System.out.println("NEW SEED");
            long newValue = s;
            // for each map
            for (int i = 0; i < maps.size(); i++) {
                // for each row in map
                // System.out.println("NEW MAP");
                newValue = s;
                for (int j = 0; j < maps.get(i).size(); j++) {
                    // if seed is in row
                    long tmp = mapValue(maps.get(i).get(j)[0], maps.get(i).get(j)[1], maps.get(i).get(j)[2], s);
                    if (tmp == -1) {
                        continue;
                    } else {
                        newValue = tmp;
                        break;
                    }
                }
                // System.out.println("new value: " + newValue);
                s = newValue;
            }

            mappedValues.add(newValue);
        }

        Collections.sort(mappedValues);
        return mappedValues.get(0);
    }

    public long mapValue(long dest, long src, long len, long value) {
        long mappedValue = -1; // default value -1 = no value found

        if (value >= src && value <= src + len) {
            mappedValue = dest + (value - src);
        }
        return mappedValue;
    }

    // Part two

    public long day05PartTwo(ArrayList<String> almanack) {

        AtomicLong lowest = new AtomicLong(Long.MAX_VALUE);
        ArrayList<Long> seeds = new ArrayList<>();

        ArrayList<ArrayList<Long[]>> maps = new ArrayList<>();

        String[] seedstr = almanack.get(0).split(": ")[1].trim().split("\s+");
        for (String s : seedstr) {
            seeds.add(Long.parseLong(s));
        }

        int mapIndex = -1;
        // print out seeds
        System.out.println(seeds);
        // loop through the rest of the almanack
        for (int i = 1; i < almanack.size(); i++) {
            if (almanack.get(i).equals("")) {
                continue;
            }
            String[] parts = almanack.get(i).split(" ");
            // if part[] is "map:" then continue
            if (parts[1].equals("map:")) {
                mapIndex++;
                maps.add(new ArrayList<>());
                continue;
            }

            long[] dataRow = new long[3];
            for (int j = 0; j < 3; j++) {
                dataRow[j] = Long.parseLong(parts[j]);
            }
            maps.get(mapIndex).add(new Long[] { dataRow[0], dataRow[1], dataRow[2] });
        }

        // System.out.println(maps);
        // for each map

        /*
         * for (int i = 0; i < maps.size(); i++) {
         * for (int j = 0; j < maps.get(i).size(); j++) {
         * for (int st : maps.get(i).get(j)) {
         * System.out.println("map: " + i + " row: " + j + " seed: " + st);
         * }
         * }
         * }
         */

        ArrayList<Long> mappedValues = new ArrayList<>();
        // for all seeds in range
        for (int a = 0; a < seeds.size(); a += 2) {
            // Creating an LongStream
            System.out.println("a: " + a + " : " + seeds.get(a) + " : " + seeds.get(a + 1) + " : " + Instant.now());

            LongStream seedrange = LongStream.range(seeds.get(a), seeds.get(a) + seeds.get(a + 1) + 1);

            seedrange.forEach(s -> {
                // System.out.println("NEW SEED");
                long newValue = s;
                long startSeed = s;

                // for each map
                for (int i = 0; i < maps.size(); i++) {
                    // for each row in map
                    // System.out.println("NEW MAP");
                    newValue = s;
                    for (int j = 0; j < maps.get(i).size(); j++) {
                        // if seed is in row
                        long tmp = mapValue(maps.get(i).get(j)[0], maps.get(i).get(j)[1], maps.get(i).get(j)[2], s);
                        if (tmp == -1) {
                            continue;
                        } else {
                            newValue = tmp;
                            break;
                        }
                    }
                    // System.out.println("new value: " + newValue);
                    s = newValue;
                }

                // mappedValues.add(newValue);
                if (newValue < lowest.get()) {
                    lowest.set(newValue);
                    System.out.println("new lowest: " + newValue + " startSeed : " + startSeed + " : " + Instant.now());
                }
            });
        }

        // Collections.sort(mappedValues);
        // return mappedValues.get(0);
        return lowest.get();
    }

    public static void main(String[] args) {

        System.out.println("Advent of code 2023, Day 05\n");
        Day_05 day_05 = new Day_05();
        long answer1;
        long answer2;

        ArrayList<String> inp = day_05.getInputData(inputFile);
        answer1 = day_05.day05PartOne(inp);

        System.out.println("Solution Part one: " + answer1);
        answer2 = day_05.day05PartTwo(inp);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
 * Advent of code 2023, Day 05
 * 
 * Solution Part one: 600279879
 * Solution Part two:
 * WRONG:
 * Solution Part two: 20191103
 * 
 */
