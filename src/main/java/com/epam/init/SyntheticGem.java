package com.epam.init;

public class SyntheticGem extends Gem {

    private String manufacturer ;

    public SyntheticGem(String id, String name, VisualParametrs visualParametrs,String manufacturer) {
        super(id, name, visualParametrs);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    
}
