package com.lambdaschool.javaswapi;

import java.util.List;

public class Person {
    private String name;
    private List<String> species;

    public Person(String name, List<String> species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public List<String> getSpecies() {
        return species;
    }
}
