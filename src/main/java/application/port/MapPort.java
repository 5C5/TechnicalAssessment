package application.port;

import domain.ChartedMap;

public interface MapPort {
    ChartedMap openMap(String mapName);
}
