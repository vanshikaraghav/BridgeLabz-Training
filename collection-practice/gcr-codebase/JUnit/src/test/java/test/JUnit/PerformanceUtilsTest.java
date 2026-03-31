package test.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformanceUtilsTest {

    PerformanceUtils utils = new PerformanceUtils();

    @Test
    @Timeout(2)
    void testTimeout() throws InterruptedException {
        utils.longRunningTask();
    }
}