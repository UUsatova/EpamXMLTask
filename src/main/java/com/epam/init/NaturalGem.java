package com.epam.init;

public class NaturalGem extends Gem {

    private String origin;

    public NaturalGem(String id, Integer hallmark) {
        super(id, hallmark);
        
    }

    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
}
