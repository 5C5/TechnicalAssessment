package infrastructure;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class FileOpenerTest {

    @Test
    public void givenFileNameWithRelativePathThenLoadFile() {
        FileOpener fileOpener = new FileOpener();
        assertThat(fileOpener.readResource("/maps/carte_v2.txt"), is(not(empty())));
    }

}