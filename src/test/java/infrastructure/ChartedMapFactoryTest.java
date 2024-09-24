package infrastructure;

import domain.ChartedMap;
import org.junit.jupiter.api.Test;

import static domain.Square.FOREST;
import static domain.Square.PATH;
import static java.util.Collections.emptyList;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChartedMapFactoryTest {

    @Test
    public void givenNoContentThenReturnEmptyMap() {
        assertEquals(new ChartedMap(emptyList()), ChartedMapFactory.makeMap(emptyList()));
    }

    @Test
    public void givenSpaceCharacterThenReturnMapWithPathSquare() {
        assertEquals(new ChartedMap(of(of(PATH))), ChartedMapFactory.makeMap(of(" ")));
    }

    @Test
    public void givenHashCharacterThenReturnMapWithForestSquare() {
        assertEquals(new ChartedMap(of(of(FOREST))), ChartedMapFactory.makeMap(of("#")));
    }

    @Test
    public void givenFullMapThenReturnMap() {
        assertEquals(new ChartedMap(of(of(FOREST, PATH), of(PATH, PATH), of(PATH, FOREST))), ChartedMapFactory.makeMap(of("# ", "  ", " #")));
    }

}