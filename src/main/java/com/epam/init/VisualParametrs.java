package com.epam.init;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisualParametrs", propOrder = { "colour", "transparency" ,"typeOfCut"} )


public class VisualParametrs {


    @XmlElement (namespace="http://www.epam.com/gems", required = true)
    private String colour;
    @XmlElement (namespace="http://www.epam.com/gems", required = true)
    private Transparency transparency;
    @XmlElement (namespace="http://www.epam.com/gems", required = true)
    private Integer typeOfCut;

    public VisualParametrs(String colour,Transparency transparency,Integer typeOfCut){
        this.colour = colour;
        this.transparency = transparency;
        this.typeOfCut = typeOfCut;
    }

    public VisualParametrs(){
        
    }
    
    public String getColour() {
        return colour;
    }

    public Transparency getTransparency() {
        return transparency;
    }
    
    public Integer getTypeOfCut() {
        return typeOfCut;
    }


    public void setColour(String colour) {
        this.colour = colour;
    }

   
    public void setTransparency(Transparency transparency) {
        this.transparency = transparency;
    }

   
    public void setTypeOfCut(Integer typeOfCut) {
        this.typeOfCut = typeOfCut;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        VisualParametrs vParametrs = (VisualParametrs)obj;
        return (colour.equals(vParametrs.getColour()) &&
                transparency.equals(vParametrs.getTransparency()) &&
                typeOfCut.equals(vParametrs.getTypeOfCut()));
    }
    
@Override
public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
}

@Override
public int hashCode() {
    // TODO Auto-generated method stub
    return super.hashCode();
}

}
