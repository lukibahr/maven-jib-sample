package de.devopoly.uuid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
import java.util.*;
 
@RestController
public class UUIDController {
 
    private final static Logger logger = LoggerFactory.getLogger(UUIDController.class);

    @GetMapping(value="/uuid", produces=MediaType.APPLICATION_JSON_VALUE)
    public String sayUUID() {
        return generateUUID();
    }

    public String generateUUID() {
        final String uuid = UUID.randomUUID().toString();
        logger.info("Generated UUID: " + uuid);
        return uuid;
    }
}


