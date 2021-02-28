package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] englishWords = {"drizzled","shower","rain","pour"};
        String[] spanishhWords = {"llovizna","lluvia intermitente","lluvia","diluvio"};

        //Load the word list

        List<Word> words = new ArrayList<>();

        for (int i=0; i < englishWords.length; i++){
            Word word = new Word(englishWords[i], spanishhWords[i]);
            words.add(word);
        }

         // Spanish to English
        EnglishTest englishTest = new EnglishTest(words);
        for (int i=0; i < words.size(); i++){
            Word word = words.get(i);
            System.out.println(word.getInSpanish());
            System.out.println("Introduce la traduccion: ");
            Scanner sc = new Scanner(System.in);
            String englishWord = sc.nextLine();
            if(word.isThisEnglishWordValid(englishWord)) {
                englishTest.incrementCorrectWord();
            } else englishTest.incrementFailedWord();

            //System.out.println("La validacion fue: "+ word.isThisEnglishWordValid(englishWord));
        }
        System.out.println("Your english average is: " + englishTest.average());

        // English to Spanish
        for (int i=0; i < words.size(); i++){
            Word word = words.get(i);
            System.out.println(word.getInEnglish());
            System.out.println("Introduce la traduccion: ");
            Scanner sc = new Scanner(System.in);
            String spanishWord = sc.nextLine();
            System.out.println("La validacion fue: "+ word.isThisSpanishWordValid(spanishWord));
        }

    }
}
