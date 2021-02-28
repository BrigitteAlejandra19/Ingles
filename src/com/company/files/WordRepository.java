package com.company.files;

import com.company.Word;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WordRepository {

    private static final String FILE_PATH = "/Users/keaguilar/workspace/brigitte/Ingles/src/com/company/files";
    private static final String FILE_FEBRUARY_ENGLISH = "february-english";
    private static final String FILE_FEBRUARY_SPANISH = "february-spanish";

    public static List<Word> loadWords() {

        Path fileEnglishPath = Paths.get(FILE_PATH, FILE_FEBRUARY_ENGLISH);
        Path fileSpanishPath = Paths.get(FILE_PATH, FILE_FEBRUARY_SPANISH);

        List<String> englishWords = new ArrayList<>();
        List<String> spanishWords = new ArrayList<>();

        loadWords(fileEnglishPath, englishWords);
        loadWords(fileSpanishPath, spanishWords);

        //Load the word list
        List<Word> words = new ArrayList<>();

        for (int i = 0; i < englishWords.size(); i++) {
            Word word = new Word(englishWords.get(i), spanishWords.get(i));
            words.add(word);
        }
        return words;
    }

    private static void loadWords(final Path filePath, final List<String> englishWords) {
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(line -> englishWords.add(line.trim()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
