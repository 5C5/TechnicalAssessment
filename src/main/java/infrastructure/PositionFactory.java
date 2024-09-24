package infrastructure;

import domain.Position;

import static java.lang.Integer.parseInt;

public class PositionFactory {
    public static Position findPosition(String position) {
        String[] coordinates = position.split(",");
        return new Position(parseInt(coordinates[0].trim()), parseInt(coordinates[1].trim()));
    }
}
