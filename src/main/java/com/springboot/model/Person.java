package com.springboot.model;

import java.util.UUID;

public class Person {

    private final UUID uuid;

    private final String name;

    public Person(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
