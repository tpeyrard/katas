package com.github.tpeyrard.anagrams;

import com.github.tpeyrard.anagrams.AnagramFinder.Word;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.util.IntSummaryStatistics;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class AnagramFinderTest {

    @Test
    public void
    it_finds_all_anagrams() throws IOException {
        List<List<Word>> anagrams = AnagramFinder.find(fileFromResources("wordlist.txt"));

        assertAnagrams(anagrams, 20683, 48162);
    }

    @Test
    public void
    it_finds_anagrams_for_door() throws IOException {
        List<List<Word>> anagrams = AnagramFinder.find(fileFromResources("door.txt"));

        assertAnagrams(anagrams, 1, 3);
    }

    @Test
    public void
    it_finds_anagrams_among_other_words() throws IOException {
        List<List<Word>> anagrams = AnagramFinder.find(fileFromResources("all.txt"));

        assertAnagrams(anagrams, 3, 7);
    }

    private void assertAnagrams(List<List<Word>> anagrams, int expectedNumberOfSets, int expectedNumberOfWords) {
        IntSummaryStatistics intSummaryStatistics = anagrams.stream().mapToInt(List::size).summaryStatistics();
        long numberOfSetsOfAnagrams = intSummaryStatistics.getCount();
        assertThat(numberOfSetsOfAnagrams).isEqualTo((long) expectedNumberOfSets);
        long numberOfWords = intSummaryStatistics.getSum();
        assertThat(numberOfWords).isEqualTo((long) expectedNumberOfWords);
    }

    private static URI fileFromResources(String fileName) {
        try {
            return AnagramFinderTest.class.getClassLoader().getResource(fileName).toURI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}