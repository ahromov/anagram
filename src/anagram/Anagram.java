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
 * @author Andrii
 */
public class Anagram {

    private static final char EMPTY_SYMBOL = '\u0000';

    public void printRevertedString(String input) {
        System.out.println(createAnagramedWords(input));
    }

    public String createAnagramedWords(String words) {
        List<String> wordsList = splitWords(words);
        StringBuilder anagramedWords = new StringBuilder();
        wordsList.forEach((word) -> {
            anagramedWords.append(reverseWord(word)).append(" ");
        });
        return anagramedWords.toString();
    }

    private List<String> splitWords(String input) {
        return Arrays.asList(input.split(" "));
    }

    private String reverseWord(String word) {
        char[] reversedChars = getNonLetters(word);
        return putReverseLetters(reversedChars, word);
    }

    private char[] getNonLetters(String word) {
        char[] reversedChars = new char[word.length()];
        for (int j = 0; j < word.length(); j++) {
            int symbol = word.charAt(j);
            if (Character.isLetter(symbol)) {
                reversedChars[j] = EMPTY_SYMBOL;
            } else {
                reversedChars[j] = (char) symbol;
            }
        }
        return reversedChars;
    }

    private String putReverseLetters(char[] chars, String word) {
        char[] charsCopy = Arrays.copyOf(chars, chars.length);
        for (int j = 0; j < word.length(); j++) {
            int symbol = word.charAt(j);
            if (Character.isLetter(symbol)) {
                for (int k = charsCopy.length - 1; k >= 0; k--) {
                    if (isEmptySymbol(charsCopy[k])) {
                        charsCopy[k] = (char) symbol;
                        break;
                    }
                }
            }
        }
        return Arrays.toString(charsCopy);
    }

    private boolean isEmptySymbol(char symbol) {
        return symbol == EMPTY_SYMBOL;
    }
}