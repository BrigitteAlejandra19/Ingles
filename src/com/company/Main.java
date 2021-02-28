package com.company;

import java.util.List;
import java.util.Scanner;

import static com.company.files.WordRepository.loadWords;

public class Main {

    public static void main(String[] args) {

        // write your code here
        List<Word> words = loadWords();

        // Spanish to English
        EnglishTest englishTest = new EnglishTest(words);
        englishTest.runSpanishToEnglishTest();
        englishTest.printResult();

        // English to Spanish
        //englishToSpanishTest(words);
    }
}
