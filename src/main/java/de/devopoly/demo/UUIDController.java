package de.devopoly.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
 
@RestController
public class UUIDController {
 
    private final static Logger logger = LoggerFactory.getLogger(UUIDController.class);

    @GetMapping("/generate")
    public String sayUUID() {
        return generateUUID();
    }

    public String generateUUID() {
        final String uuid = UUID.randomUUID().toString();
        logger.info("Generated UUID: " + uuid);
        return uuid;
    }
}


