package application.service;

import application.port.MapPort;
import domain.ChartedMap;

public class MapService {
    private final MapPort mapPort;

    public MapService(MapPort mapPort) {
        this.mapPort = mapPort;
    }

    public ChartedMap openMap(String mapName) {
        return mapPort.openMap(mapName);
    }
}
