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

    public static void main(String[] args) {
        if (args.length > 0) {
            printRevertedString(args[0]);
        } else {
            System.out.println("No argument! USAGE: java Anagram \"Some line\"");
        }
    }

    public static void printRevertedString(String input) {
        System.out.println(createAnagramedString(getListFromWordArray(input)));
    }

    private static List<String> getListFromWordArray(String input) {
        List<String> wordsList = Arrays.asList(input.split(" "));
        return wordsList;
    }

    public static String createAnagramedString(List<String> words) {
        StringBuilder newLineBuffer = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            reverseEachWord(word);
            newLineBuffer.append(reverseEachWord(word)).append(" ");
        }
        return newLineBuffer.toString();
    }

    private static String reverseEachWord(String word) {
        int charIndex = 0;
        char[] arrayForNewReverseWord = parseWordOnChars(word);
        for (int j = 0; j < word.length(); j++) {
            charIndex = word.charAt(j);
            if (Character.isLetter(charIndex)) {
                for (int k = arrayForNewReverseWord.length - 1; k >= 0; k--) {
                    if (arrayForNewReverseWord[k] == '\u0000') {
                        arrayForNewReverseWord[k] = (char) charIndex;
                        break;
                    }
                }
            }
        }
        return Arrays.toString(arrayForNewReverseWord);
    }

    private static char[] parseWordOnChars(String word) {
        int charIndex = 0;
        char[] parsedOnCharsWord = new char[word.length()];
        for (int j = 0; j < word.length(); j++) {
            charIndex = word.charAt(j);
            if (Character.isLetter(charIndex)) {
                parsedOnCharsWord[j] = '\u0000';
            } else {
                parsedOnCharsWord[j] = (char) charIndex;
            }
        }
        return parsedOnCharsWord;
    }

}
