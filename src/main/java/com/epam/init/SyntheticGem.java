package com.epam.init;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SyntheticGem", propOrder = {"manufacturer"})
public class SyntheticGem extends Gem {

    @XmlElement (namespace="http://www.epam.com/gems", required = true)
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
