package domain;

import org.junit.jupiter.api.Test;

import static domain.Move.*;
import static domain.Square.PATH;
import static java.util.Collections.singletonList;
import static java.util.List.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AdventureTest {

    private static final ChartedMap PATH_ONLY = new ChartedMap(of(of(PATH, PATH, PATH), of(PATH, PATH, PATH),
            of(PATH, PATH, PATH)));

    @Test
    public void givenOnlyPathWhenMovingNorthThenFinalPositionIsYMinusOne() {
        Adventure adventure = new Adventure(new Position(1, 1), singletonList(NORTH));
        assertThat(adventure.run(PATH_ONLY), is(new Position(1, 0)));
    }

    @Test
    public void givenOnlyPathWhenMovingWestThenFinalPositionIsXMinusOne() {
        Adventure adventure = new Adventure(new Position(1, 1), singletonList(WEST));
        assertThat(adventure.run(PATH_ONLY), is(new Position(0, 1)));
    }

    @Test
    public void givenOnlyPathWhenMovingSouthThenFinalPositionIsYPlusOne() {
        Adventure adventure = new Adventure(new Position(1, 1), singletonList(SOUTH));
        assertThat(adventure.run(PATH_ONLY), is(new Position(1, 2)));
    }

    @Test
    public void givenOnlyPathWhenMovingNorthThenFinalPositionIsXPlusOne() {
        Adventure adventure = new Adventure(new Position(1, 1), singletonList(EAST));
        assertThat(adventure.run(PATH_ONLY), is(new Position(2, 1)));
    }

    @Test
    public void givenBorderPositionWhenMovingNorthThenDoNotMove() {
        Adventure adventure = new Adventure(new Position(1, 0), singletonList(NORTH));
        assertThat(adventure.run(PATH_ONLY), is(new Position(1, 0)));
    }

    @Test
    public void givenBorderPositionWhenMovingWestThenThrowImpossibleMovement() {
        Adventure adventure = new Adventure(new Position(1, 1), singletonList(WEST));
        assertThat(adventure.run(PATH_ONLY), is(new Position(0, 1)));
    }

    @Test
    public void givenBorderPositionWhenMovingSouthThenThrowImpossibleMovement() {
        Adventure adventure = new Adventure(new Position(1, 1), singletonList(SOUTH));
        assertThat(adventure.run(PATH_ONLY), is(new Position(1, 2)));
    }

    @Test
    public void givenBorderPositionWhenMovingEastThenThrowImpossibleMovement() {
        Adventure adventure = new Adventure(new Position(1, 1), singletonList(EAST));
        assertThat(adventure.run(PATH_ONLY), is(new Position(2, 1)));
    }

}