package org.knt;

import java.util.Random;

import io.vertx.core.AbstractVerticle;

/**
 * This is the main verticle for the application.
 * It creates a HTTP server and listens on port 8080.
 * It also handles the deployment and undeployment of the verticle.
 */
public class MainVerticle extends AbstractVerticle {
    private static int PORT;

    /**
     * This method is called when the verticle is deployed.
     * It creates a HTTP server and listens on port 8080.
     */
    @Override
    public void start() {
        PORT = config().getInteger("http.port", 8080);
        
        // Start virtual threads
        startVirtualThreads();

        vertx.createHttpServer().requestHandler(req -> {
            final String response = "Hola desde Vert.x: " + new Random().nextInt(1000);
            System.out.println("Sending response: " + response);
            req.response().end(response);
        }).listen(PORT);
        System.out.println("Server started on port " + PORT);
    }

    // public void init() {
    //     System.out.println("Initializing verticle");

    //     // Deploy this instance as a verticle
    //     io.vertx.core.Vertx.vertx().deployVerticle(this);
    // }

    /**
     * Demonstrates the use of virtual threads by creating multiple
     * concurrent tasks that simulate work.
     */
    private void startVirtualThreads() {
        for (int i = 0; i < 100; i++) {
            //final int taskId = i;
            // Thread.startVirtualThread(() -> {
            //     try {
            //         System.out.printf("Virtual thread %d starting%n", taskId);
            //         Thread.sleep(1000); // Simulate some work
            //         System.out.printf("Virtual thread %d completed%n", taskId);
            //     } catch (InterruptedException e) {
            //         System.err.printf("Virtual thread %d interrupted%n", taskId);
            //     }
            // });
        }
    }

    /**
     * This method is called when the verticle is undeployed.
     */
    @Override
    public void stop() {
        System.out.println("Stopping verticle");
    }
}
