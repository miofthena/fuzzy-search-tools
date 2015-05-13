package ru.fuzzysearch;

import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

public class MetricOnlineSearcher extends WordOnlineSearcher {

    private final Metric metric;
    private final boolean prefix;

    public MetricOnlineSearcher(Metric metric, boolean prefix) {
        this.metric = metric;
        this.prefix = prefix;
    }

    public Set<Integer> search(Reader reader, final String word, final int maxDistance) {
        final Set<Integer> result = new HashSet<>();

        Visitor visitor = (string, index) -> {
            if (metric.getDistance(string, word, maxDistance, prefix) <= maxDistance)
                result.add(index);
        };

        readText(reader, visitor);
        return result;
    }
}
