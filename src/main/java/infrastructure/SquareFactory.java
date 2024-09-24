package infrastructure;

import domain.Square;

import static domain.Square.FOREST;
import static domain.Square.PATH;

public class SquareFactory {

    private static final Character SPACE_CHARACTER = ' ';
    public static final Character HASH_CHARACTER = '#';

    public static Square buildSquare(char squareCharacter) {
        switch (squareCharacter) {
            case ' ' -> {
                return PATH;
            }
            case '#' -> {
                return FOREST;
            }
            default -> throw new UnexpectedSquare();
        }
    }
}
