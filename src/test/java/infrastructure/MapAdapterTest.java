package infrastructure;

import domain.ChartedMap;
import domain.Square;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.Square.FOREST;
import static domain.Square.PATH;
import static java.util.Arrays.asList;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MapAdapterTest {

    private static final String MAP_NAME = "mapName";
    private static final String DEFAULT_MAP_NAME = "/maps/carte_v2.txt";
    private final FileOpener fileOpener = mock(FileOpener.class);

    @Test
    public void givenMapNameThenCallMapReaderWithMapName() throws UnreadableFile {
        MapAdapter mapAdapter = new MapAdapter(fileOpener, DEFAULT_MAP_NAME);
        mapAdapter.openMap(MAP_NAME);
        verify(fileOpener).readFile(MAP_NAME);
    }

    @Test
    public void givenAnIssueWithTheMapFileThenCallMapReaderWithDefaultMap() throws UnreadableFile {
        when(fileOpener.readFile(MAP_NAME)).thenThrow(UnreadableFile.class);
        MapAdapter mapAdapter = new MapAdapter(fileOpener, DEFAULT_MAP_NAME);
        mapAdapter.openMap(MAP_NAME);
        verify(fileOpener).readResource(DEFAULT_MAP_NAME);
    }

    @Test
    public void givenMapNameWorkingThenReturnChartedMap() throws UnreadableFile {
        when(fileOpener.readFile(MAP_NAME)).thenReturn(asList("# #", "   ", "## "));
        MapAdapter mapAdapter = new MapAdapter(fileOpener, DEFAULT_MAP_NAME);
        ChartedMap chartedMap = mapAdapter.openMap(MAP_NAME);
        List<List<Square>> squares = of(of(FOREST, PATH, FOREST), of(PATH, PATH, PATH), of(FOREST, FOREST, PATH));
        assertEquals(new ChartedMap(squares), chartedMap);
    }
}