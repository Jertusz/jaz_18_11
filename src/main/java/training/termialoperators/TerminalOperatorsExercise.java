package training.termialoperators;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperatorsExercise implements StreamTerminalOperators {

    @Override
    public void addToSet(Stream<String> stream, Set<String> set) {
        set.addAll(stream.collect(Collectors.toList()));
    }

    @Override
    public void addToListInReverseOrder(Stream<String> stream, List<String> list) {
        List<String> streamList = stream.collect(Collectors.toList());
        Collections.reverse(streamList);
        list.addAll(streamList);
    }

    @Override
    public String[] collectToArray(Stream<String> stream) {
        return stream.toArray(String[]::new);
    }

    @Override
    public Set<String> collectToSet(Stream<String> stream) {
        return stream.collect(Collectors.toSet());
    }

    @Override
    public List<String> collectToList(Stream<String> stream) {
        return stream.collect(Collectors.toList());
    }

    @Override
    public String mergeIntoString(Stream<String> stream) {
        return stream.collect(Collectors.joining("-", "[", "]"));
    }

    @Override
    public int countCharacters(Stream<String> stream) {
        String res = stream.reduce("", (sub, add) -> sub + add);
        return res.length();
    }

    @Override
    public int longestWordLength(Stream<String> stream) {
        String res = stream.reduce("", (sub, add) -> {
            if (sub.length() >= add.length()) {
                return sub;
            } else {
                return add;
            }
        });
        return res.length();
    }

    @Override
    public String longestWord(Stream<String> stream) {
        return stream.reduce("", (sub, add) -> {
            if (sub.length() >= add.length()) {
                return sub;
            } else {
                return add;
            }
        });
    }

    @Override
    public Map<Integer, List<String>> wordsGroupedByLength(Stream<String> stream) {

        return stream.collect(Collectors.groupingBy(s -> s.length()));
    }
}
