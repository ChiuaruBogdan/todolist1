package org.fasttrackit.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ObjectMapperConfiguration {

    private static ObjectMapper objectMapper = new ObjectMapper();

//    static block mai jos
    static {
        objectMapper.registerModule(new JavaTimeModule());

    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}

//aici am configurat ObjectMapper ca si static pentru a fi accessibil din restul applicatiei,
// fara sa fie nevoie sa il faci de fiecare data. In addition, statick blocks
