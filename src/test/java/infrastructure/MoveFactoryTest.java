package infrastructure;

import org.junit.jupiter.api.Test;

import static domain.Move.*;
import static java.util.Collections.singletonList;
import static java.util.List.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MoveFactoryTest {

    @Test
    public void givenNCharacterThenReturnNorth() {
        assertThat(MoveFactory.findMoves("N"), is(singletonList(NORTH)));
    }

    @Test
    public void givenOCharacterThenReturnWest() {
        assertThat(MoveFactory.findMoves("O"), is(singletonList(WEST)));
    }

    @Test
    public void givenSCharacterThenReturnSouth() {
        assertThat(MoveFactory.findMoves("S"), is(singletonList(SOUTH)));
    }

    @Test
    public void givenECharacterThenReturnEast() {
        assertThat(MoveFactory.findMoves("E"), is(singletonList(EAST)));
    }

    @Test
    public void givenMultipleCharactersThenReturnMoves() {
        assertThat(MoveFactory.findMoves("NOSE"), is(of(NORTH, WEST, SOUTH, EAST)));
    }

}