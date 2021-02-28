package com.company;

public class Word {

    private String inEnglish;
    private String inSpanish;
    private String sentence = "";

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

    public String getSentence() {
        return sentence;
    }

    public void setSentence(final String sentence) {
        this.sentence = sentence;
    }

    public boolean isThisEnglishWordValid(String sentence) {
        return inEnglish != null && sentence != null && sentence.contains(inEnglish);
    }

    public boolean isThisSpanishWordValid(String spanihshWord) {
        return inSpanish != null && inSpanish.equalsIgnoreCase(spanihshWord);
    }

    public boolean isOkES() {
        return sentence.contains(inEnglish);
    }
}
