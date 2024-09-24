package infrastructure;

import domain.Position;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PositionFactoryTest {

    @Test
    public void givenZeroZeroPositionThenReturnPositionAtZeroZero() {
        assertThat(PositionFactory.findPosition("0, 0"), is(new Position(0, 0)));
    }

    @Test
    public void givenOneThreePositionThenReturnPositionAtOneThree() {
        assertThat(PositionFactory.findPosition("1, 3"), is(new Position(1, 3)));
    }
}