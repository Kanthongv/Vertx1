package org.knt;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

@Disabled("This test is disabled because it is not needed")
class MainDiffblueTest {
    static MainVerticle verticle = new MainVerticle();

    @BeforeAll
    static void init() {
        // Deploy the verticle
        io.vertx.core.Vertx.vertx().deployVerticle(verticle);
    }

    /**
     * Test {@link MainVerticle#start()}.
     * <p>
     * Method under test: {@link MainVerticle#start()}
     */
    @Test
    @DisplayName("Test start()")
    void testStart() {
        verticle.start();
        //fail("test should have been aborted");
    }

    /**
     * Test {@link MainVerticle#stop()}.
     * <p>
     * Method under test: {@link MainVerticle#stop()}
     */
    @Test
    @DisplayName("Test stop()")
    void testStop() {
        verticle.stop();
    }
}
