package application.service;

import application.port.AdventurePort;
import domain.Adventure;
import domain.Position;
import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

class AdventureServiceTest {

    @Test
    public void whenChoosingAdventureThenCallAdventurePortWithAdventureName() {
        AdventurePort adventurePort = mock(AdventurePort.class);
        AdventureService adventureService = new AdventureService(adventurePort);
        String adventureName = "adventureName";
        when(adventurePort.chooseAdventure(adventureName)).thenReturn(new Adventure(new Position(0, 0), emptyList()));
        assertThat(adventureService.chooseAdventure(adventureName), is(not(nullValue())));
        verify(adventurePort).chooseAdventure(adventureName);
    }

}