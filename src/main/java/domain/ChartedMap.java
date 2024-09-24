package domain;

import java.util.List;
import java.util.Objects;

public class ChartedMap {

    private final List<List<Square>> squares;

    public ChartedMap(List<List<Square>> squares) {
        this.squares = squares;
    }

    public Square findSquare(int x, int y) {
        if (x < 0 || y < 0 || y > squares.size() - 1 || x > squares.get(y).size() - 1) {
            return Square.OUT_OF_BOUND;
        }
        return squares.get(y).get(x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChartedMap that = (ChartedMap) o;
        return Objects.equals(squares, that.squares);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(squares);
    }

}
