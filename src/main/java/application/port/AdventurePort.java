package application.port;

import domain.Adventure;

public interface AdventurePort {
    Adventure chooseAdventure(String adventureName);
}
