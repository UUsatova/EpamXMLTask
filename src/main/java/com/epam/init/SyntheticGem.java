package com.epam.init;

public class SyntheticGem extends Gem {

    private String manufacturer ;

    public SyntheticGem(){}

    public SyntheticGem(String id, Integer hallmark) {
        super(id, hallmark);
        
    }

    public SyntheticGem(String id,Integer hallmark ,String name,VisualParametrs visualParametrs,Float value,String manufacturer ){
        super(id, hallmark, name, visualParametrs, value);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    @Override
    public String toString() {
        StringBuilder gemString = new StringBuilder(super.toString());
        gemString.setLength(gemString.length() - 1);
        gemString.append("Manufacturer: ").append(getManufacturer()).append("\n}");
       return gemString.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return (super.equals(obj) && ((SyntheticGem)obj).manufacturer.equals(manufacturer));
    }

}
