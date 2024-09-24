package infrastructure;

import domain.ChartedMap;
import domain.Square;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class ChartedMapFactory {
    public static ChartedMap makeMap(List<String> mapContent) {
        if (mapContent.isEmpty()) {
            return new ChartedMap(emptyList());
        }
        List<List<Square>> squares = mapContent.stream().map(ChartedMapFactory::apply).toList();
        return new ChartedMap(squares);
    }

    private static List<Square> apply(String mapLine) {
        return mapLine.chars().mapToObj(character -> (char) character).map(SquareFactory::buildSquare).collect(toList());
    }
}
