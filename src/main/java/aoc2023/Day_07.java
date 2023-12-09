package aoc2023;

import java.util.ArrayList;
import java.util.Scanner;
//import java.util.concurrent.atomic.AtomicLong;
import java.util.Collections;
//import java.util.stream.LongStream;

//import java.time.Instant;
import java.util.Comparator;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;

/**
 * Day_07
 * https://adventofcode.com/2023/day/7
 */
public class Day_07 {

    static public String inputFile = "/input_07.txt";

    public ArrayList<String> getInputData(String fileName) {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_07.class.getResourceAsStream(fileName));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            inp.add(line);
        }
        inputScanner.close();
        return inp;
    }

    public int day07PartOne(ArrayList<String> decks) {
        int sum = 0;

        List<HandBid> handList = new ArrayList<>();

        for (String h : decks) {
            String[] spl = h.split("\\s+");
            String hs = spl[0];
            int bid = Integer.parseInt(spl[1]);

            CamelCardsHand hand = new CamelCardsHand(hs);
            int handType = hand.determineHandType();
            long val = hand.determineHandValue();
            System.out.println(hs + ": " + handType);
            int veight = (int) Math.pow(16, 6) * handType;
            handList.add(new HandBid(hand, bid, val + veight));

        }

        // sort handList by bid
        handList.sort(Comparator.comparingLong(hb -> hb.score));
        // pint out handList
        int i = 1;
        for (HandBid hb : handList) {
            System.out.println(hb.hand.toString() + " : " + hb.bid + ": " + hb.hand.determineHandType() + " : "
                    + hb.score + " : " + i);
            sum = sum + hb.bid * i;
            i++;
        }

        return sum;
    }

    public int day07PartTwo(ArrayList<String> decks) {
        int sum = 0;

        List<HandBid> handList = new ArrayList<>();

        for (String h : decks) {
            String[] spl = h.split("\\s+");
            String hs = spl[0];
            System.out.println(hs);
            int bid = Integer.parseInt(spl[1]);

            CamelCardsHand hand = new CamelCardsHand(hs);
            int handType = hand.determineHandTypeJ();
            long val = hand.determineHandValueJ();
            System.out.println(hs + ": " + handType);
            int veight = (int) Math.pow(16, 6) * handType;
            handList.add(new HandBid(hand, bid, val + veight));

        }

        // sort handList by bid
        handList.sort(Comparator.comparingLong(hb -> hb.score));
        // pint out handList
        int i = 1;
        for (HandBid hb : handList) {
            System.out.println(hb.hand.toString() + " : " + hb.bid + ": " + hb.hand.determineHandTypeJ() + " : "
                    + hb.score + " : " + i);
            sum = sum + hb.bid * i;
            i++;
        }

        return sum;
    }

    public class CamelCardsHand {
        private char card1;
        private char card2;
        private char card3;
        private char card4;
        private char card5;

        public CamelCardsHand(String input) {
            if (input.length() != 5) {
                throw new IllegalArgumentException("Input string must have exactly 5 characters.");
            }
            this.card1 = input.charAt(0);
            this.card2 = input.charAt(1);
            this.card3 = input.charAt(2);
            this.card4 = input.charAt(3);
            this.card5 = input.charAt(4);
        }

        // Getters and setters for each card

        public char getCard1() {
            return card1;
        }

        public void setCard1(char card1) {
            this.card1 = card1;
        }

        public char getCard2() {
            return card2;
        }

        public void setCard2(char card2) {
            this.card2 = card2;
        }

        public char getCard3() {
            return card3;
        }

        public void setCard3(char card3) {
            this.card3 = card3;
        }

        public char getCard4() {
            return card4;
        }

        public void setCard4(char card4) {
            this.card4 = card4;
        }

        public char getCard5() {
            return card5;
        }

        public void setCard5(char card5) {
            this.card5 = card5;
        }

        public String toString() {
            return String.format("%c%c%c%c%c", card1, card2, card3, card4, card5);
        }

        public int determineHandType() {
            Set<Character> uniqueLabels = new HashSet<>();
            Map<Character, Integer> labelCounts = new HashMap<>();

            // Count the occurrences of each label and store them in a map
            for (char card : new char[] { card1, card2, card3, card4, card5 }) {
                labelCounts.put(card, labelCounts.getOrDefault(card, 0) + 1);
                uniqueLabels.add(card);
            }

            int distinctLabels = uniqueLabels.size();
            int maxLabelCount = Collections.max(labelCounts.values());

            if (distinctLabels == 1) {
                return 7;
                // return "Five of a kind";
            } else if (distinctLabels == 2) {
                if (maxLabelCount == 4) {
                    // 6
                    // return "Four of a kind";
                    return 6;
                } else if (maxLabelCount == 3) {
                    // 5
                    // return "Full house";
                    return 5;
                }
            } else if (distinctLabels == 3) {
                if (maxLabelCount == 3) {
                    // 4
                    // return "Three of a kind";
                    return 4;
                } else if (maxLabelCount == 2) {
                    // 3
                    // return "Two pair";
                    return 3;
                }
            } else if (distinctLabels == 4 && maxLabelCount == 2) {
                // 2
                // return "One pair";
                return 2;
            }
            // 1
            // return "High card";
            return 1;

        }

        public long determineHandValue() {
            // loop through all cards
            double value = 0;
            int i = 5;
            for (char card : new char[] { card1, card2, card3, card4, card5 }) {
                int v = 0;

                switch (card) {
                    case 'A':
                        v = 14;
                        break;
                    case 'K':
                        v = 13;
                        break;
                    case 'Q':
                        v = 12;
                        break;
                    case 'J':
                        v = 11;
                        break;
                    case 'T':
                        v = 10;
                        break;
                    default:
                        v = Character.getNumericValue(card);
                }
                System.out.println(card);
                System.out.println("v:" + v);

                value += Math.pow(16, i) * v;
                i--;
            }
            return (long) value;
        }

        public int determineHandTypeJ() {
            Set<Character> uniqueLabels = new HashSet<>();
            Map<Character, Integer> labelCounts = new HashMap<>();

            int jokers = 0;
            // Count the occurrences of each label and store them in a map
            for (char card : new char[] { card1, card2, card3, card4, card5 }) {
                if (card == 'J') {
                    jokers++;
                    continue;
                }
                labelCounts.put(card, labelCounts.getOrDefault(card, 0) + 1);
                uniqueLabels.add(card);
            }

            int distinctLabels = uniqueLabels.size();
            int maxLabelCount = Collections.max(labelCounts.values());

            int handType = 0;
            if (distinctLabels == 1) {
                handType = 7;
                // return "Five of a kind";
            } else if (distinctLabels == 2) {
                if (maxLabelCount == 4) {
                    // 6
                    // return "Four of a kind";
                    handType = 6;
                } else if (maxLabelCount == 3) {
                    // 5
                    // return "Full house";
                    handType = 5;
                } else if (maxLabelCount == 2){

                    handType = 2;

                }else{
                    handType = 1;
                }

            } else if (distinctLabels == 3) {
                if (maxLabelCount == 3) {
                    // 4
                    // return "Three of a kind";
                    handType = 4;
                } else if (maxLabelCount == 2) {
                    // 3
                    // return "Two pair";
                    handType = 3;
                } else {
                    handType = 1;
                }

            } else if (distinctLabels == 4 && maxLabelCount == 2) {
                // 2
                // return "One pair";
                handType = 2;
            } else {// 1
                // return "High card";
                handType = 1;
            }

            /* *****************************/

            // Handle J as a wild card

            if (handType == 1) { // High card
                if (jokers == 1) {
                    handType = 2;
                } else if (jokers == 2) {
                    handType = 4;
                } else if (jokers == 3) {
                    handType = 6;
                } else if (jokers == 4) {
                    handType = 7;
                } else if (jokers == 5) {
                    handType = 7;
                }
            } else if (handType == 2) { // One pair
                if (jokers == 1) {
                    handType = 4;
                } else if (jokers == 2) {
                    handType = 6;
                } else if (jokers == 3) {
                    handType = 7;
                }
            } else if (handType == 3) { // Two pair
                if (jokers == 1) {
                    handType = 5;
                }
            } else if (handType == 4) { // Three of a kind
                if (jokers == 1) {
                    handType = 6;
                } else if (jokers == 2) {
                    handType = 7;
                }
            } else if (handType == 6) { // Four of a kind
                if (jokers == 1) {
                    handType = 7;
                }

            }
            return handType;
            /* *****************************/

        }

        public long determineHandValueJ() {
            // loop through all cards
            double value = 0;
            int i = 5;
            for (char card : new char[] { card1, card2, card3, card4, card5 }) {
                int v = 0;

                switch (card) {
                    case 'A':
                        v = 14;
                        break;
                    case 'K':
                        v = 13;
                        break;
                    case 'Q':
                        v = 12;
                        break;
                    case 'J':
                        v = 1;
                        break;
                    case 'T':
                        v = 10;
                        break;
                    default:
                        v = Character.getNumericValue(card);
                }
                System.out.println(card);
                System.out.println("v:" + v);

                value += Math.pow(16, i) * v;
                i--;
            }
            return (long) value;
        }
    }

    public class HandBid {
        public CamelCardsHand hand;
        public int bid;
        public long score;

        public HandBid(CamelCardsHand hand, int bid, long score) {
            this.hand = hand;
            this.bid = bid;
            this.score = score;
        }
    }

    public static void main(String[] args) {

        System.out.println("Advent of code 2023, Day 07\n");
        Day_07 day_07 = new Day_07();
        long answer1;
        long answer2;

        ArrayList<String> inp = day_07.getInputData(inputFile);
        answer1 = day_07.day07PartOne(inp);

        System.out.println("Solution Part one: " + answer1);
        answer2 = day_07.day07PartTwo(inp);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
 * Advent of code 2023, Day 07
 * 
 * Solution Part one:
 * Solution Part two:
 * 
 */
