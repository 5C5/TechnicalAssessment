package domain;

import org.junit.jupiter.api.Test;

import static domain.Square.*;
import static java.util.List.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ChartedMapTest {

    private static final ChartedMap ONE_SQUARE_MAP = new ChartedMap(of(of(PATH)));

    @Test
    public void givenOneSquareMapWhenXIsGreaterThanBorderLimitThenReturnOutOfBound() {
        assertThat(ONE_SQUARE_MAP.findSquare(1, 0), is(OUT_OF_BOUND));
    }

    @Test
    public void givenOneSquareMapWhenXAndYAreInBordersLimitThenReturnSquare() {
        assertThat(ONE_SQUARE_MAP.findSquare(0, 0), is(PATH));
    }

    @Test
    public void givenOneSquareMapWhenXisSmallerThanBorderLimitThenReturnOutOfBound() {
        assertThat(ONE_SQUARE_MAP.findSquare(-1, 0), is(OUT_OF_BOUND));
    }

    @Test
    public void givenOneSquareMapWhenYisGreaterThanBorderLimitThenReturnOutOfBound() {
        assertThat(ONE_SQUARE_MAP.findSquare(0, 1), is(OUT_OF_BOUND));
    }

    @Test
    public void givenOneSquareMapWhenYisSmallerThanBorderLimitThenReturnOutOfBound() {
        assertThat(ONE_SQUARE_MAP.findSquare(0, -1), is(OUT_OF_BOUND));
    }

}