package aoc2023;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_04
 * https://adventofcode.com/2023/day/3
 */
public class Day_04 {

    public String inputFile = "/input_04.txt";

    public ArrayList<String> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_04.class.getResourceAsStream(inputFile));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            inp.add(line);
        }
        inputScanner.close();
        return inp;
    }

    
     public int day04PartOne(ArrayList<String> cards) {
        int sum = 0;
        int points = 0;
        //                         "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",

        for (String card : cards) {
            // split card into card number and card numbers
            String[] cardParts = card.trim().split(":");
            // split card numbers into numbers
            String[] cardNumbers = cardParts[1].trim().split("\\|");
            String[] winningNumbers = cardNumbers[0].trim().split("\\s+");
            String[] yourNumbers = cardNumbers[1].trim().split("\\s+");
            
            int wins = 0;
            for (String winningNumber : winningNumbers) {
                for (String yourNumber : yourNumbers) {
                    if (winningNumber.equals(yourNumber)) {
                       // System.out.println("YES winningNumber: " + winningNumber + " yourNumber: " + yourNumber);
                        wins++;
                    }
                }
            }
            points += Math.pow(2, (wins-1));
            

        }


        return points;
    }



    // Part two


    public int day04PartTwo(ArrayList<String> cards) {
        int sum = 0;
        
        int[] numberOfWins = new int[cards.size()];

        for (String card : cards) {
            // split card into card number and card numbers
            String[] cardParts = card.trim().split(":");
            int cardno = Integer.parseInt(cardParts[0].trim().split("\\s+")[1]);
            // split card numbers into numbers
            String[] cardNumbers = cardParts[1].trim().split("\\|");
            String[] winningNumbers = cardNumbers[0].trim().split("\\s+");
            String[] yourNumbers = cardNumbers[1].trim().split("\\s+");
            
            

            //print cardParts[0] + " " + winningNumbers + " " + yourNumbers;
            // compare winning numbers with your numbers
            int wins = 0;
            for (String winningNumber : winningNumbers) {
                for (String yourNumber : yourNumbers) {
                    if (winningNumber.equals(yourNumber)) {
                        //System.out.println("YES winningNumber: " + winningNumber + " yourNumber: " + yourNumber);
                        wins++;
                    }
                }
            }
            numberOfWins[cardno-1] = wins;
        }
        
        int[] cardCount = new int[numberOfWins.length];

        for (int i = 0; i < cardCount.length; i++) {
            cardCount[i] = 1;
        }


        for (int i = 0; i < numberOfWins.length; i++) {
            for (int j = 1;j <= numberOfWins[i]; j++) {
                cardCount[i+j] += cardCount[i];
            }
        }

        // sum all cardCount
        for (int i : cardCount) {
            sum += i;
        }
        return sum;
    }




    public static void main(String[] args) {

        System.out.println("Advent of code 2023, Day 04\n");
        Day_04 day_04 = new Day_04();
        int answer1,answer2;

        ArrayList<String> inp = day_04.getInputData();
        answer1 = day_04.day04PartOne(inp);

        System.out.println("Solution Part one: " + answer1);
        answer2 = day_04.day04PartTwo(inp);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
Advent of code 2023, Day 04

Solution Part one: 26426
Solution Part two: 6227972
*/
