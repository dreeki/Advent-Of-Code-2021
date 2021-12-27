package day1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DepthProcessorTest {

    @Test
    void calculateAmountOfIncreases() {
        DepthProcessor depthProcessor = aDepthProcessor();

        assertThat(depthProcessor.calculateAmountOfIncreases()).isEqualTo(7);
    }

    @Test
    void calculateAmountOfWindowIncreases() {
        DepthProcessor depthProcessor = aDepthProcessor();

        assertThat(depthProcessor.calculateAmountOfWindowIncreases()).isEqualTo(5);
    }

    private DepthProcessor aDepthProcessor() {
        DepthProcessor depthProcessor = new DepthProcessor();
        depthProcessor.addDepthNumber(199);
        depthProcessor.addDepthNumber(200);
        depthProcessor.addDepthNumber(208);
        depthProcessor.addDepthNumber(210);
        depthProcessor.addDepthNumber(200);
        depthProcessor.addDepthNumber(207);
        depthProcessor.addDepthNumber(240);
        depthProcessor.addDepthNumber(269);
        depthProcessor.addDepthNumber(260);
        depthProcessor.addDepthNumber(263);

        return depthProcessor;
    }
}