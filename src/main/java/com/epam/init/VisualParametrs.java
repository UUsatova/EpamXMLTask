package com.epam.init;

public class VisualParametrs {

    private String colour;
    private Transparency transparency;
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
    
}
