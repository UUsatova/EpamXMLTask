package com.epam.init;

public class SyntheticGem extends Gem {

    private String manufacturer ;

    public SyntheticGem(String id, Integer hallmark) {
        super(id, hallmark);
        
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
}
