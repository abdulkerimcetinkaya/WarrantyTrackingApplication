package dev.kerim;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "Warranty Tracker", version = "1.0", description = "Warranty Tracker"))
public class WarrantyTrackingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarrantyTrackingApplication.class, args);
    }

}
