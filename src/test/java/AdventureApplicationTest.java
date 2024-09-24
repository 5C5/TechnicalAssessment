import application.service.AdventureService;
import application.service.MapService;
import domain.Adventure;
import domain.ChartedMap;
import domain.Position;
import infrastructure.AdventureAdapter;
import infrastructure.FileOpener;
import infrastructure.MapAdapter;
import infrastructure.UnreadableFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

class AdventureApplicationTest {

    public static final String MAP_NAME = "mapName";
    public static final String ADVENTURE_NAME = "adventureName";
    private FileOpener fileOpener = Mockito.mock(FileOpener.class);

    @BeforeEach
    public void setUp() throws UnreadableFile {
        when(fileOpener.readFile(MAP_NAME)).thenReturn(MAP);
    }


    @Test
    public void givenFirstAdventureThenFinalPositionIsNineTwo() throws UnreadableFile {
        when(fileOpener.readFile(ADVENTURE_NAME)).thenReturn(List.of("3,0", "SSSSEEEEEENN"));
        MapService mapService = new MapService(new MapAdapter(fileOpener, ""));
        AdventureService adventureService = new AdventureService(new AdventureAdapter(fileOpener, ""));
        ChartedMap chartedMap = mapService.openMap(MAP_NAME);
        Adventure adventure = adventureService.chooseAdventure(ADVENTURE_NAME);
        assertThat(adventure.run(chartedMap), is(new Position(9, 2)));
    }

    @Test
    public void givenSecondAdventureThenFinalPositionIsOneNine() throws UnreadableFile {
        when(fileOpener.readFile(ADVENTURE_NAME)).thenReturn(List.of("6,7", "OONOOOSSO"));
        MapService mapService = new MapService(new MapAdapter(fileOpener, ""));
        AdventureService adventureService = new AdventureService(new AdventureAdapter(fileOpener, ""));
        ChartedMap chartedMap = mapService.openMap(MAP_NAME);
        Adventure adventure = adventureService.chooseAdventure(ADVENTURE_NAME);
        assertThat(adventure.run(chartedMap), is(new Position(1, 9)));
    }

    private static final List<String> MAP = List.of("###    ######    ###",
            "###      ##      ###",
            "##     ##  ##     ##",
            "#      ##  ##      #",
            "##                ##",
            "#####          #####",
            "###### ##  ##  #####",
            " #     ######     # ",
            "     ########       ",
            "    ############    ",
            "    ############    ",
            "     ########      #",
            " #     ######     ##",
            "###### ##  ## ######",
            "#####          #####",
            "##                ##",
            "#   ## #    # ##   #",
            "##   ##      ##   ##",
            "###    #    #    ###",
            "###    ######    ###");

}