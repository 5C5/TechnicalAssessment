package infrastructure;

import domain.Move;

import java.util.List;

import static domain.Move.*;
import static java.util.stream.Collectors.toList;

public class MoveFactory {
    public static List<Move> findMoves(String moves) {
        return moves.chars().mapToObj(move -> (char) move).map(MoveFactory::apply).collect(toList());
    }

    private static Move apply(Character move) {
        switch (move) {
            case 'N' -> {
                return NORTH;
            }
            case 'O' -> {
                return WEST;
            }
            case 'S' -> {
                return SOUTH;
            }
            case 'E' -> {
                return EAST;
            }
            default -> throw new IllegalStateException("Unexpected value: " + move);
        }
    }
}
