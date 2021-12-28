package com.epam.init;

public enum Transparency {
    
    HIGH("high"),
    LOW("low"),
    MEDIUM("medium");

    private final String valueString;
    private Transparency(String valueString){
        this.valueString = valueString;
    }

    public String getValue(){
        return valueString;
    }
    
}
