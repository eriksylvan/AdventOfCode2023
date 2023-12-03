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
                    boolean hasSymbol = hasSymbolNeghbour(schema, i, j);
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

        return sum;
    }

    public boolean hasSymbolNeghbour(ArrayList<String> schema, int row, int col){
        boolean hasSymbol = false;
        // check if symbol is in any of the 8 neighbours
        for (int i = row-1; i <= row+1; i++) {
            if (i < 0 || i >= schema.size()) continue;
            for (int j = col-1; j <= col+1; j++) {
                if (j < 0 || j >= schema.get(i).length()) continue;
                if (i == row && j == col) continue;
                char s = schema.get(i).charAt(j);
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

    // create a function that takes a schema and a row and col the return the number that is found at that position
    public int getNumber(ArrayList<String> schema, int row, int col){
        int colstartpos = 0;
        int num = -1;
        //go left until '.'
        for (int i = col-1; i >= 0; i--) {
            char c = schema.get(row).charAt(i);
            if (!Character.isDigit(c)){
                colstartpos = i+1;
                break;
            }
        }
        
        //go right until char is not a digit
        for (int i = colstartpos; i < schema.get(row).length(); i++) {
            char c = schema.get(row).charAt(i);
            if (!Character.isDigit(c)){
                break;
            }
            else{
                if (num == -1){
                    num = Character.getNumericValue(c);
                }
                else{
                    num = num*10 + Character.getNumericValue(c);
                }
            }
        } 
        return num;
    }


    // Part two


    public int day03PartTwo(ArrayList<String> schema) {
        int sum = 0;
        //define array of tuples (row, col, neighbourcount)
        ArrayList<int[]> neghboArrayList = new ArrayList<int[]>(); 
        ArrayList<int[]> symbolArrayList = new ArrayList<int[]>(); 



        // loop through schema find car '*'
        for (int i = 0; i < schema.size(); i++) {
            String row = schema.get(i);
            //System.out.println(row);
            //for each character in row
            for (int j = 0; j < row.length(); j++) {
                char c = row.charAt(j);
                //check if character is a number
                if (c == '*') {
                    // Number found
                    //System.out.println("found *");
                    // check if symbol is in any of the 8 neighbours
                    boolean numberFound = false;
                    int neighbourcount =0;
                    for (int k = i-1; k <= i+1; k++) {
                        numberFound = false;
                        if (k < 0 || k >= schema.size()) continue;
                        for (int l = j-1; l <= j+1; l++) {
                            if (l < 0 || l >= schema.get(k).length()) continue;
                            if (k == i && l == j) {
                                numberFound = false;
                                continue;
                            }

                            char s = schema.get(k).charAt(l);
                            if (Character.isDigit(s)&&!numberFound){
                                numberFound = true;
                                neighbourcount++;
                                neghboArrayList.add(new int[]{k,l, i,j});
                                continue;
                            }
                            else{
                                numberFound = false;
                            }
                        }
                    }
                    //System.out.println("neighbourcount: " + neighbourcount+ " i: " + i + " j: " + j);
                    symbolArrayList.add(new int[]{i,j,neighbourcount});
                   
                }
            }
        }
         // loop through neighboursArrayList and print 
        // System.out.println("neighborArrayList"); 
        for (int[] n:neghboArrayList){
            //System.out.println("row: " + n[0] + " col: " + n[1] + "*row: " + n[2] + " *col: " + n[3]);
            //System.out.println(getNumber(schema, n[0], n[1]));
            }    
        // loop through symbolArrayList and print

        //System.out.println("symbolArrayList");
        for (int[] s:symbolArrayList){
            //System.out.println("row: " + s[0] + " col: " + s[1] + " neighbourcount: " + s[2]);
            }   


        // loop through symbolArrayList and print

        // define an ArrayList of integers
        ArrayList<Integer> findNumber = new ArrayList<>();   
        for (int[] s:symbolArrayList){
            int p =1;
            if (s[2] == 2){
                // fild all numbers that neighbor that position
                for (int[] n:neghboArrayList){
                    if (n[2] == s[0] && n[3] == s[1]){
                        p*=getNumber(schema, n[0], n[1]);
                       // System.out.println("p: " + p);
                    }
                }
                sum += p;
            }
            
           // System.out.println("sum: " + sum);
        }

      



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
Solution Part one: 556367
Solution Part two: 0
fel:71446313

fel:
435736


Solution Part two: 
*/
