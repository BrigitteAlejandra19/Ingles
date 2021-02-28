package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnglishTest {
    List<Word> words = new ArrayList<>();
    List<Word> correctWord = new ArrayList<>();
    List<Word> invalidWord = new ArrayList<>();

    public EnglishTest(List<Word> words) {
        this.words = words;
    }

    public Integer average() {
        if (words.size() == 0) {
            return 0;
        }

        return correctWord.size() * 100 / words.size();
    }

    public void runSpanishToEnglishTest() {
        System.out.println("**************************************************************************************");
        System.out.println("**  Welcome to this test. Now we go to translate to Spanish words to English word   **");
        System.out.println("**   - You will see to spanish word.                                                **");
        System.out.println("**   - Then you should complete a sentence with the correct word in english.        **");
        System.out.println("**************************************************************************************");
        System.out.println(" ");
        for (int i = 0; i < words.size(); i++) {
            Word word = words.get(i);
            System.out.print(word.getInSpanish() + ": ");
            Scanner sc = new Scanner(System.in);
            String sentence = sc.nextLine();
            word.setSentence(sentence);
            if (word.isThisEnglishWordValid(sentence)) {
                addCorrectWord(word);
            } else {
                addFailedWord(word);
            }

            //System.out.println("La validacion fue: "+ word.isThisEnglishWordValid(englishWord));
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void printResult() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.print("Press enter to continue");
        System.out.println(" ");
        System.out.println(" ");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        clearScreen();
        System.out.println("***********************************");
        System.out.println("*********  Test Result   **********");
        System.out.println("***********************************");
        System.out.println(" ");
        System.out.println("***********************************");
        System.out.println(" ");
        System.out.println("You have '" + correctWord.size() + "' correct words: ");
        System.err.println("You have '" + invalidWord.size() + "' invalid words: ");
        System.out.println(" ");
        words.forEach(word -> {
            String base = " " + word.getInEnglish() + " (" + word.getInSpanish() + ") ";
            String yourSentence =    "- Your sentence was: '" + word.getSentence()  + "'";
            if(word.isOkES()) {
                System.out.printf("%-45s %s\n", base, yourSentence);
            } else {
                System.err.printf("%-45s %s\n", base, yourSentence);
            }
        });
        System.out.println(" ");
        System.out.println("***********************************");
        System.out.println(" ");
        System.out.println("***********************************");
        System.out.println("Your english average is (" + correctWord.size() + "*100/" + words.size() + ") : " + average());
    }

    void addCorrectWord(Word word) {
        correctWord.add(word);
    }

    void addFailedWord(Word word) {
        invalidWord.add(word);
    }
}
