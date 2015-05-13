package ru.fuzzysearch;

import java.util.Set;

/**
 * Поиск с предварительным индексированием.
 */
public interface Searcher {

    /**
     * Метод выполняет поиск заданного слова word в словаре по предварительно сгенерированному индексу.
     *
     * @param word искомое слово
     * @return множество индексов слов в словаре, соответствующих критерию поиска
     */
    Set<Integer> search(String word);

    /**
     * Возвращает поисковый индекс, используемый при поиске.
     *
     * @return поисковый индекс {@link Index}
     */
    Index getIndex();
}
