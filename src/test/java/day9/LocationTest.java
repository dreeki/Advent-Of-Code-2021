package day9;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LocationTest {

    @Test
    void isMaxOneHigher_OneLower() {
        Location location = new Location(1, 1, 1);
        Location secondLocation = new Location(2, 1, 0);

        assertThat(location.isNotHigher(secondLocation)).isFalse();
    }

    @Test
    void isMaxOneHigher_SameHeight() {
        Location location = new Location(1, 1, 1);
        Location secondLocation = new Location(2, 1, 1);

        assertThat(location.isNotHigher(secondLocation)).isTrue();
    }

    @Test
    void isMaxOneHigher_OneHeigher() {
        Location location = new Location(1, 1, 1);
        Location secondLocation = new Location(2, 1, 2);

        assertThat(location.isNotHigher(secondLocation)).isTrue();
    }

    @Test
    void isMaxOneHigher_TwoHeigher() {
        Location location = new Location(1, 1, 1);
        Location secondLocation = new Location(2, 1, 3);

        assertThat(location.isNotHigher(secondLocation)).isTrue();
    }

    @Test
    void isMaxOneHigher_Height4() {
        Location location = new Location(1, 1, 1);
        Location secondLocation = new Location(2, 1, 4);

        assertThat(location.isNotHigher(secondLocation)).isTrue();
    }

    @Test
    void isMaxOneHigher_Height5() {
        Location location = new Location(1, 1, 1);
        Location secondLocation = new Location(2, 1, 5);

        assertThat(location.isNotHigher(secondLocation)).isTrue();
    }

    @Test
    void isMaxOneHigher_Height6() {
        Location location = new Location(1, 1, 1);
        Location secondLocation = new Location(2, 1, 6);

        assertThat(location.isNotHigher(secondLocation)).isTrue();
    }

    @Test
    void isMaxOneHigher_Height7() {
        Location location = new Location(1, 1, 1);
        Location secondLocation = new Location(2, 1, 7);

        assertThat(location.isNotHigher(secondLocation)).isTrue();
    }

    @Test
    void isMaxOneHigher_Height8() {
        Location location = new Location(1, 1, 1);
        Location secondLocation = new Location(2, 1, 8);

        assertThat(location.isNotHigher(secondLocation)).isTrue();
    }
}