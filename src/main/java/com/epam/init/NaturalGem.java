package com.epam.init;

public class NaturalGem extends Gem {

    private String origin;

    public NaturalGem(String id, String name, VisualParametrs visualParametrs,String origin) {
        super(id, name, visualParametrs);
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }
    
}
