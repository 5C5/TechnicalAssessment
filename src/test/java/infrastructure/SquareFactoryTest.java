package infrastructure;

import org.junit.jupiter.api.Test;

import static domain.Square.FOREST;
import static domain.Square.PATH;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SquareFactoryTest {

    @Test
    public void givenSpaceCharacterReturnPathSquare() {
        assertThat(SquareFactory.buildSquare(' '), is(PATH));
    }

    @Test
    public void givenHashCharacterReturnForestSquare() {
        assertThat(SquareFactory.buildSquare('#'), is(FOREST));
    }

    @Test
    public void givenAnotherCharacterThenThrowUnexpectedSquare() {
        assertThrows(UnexpectedSquare.class, () -> SquareFactory.buildSquare('p'));
    }

}