package ru.fuzzysearch;

/**
 * Компаратор для сортировки массивов притивного типа int с помощью IntArrays.sort(...)
 */
public interface IntComparator {

    int compare(int first, int second);
}
