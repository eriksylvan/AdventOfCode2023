package aoc2023;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_03
 * https://adventofcode.com/2023/day/3
 */
public class Day_03 {

    public String inputFile = "/input_03.txt";

    public ArrayList<String> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_03.class.getResourceAsStream(inputFile));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            inp.add(line);
        }
        inputScanner.close();
        return inp;
    }

    
     public int day03PartOne(ArrayList<String> schema) {
        int sum = 0;
        int num = -1; 
        String sym = ".";
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<String> symbols = new ArrayList<String>();
        


        //for each row in schema
        for (int i = 0; i < schema.size(); i++) {
            // new row,  save number if any
            if (num > -1)
            {
                // End of number found
                numbers.add(num);
                symbols.add(sym);
                num = -1;
                sym = ".";
            }
            String row = schema.get(i);
            //System.out.println(row);
            //for each character in row
            for (int j = 0; j < row.length(); j++) {
                char c = row.charAt(j);
                //check if character is a number
                if (Character.isDigit(c)) {
                    // Number found
                    if (num == -1){
                        num = Character.getNumericValue(c);
                    }
                    else{
                        num = num*10 + Character.getNumericValue(c);
                    }
                    boolean hasSymbol = hasSumbolNeghbour(schema, i, j);
                    if (hasSymbol){
                        sym = "*";
                    }


                }
                else
                {
                    if (num > -1){
                        // End of number found
                        numbers.add(num);
                        symbols.add(sym);
                        num = -1;
                        sym = ".";
                    }
                }
            }
        } 
        System.err.println(numbers);
        System.err.println(symbols);

        System.out.println(numbers.size());
        System.out.println(symbols.size());
        System.out.println(sum);

        sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (!symbols.get(i).equals(".")){
                sum += numbers.get(i);
            }
        }
 System.out.println("Hej");

        return sum;
    }

    public boolean hasSumbolNeghbour(ArrayList<String> schema, int row, int col){
        boolean hasSymbol = false;
        // check if symbol is in any of the 8 neighbours
        for (int i = row-1; i <= row+1; i++) {
            if (i < 0 || i >= schema.size()) continue;
            for (int j = col-1; j <= col+1; j++) {
                if (j < 0 || j >= schema.get(i).length()) continue;
                if (i == row && j == col) continue;
                char s = schema.get(i).charAt(j);
                //if (charInList(s, new char[]{',','*','$','+','@','&','?','!','~','^','<','>','|','\\','/','(',')','[',']','{','}'})) {
                    if (!charInList(s, new char[]{'0','1','2','3','4','5','6','7','8','9','.'})) {
                    hasSymbol = true;
                    break;
                }
            }
        }
        return hasSymbol;
    }

    //ascii number
    // find if char equals in a list of chars
    public boolean charInList(char c, char[] list){
        boolean found = false;
        for (char l:list){
            if (c == l){
                found = true;
                break;
            }
        }
        return found;
    }




    public int day03PartTwo(ArrayList<String> schema) {
        int sum = 0;
       
        return sum;
    }




    public static void main(String[] args) {

        System.out.println("Advent of code 2023, Day 03\n");
        Day_03 day_03 = new Day_03();
        int answer1,answer2;

        ArrayList<String> inp = day_03.getInputData();
        answer1 = day_03.day03PartOne(inp);

        System.out.println("Solution Part one: " + answer1);
        answer2 = day_03.day03PartTwo(inp);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
Advent of code 2023, Day 03
Solution Part one: 

fel:
435736


Solution Part two: 
*/
