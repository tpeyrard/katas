package com.github.tpeyrard.anagrams;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramFinder {

    private static final int NO_ANAGRAM = 1;

    public static List<List<Word>> find(URI wordList) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(wordList))) {
            return stream
                    .map(AnagramFinder::toWord)
                    .collect(Collectors.groupingBy(AnagramFinder::key))
                    .entrySet().stream()
                    .filter(possibleAnagrams -> possibleAnagrams.getValue().size() > NO_ANAGRAM)
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
        }

    }

    private static Word toWord(String word) {
        return new Word(word);
    }

    public static String key(Word word) {
        return sort(word.word);
    }

    private static String sort(String w) {
        char[] array = w.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public static final class Word {
        private final String word;

        public Word(String word) {
            this.word = word;
        }

        @Override
        public String toString() {
            return word;
        }
    }
}
