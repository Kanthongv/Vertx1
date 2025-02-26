package org.knt;

import org.knt.annotation.NoCoverageGenerated;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.json.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@NoCoverageGenerated
public class Starter {
    public static void main(String[] args) {
        System.out.println("Starting application");
        
        // Load properties file
        Properties props = new Properties();
        try (InputStream is = Starter.class.getClassLoader().getResourceAsStream("config.properties")) {
            props.load(is);
        } catch (IOException e) {
            System.err.println("Failed to load config.properties: " + e.getMessage());
            return;
        }

        // Create deployment options with properties
        DeploymentOptions options = new DeploymentOptions()
            .setConfig(new JsonObject()
                .put("http.port", Integer.parseInt(props.getProperty("http.port", "8080"))));
                
        io.vertx.core.Vertx.vertx().deployVerticle(new MainVerticle(), options);
    }
}
