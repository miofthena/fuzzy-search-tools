package ru.fuzzysearch;

import java.io.IOException;
import java.io.Reader;

public abstract class WordOnlineSearcher implements OnlineSearcher {

    /**
     * Читает посимвольно из reader'а.
     *
     * @param reader  поток чтения
     * @param visitor получает данные при считывании очередного слова.
     */
    protected void readText(Reader reader, Visitor visitor) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            int readerIndex = 0;

            int sym;
            while ((sym = reader.read()) >= 0) {
                char ch = (char) sym;
                if (Character.isLetterOrDigit(ch))
                    stringBuilder.append(Character.toUpperCase(ch));
                else if (stringBuilder.length() > 0) {
                    visitor.read(stringBuilder, readerIndex - stringBuilder.length());
                    stringBuilder.setLength(0);
                }
                ++readerIndex;
            }
            if (stringBuilder.length() > 0) visitor.read(stringBuilder, readerIndex - stringBuilder.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Посетитель для получения слов из потока чтения
     */
    protected interface Visitor {

        void read(CharSequence string, int index);
    }
}
