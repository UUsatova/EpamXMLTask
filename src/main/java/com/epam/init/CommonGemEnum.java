package com.epam.init;

public enum CommonGemEnum {
    GEM("Gem"),                  //
    
    NAME("name"),//
    VALUE("value"),//
    VISUAL_PARAMETRS("visualParameters"),  //
    COLOUR("colour"),//
    TRANSPARENCY("transparency"), // 
    TYPE_OF_CUT("typeOfCut"),//

    NATURAL_GEM("NaturalGem"),         //
    ORIGIN("origin"), //

    SYNTHETIC_GEM("SyntheticGem"),       //
    MANUFACTURER("manufacturer"); //

    private final String valueString;
    private CommonGemEnum(String valueString){
        this.valueString = valueString;
    }

    public String getValue(){
        return valueString;
    }
    
}
