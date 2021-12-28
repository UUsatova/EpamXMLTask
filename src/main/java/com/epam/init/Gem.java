package com.epam.init;

public class Gem {
    private String id;
    private String name;
    private VisualParametrs visualParametrs ;

    public Gem(String id, String name, VisualParametrs visualParametrs) {
        this.id = id;
        this.name = name;
        this.visualParametrs = visualParametrs;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public VisualParametrs getVisualParametrs() {
        return visualParametrs;
    }
    
}
