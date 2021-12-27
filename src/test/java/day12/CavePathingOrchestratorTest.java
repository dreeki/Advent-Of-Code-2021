package day12;

import day12.cave.Cave;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CavePathingOrchestratorTest {

    @Test
    void processInput_StartAndEnd() {
        CavePathingOrchestrator cavePathingOrchestrator = new CavePathingOrchestrator();

        cavePathingOrchestrator.addInputLine("start-end");

        cavePathingOrchestrator.processInput();

        assertThat(cavePathingOrchestrator.getCavesByName())
                .hasSize(2)
                .containsOnlyKeys("start", "end");

        Cave start = cavePathingOrchestrator.getCavesByName().get("start");
        Cave end = cavePathingOrchestrator.getCavesByName().get("end");

        assertThat(start.getReachableCaves()).containsExactlyInAnyOrder(end);
        assertThat(end.getReachableCaves()).containsExactlyInAnyOrder(start);
    }

    @Test
    void processInput_3Caves() {
        CavePathingOrchestrator cavePathingOrchestrator = new CavePathingOrchestrator();

        cavePathingOrchestrator.addInputLine("start-end");
        cavePathingOrchestrator.addInputLine("start-a");
        cavePathingOrchestrator.addInputLine("end-a");

        cavePathingOrchestrator.processInput();

        assertThat(cavePathingOrchestrator.getCavesByName())
                .hasSize(3)
                .containsOnlyKeys("start", "a", "end");

        Cave start = cavePathingOrchestrator.getCavesByName().get("start");
        Cave a = cavePathingOrchestrator.getCavesByName().get("a");
        Cave end = cavePathingOrchestrator.getCavesByName().get("end");

        assertThat(start.getReachableCaves()).containsExactlyInAnyOrder(a, end);
        assertThat(a.getReachableCaves()).containsExactlyInAnyOrder(start, end);
        assertThat(end.getReachableCaves()).containsExactlyInAnyOrder(start, a);
    }

    @Test
    void processInput_ExampleInput() {
        CavePathingOrchestrator cavePathingOrchestrator = new CavePathingOrchestrator();

        cavePathingOrchestrator.addInputLine("start-A");
        cavePathingOrchestrator.addInputLine("start-b");
        cavePathingOrchestrator.addInputLine("A-c");
        cavePathingOrchestrator.addInputLine("A-b");
        cavePathingOrchestrator.addInputLine("b-d");
        cavePathingOrchestrator.addInputLine("A-end");
        cavePathingOrchestrator.addInputLine("b-end");

        cavePathingOrchestrator.processInput();

        assertThat(cavePathingOrchestrator.getCavesByName())
                .hasSize(6)
                .containsOnlyKeys("start", "A", "b", "c", "d", "end");

        Cave start = cavePathingOrchestrator.getCavesByName().get("start");
        Cave a = cavePathingOrchestrator.getCavesByName().get("A");
        Cave b = cavePathingOrchestrator.getCavesByName().get("b");
        Cave c = cavePathingOrchestrator.getCavesByName().get("c");
        Cave d = cavePathingOrchestrator.getCavesByName().get("d");
        Cave end = cavePathingOrchestrator.getCavesByName().get("end");

        assertThat(start.getReachableCaves()).containsExactlyInAnyOrder(a, b);
        assertThat(a.getReachableCaves()).containsExactlyInAnyOrder(start, b, c, end);
        assertThat(b.getReachableCaves()).containsExactlyInAnyOrder(start, a, d, end);
        assertThat(c.getReachableCaves()).containsExactlyInAnyOrder(a);
        assertThat(d.getReachableCaves()).containsExactlyInAnyOrder(b);
        assertThat(end.getReachableCaves()).containsExactlyInAnyOrder(a, b);
    }

    @Test
    void getAmountOfPathsToEnd_ExampleInput() {
        CavePathingOrchestrator cavePathingOrchestrator = new CavePathingOrchestrator();

        cavePathingOrchestrator.addInputLine("start-A");
        cavePathingOrchestrator.addInputLine("start-b");
        cavePathingOrchestrator.addInputLine("A-c");
        cavePathingOrchestrator.addInputLine("A-b");
        cavePathingOrchestrator.addInputLine("b-d");
        cavePathingOrchestrator.addInputLine("A-end");
        cavePathingOrchestrator.addInputLine("b-end");

        cavePathingOrchestrator.processInput();

        assertThat(cavePathingOrchestrator.getAmountOfPathsToEnd()).isEqualTo(10);
    }

    @Test
    void getAmountOfPathsToEndWithExtraTime_ExampleInput() {
        CavePathingOrchestrator cavePathingOrchestrator = new CavePathingOrchestrator();

        cavePathingOrchestrator.addInputLine("start-A");
        cavePathingOrchestrator.addInputLine("start-b");
        cavePathingOrchestrator.addInputLine("A-c");
        cavePathingOrchestrator.addInputLine("A-b");
        cavePathingOrchestrator.addInputLine("b-d");
        cavePathingOrchestrator.addInputLine("A-end");
        cavePathingOrchestrator.addInputLine("b-end");

        cavePathingOrchestrator.processInput();

        assertThat(cavePathingOrchestrator.getAmountOfPathsToEndWithExtraTime()).isEqualTo(36);
    }
}