package day7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SimulationTest {

    @Test
    void findCheapestPositionConsumptionLinear_ExampleInput() {
        Simulation simulation = new Simulation("16,1,2,0,4,2,7,1,2,14");

        assertThat(simulation.findCheapestPositionConsumptionLinear()).isEqualTo(37);
    }

    @Test
    void findCheapestPositionConsumptionIncreasing_ExampleInput() {
        Simulation simulation = new Simulation("16,1,2,0,4,2,7,1,2,14");

        assertThat(simulation.findCheapestPositionConsumptionIncreasing()).isEqualTo(168);
    }
}