package day2;

import org.junit.jupiter.api.Test;

import static day2.Direction.DOWN;
import static day2.Direction.FORWARD;
import static day2.Direction.UP;
import static org.assertj.core.api.Assertions.assertThat;

class SubmarineTest {

    @Test
    void move_Forward() {
        Submarine submarine = new Submarine();

        submarine.move(FORWARD, 5);

        assertThat(submarine.getDepth()).isZero();
        assertThat(submarine.getHorizontal()).isEqualTo(5);
    }

    @Test
    void move_Down() {
        Submarine submarine = new Submarine();

        submarine.move(DOWN, 5);

        assertThat(submarine.getDepth()).isEqualTo(5);
        assertThat(submarine.getHorizontal()).isZero();
    }

    @Test
    void move_Up() {
        Submarine submarine = new Submarine();

        submarine.move(UP, 5);

        assertThat(submarine.getDepth()).isEqualTo(-5);
        assertThat(submarine.getHorizontal()).isZero();
    }

    @Test
    void getMultiplication_Example() {
        Submarine submarine = new Submarine();

        submarine.move(FORWARD, 5);
        submarine.move(DOWN, 5);
        submarine.move(FORWARD, 8);
        submarine.move(UP, 3);
        submarine.move(DOWN, 8);
        submarine.move(FORWARD, 2);

        assertThat(submarine.getMultiplication()).isEqualTo(150);
    }
}