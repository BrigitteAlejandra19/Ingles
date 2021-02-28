package com.company;

public class Word {

    private String inEnglish;
    private String inSpanish;
    private String sentence;

    public Word(String inEnglish, String inSpanish) {
        this.inEnglish = inEnglish;
        this.inSpanish = inSpanish;
    }

    public String getInEnglish() {
        return inEnglish;
    }

    public String getInSpanish() {
        return inSpanish;
    }

    public boolean isThisEnglishWordValid(String englishWord){
       return inEnglish!=null && inEnglish.equalsIgnoreCase(englishWord);
    }
    public boolean isThisSpanishWordValid(String spanihshWord){
        return inSpanish!=null && inSpanish.equalsIgnoreCase(spanihshWord);
    }
}
