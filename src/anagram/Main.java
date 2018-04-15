/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Andrii Hromov
 */
public class Main {

    private static final char EMPTY_SYMBOL = '\u0000';
    private static int symbol;

    public static void main(String[] args) {
        if (args.length > 0) {
            printRevertedString(args[0]);
        } else {
            System.out.println("No argument(s)! USAGE: java Anagram \"Some line\"");
        }
    }

    public static void printRevertedString(String input) {
        System.out.println(createAnagramedString(input));
    }

    public static String createAnagramedString(String words) {
        List<String> wordsList = convertToWordsList(words);
        StringBuilder anagramedStringBuilder = new StringBuilder();
        for (int i = 0; i < wordsList.size(); i++) {
            anagramedStringBuilder.append(reverseWord(wordsList.get(i))).append(" ");
        }
        return anagramedStringBuilder.toString();
    }

    private static List<String> convertToWordsList(String input) {
        return Arrays.asList(input.split(" "));
    }

    private static String reverseWord(String word) {
        char[] reversedChars = new char[word.length()];
        reversedChars = putNonLetters(reversedChars, word);
        reversedChars = putReversedLetters(reversedChars, word);
        return Arrays.toString(reversedChars);
    }

    private static char[] putNonLetters(char[] chars, String word) {
        for (int j = 0; j < word.length(); j++) {
            symbol = word.charAt(j);
            if (Character.isLetter(symbol)) {
                chars[j] = EMPTY_SYMBOL;
            } else {
                chars[j] = (char) symbol;
            }
        }
        return chars;
    }

    private static char[] putReversedLetters(char[] chars, String word) {
        for (int j = 0; j < word.length(); j++) {
            symbol = word.charAt(j);
            if (Character.isLetter(symbol)) {
                for (int k = chars.length - 1; k >= 0; k--) {
                    if (isEmptySymbol(chars[k])) {
                        chars[k] = (char) symbol;
                        break;
                    }
                }
            }
        }
        return chars;
    }

    private static boolean isEmptySymbol(char symbol) {
        return symbol == EMPTY_SYMBOL;
    }

}
