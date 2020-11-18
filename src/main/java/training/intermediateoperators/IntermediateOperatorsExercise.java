package training.intermediateoperators;

import javax.print.DocFlavor;
import javax.sql.ConnectionPoolDataSource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperatorsExercise implements StreamIntermediateOperators {

    @Override
    public Stream<String> wordsLongerThanFiveCharacters(List<String> words) {
        return words.stream().filter(s -> s.length() > 5);
    }

    @Override
    public Stream<String> firstThreeWordsLongerThanFiveCharacters(List<String> words) {
        return words.stream().filter(s -> s.length() > 5).limit(3);
    }

    @Override
    public Stream<String> firstThreeDistinctWordsLongerThanFiveCharactersInReverseAlphabeticalOrder(List<String> words) {
        List<String> seen = new ArrayList<>();
        Stream<String> sortedStream = words.stream().filter(s -> {
            if (s.length() > 5 && !seen.contains(s)) {
                seen.add(s);
                return true;
            } else {
                return false;
            }
        }).limit(3).sorted(Collections.reverseOrder());
        return sortedStream;
    }

    @Override
    public Stream<Integer> lengthOfWords(List<String> words) {
        return words.stream().map(s -> s.length());
    }

    @Override
    public Stream<Integer> staircase() {
        List<Integer> staircase = IntStream.range(0, 6).flatMap(i -> IntStream.range(0, i+2)).boxed().collect(Collectors.toList());
        return staircase.stream();
    }
}
