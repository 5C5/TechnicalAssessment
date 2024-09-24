import application.service.AdventureService;
import application.service.MapService;
import domain.Adventure;
import domain.ChartedMap;
import infrastructure.AdventureAdapter;
import infrastructure.FileOpener;
import infrastructure.MapAdapter;

public class AdventureApplication {


    public static void main(String[] args) {
        MapService mapService = initializationUsuallyDoneByDependencyInjectionFramework();
        String mapName = args.length > 0 ? args[0] : "";
        ChartedMap map = mapService.openMap(mapName);
        AdventureService adventureService = initializationAlsoUsuallyDoneByDependencyInjectionFramework();
        String adventureName = args.length > 1 ? args[1] : "";
        Adventure adventure = adventureService.chooseAdventure(adventureName);
        System.out.println(adventure.run(map));
    }

    private static AdventureService initializationAlsoUsuallyDoneByDependencyInjectionFramework() {
        return new AdventureService(new AdventureAdapter(new FileOpener(), "/adventures/defaultAdventure.txt"));
    }

    private static MapService initializationUsuallyDoneByDependencyInjectionFramework() {
        return new MapService(new MapAdapter(new FileOpener(), "/maps/carte_v2.txt"));
    }
}
