package com.company;

import java.util.ArrayList;
import java.util.List;

public class EnglishTest {
    List<Word> words = new ArrayList<>();
    int correctWordNumber = 0;
    int failedWordNumber = 0;

    public EnglishTest(List<Word> words) {
        this.words = words;
    }



    public Integer average(){
       if(words.size()==0) return 0;

        return correctWordNumber*100/words.size() ;
    }

    void incrementCorrectWord() {
        correctWordNumber++;
    }

    void incrementFailedWord() {
        failedWordNumber++;
    }
}
