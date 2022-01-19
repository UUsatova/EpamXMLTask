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
    
}
