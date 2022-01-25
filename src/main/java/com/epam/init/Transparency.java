package com.epam.init;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Transparency")
@XmlEnum
public enum Transparency {
    @XmlEnumValue("high")
    HIGH("high"),
    @XmlEnumValue("low")
    LOW("low"),
    @XmlEnumValue("medium")
    MEDIUM("medium");

    private final String valueString;
    private Transparency(String valueString){
        this.valueString = valueString;
    }

    public String getValue(){
        return valueString;
    }
    
}
