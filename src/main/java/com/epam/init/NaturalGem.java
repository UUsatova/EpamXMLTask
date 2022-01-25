package com.epam.init;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaturalGem", propOrder = {"origin"})
public class NaturalGem extends Gem {

    @XmlElement (namespace="http://www.epam.com/gems",required = true)
    private String origin;

    public NaturalGem(){}

    public NaturalGem(String id, Integer hallmark) {
        super(id, hallmark);
        
    }

    public NaturalGem(String id,Integer hallmark ,String name,VisualParametrs visualParametrs,Float value,String origin){
        super(id, hallmark, name, visualParametrs, value);
        this.origin = origin;
    }


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        StringBuilder gemString = new StringBuilder(super.toString());
        gemString.setLength(gemString.length() - 1);
        gemString.append("Origin: ").append(getOrigin()).append("\n}");
       return gemString.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return (super.equals(obj) && ((NaturalGem)obj).getOrigin().equals(origin) );
    }
    
}
