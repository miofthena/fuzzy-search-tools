package ru.fuzzysearch;

public abstract class WordIndex implements Index {

    private static final long serialVersionUID = 1L;
    private final String[] dictionary;

    protected WordIndex(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public String[] getDictionary() {
        return dictionary;
    }
}
