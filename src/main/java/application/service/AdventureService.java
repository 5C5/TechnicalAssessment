package application.service;

import application.port.AdventurePort;
import domain.Adventure;

public class AdventureService {
    private final AdventurePort adventurePort;

    public AdventureService(AdventurePort adventurePort) {
        this.adventurePort = adventurePort;
    }

    public Adventure chooseAdventure(String adventureName) {
        return adventurePort.chooseAdventure(adventureName);
    }
}
