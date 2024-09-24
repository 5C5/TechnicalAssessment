package infrastructure;

import domain.Adventure;
import domain.Position;
import org.junit.jupiter.api.Test;

import static domain.Move.*;
import static java.util.List.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class AdventureAdapterTest {

    private static final String ADVENTURE_NAME = "adventureName";
    private final FileOpener fileOpener = mock(FileOpener.class);
    private static final String DEFAULT_ADVENTURE_NAME = "defaultAdventureName";

    @Test
    public void givenAdventureNameWhenChoosingAdventureThenCallFileOpenerWithAdventureName() throws UnreadableFile {
        AdventureAdapter adventureAdapter = new AdventureAdapter(fileOpener, DEFAULT_ADVENTURE_NAME);
        when(fileOpener.readFile(ADVENTURE_NAME)).thenReturn(of("3, 1", "NEN"));
        adventureAdapter.chooseAdventure(ADVENTURE_NAME);
        verify(fileOpener).readFile(ADVENTURE_NAME);
    }

    @Test
    public void givenIssueWithAdventureThenCallFileOpenerWithDefaultAdventure() throws UnreadableFile {
        when(fileOpener.readFile(ADVENTURE_NAME)).thenThrow(UnreadableFile.class);
        when(fileOpener.readResource(DEFAULT_ADVENTURE_NAME)).thenReturn(of("3, 1", "NEN"));
        AdventureAdapter adventureAdapter = new AdventureAdapter(fileOpener, DEFAULT_ADVENTURE_NAME);
        adventureAdapter.chooseAdventure(ADVENTURE_NAME);
        verify(fileOpener).readResource(DEFAULT_ADVENTURE_NAME);
    }

    @Test
    public void givenAdventureNameThenReturnAdventure() throws UnreadableFile {
        when(fileOpener.readFile(ADVENTURE_NAME)).thenReturn(of("0, 0", "SOS"));
        AdventureAdapter adventureAdapter = new AdventureAdapter(fileOpener, DEFAULT_ADVENTURE_NAME);
        assertThat(adventureAdapter.chooseAdventure(ADVENTURE_NAME), is(new Adventure(new Position(0, 0),
                of(SOUTH, WEST, SOUTH))));
    }

    @Test
    public void givenIssueWithAdventureNameThenReturnDefaultAdventure() throws UnreadableFile {
        when(fileOpener.readFile(ADVENTURE_NAME)).thenThrow(UnreadableFile.class);
        when(fileOpener.readResource(DEFAULT_ADVENTURE_NAME)).thenReturn(of("3, 1", "NEN"));
        AdventureAdapter adventureAdapter = new AdventureAdapter(fileOpener, DEFAULT_ADVENTURE_NAME);
        assertThat(adventureAdapter.chooseAdventure(ADVENTURE_NAME), is(new Adventure(new Position(3, 1),
                of(NORTH, EAST, NORTH))));
    }

}