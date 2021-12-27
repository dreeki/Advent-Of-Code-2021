package day6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SimulationTest {

    @Test
    void doSimulationOf80Days() {
        Simulation simulation = new Simulation("3,4,3,1,2");

        assertThat(simulation.doSimulationOf80Days()).isEqualTo(5934);
    }

    @Test
    void doSimulationOf256Days() {
        Simulation simulation = new Simulation("3,4,3,1,2");

        assertThat(simulation.doSimulationOf256Days()).isEqualTo(26984457539L);
    }
}