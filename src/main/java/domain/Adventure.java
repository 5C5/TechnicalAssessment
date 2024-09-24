package domain;

import java.util.List;
import java.util.Objects;

public class Adventure {
    private final Position startingPosition;
    private final List<Move> moves;

    public Adventure(Position startingPosition, List<Move> moves) {
        this.startingPosition = startingPosition;
        this.moves = moves;
    }

    public Position run(ChartedMap map) {
        Position currentPosition = new Position(startingPosition.x(), startingPosition.y());
        for(Move move: moves) {
            Position nextPossiblePosition = currentPosition;
            switch (move) {
                case NORTH -> nextPossiblePosition = currentPosition.moveNorth();
                case WEST -> nextPossiblePosition = currentPosition.moveWest();
                case SOUTH -> nextPossiblePosition = currentPosition.moveSouth();
                case EAST -> nextPossiblePosition = currentPosition.moveEast();
            }
            if(map.findSquare(nextPossiblePosition.x(), nextPossiblePosition.y()).isCrossable()) {
                currentPosition = nextPossiblePosition;
            }
        }
        return currentPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adventure adventure = (Adventure) o;
        return Objects.equals(startingPosition, adventure.startingPosition) && Objects.equals(moves, adventure.moves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startingPosition, moves);
    }

}
