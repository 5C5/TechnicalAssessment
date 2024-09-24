package infrastructure;

import application.port.MapPort;
import domain.ChartedMap;

import java.util.List;

public class MapAdapter implements MapPort {
    private final FileOpener fileOpener;
    private final String defaultMap;

    public MapAdapter(FileOpener fileOpener, String defaultMap) {
        this.fileOpener = fileOpener;
        this.defaultMap = defaultMap;
    }

    @Override
    public ChartedMap openMap(String mapName) {
        List<String> mapContent;
        try {
            mapContent = fileOpener.readFile(mapName);
        } catch (UnreadableFile exception) {
            System.out.println("Using default map instead.");
            mapContent = fileOpener.readResource(defaultMap);
        }

        return ChartedMapFactory.makeMap(mapContent);
    }
}
