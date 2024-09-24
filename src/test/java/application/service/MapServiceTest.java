package application.service;

import application.port.MapPort;
import domain.ChartedMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MapServiceTest {

    MapPort mapPort = Mockito.mock(MapPort.class);

    @BeforeEach
    public void setUp(){
        ChartedMap map = Mockito.mock(ChartedMap.class);
        when(mapPort.openMap(anyString())).thenReturn(map);
    }

    @Test
    public void givenMapNameThenReturnMap(){
        MapService mapService = new MapService(mapPort);
        assertNotNull(mapService.openMap("mapName"));
    }

    @Test
    public void givenMapNameThenCallMapPort(){
        MapService mapService = new MapService(mapPort);
        mapService.openMap("mapName");
        verify(mapPort).openMap("mapName");
    }
}