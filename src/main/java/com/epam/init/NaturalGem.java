package com.epam.init;

public class NaturalGem extends Gem {

    private String origin;

    public NaturalGem(String id, Integer hallmark) {
        super(id, hallmark);
        
    }


    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
       String str = "NaturalGem {\n" + this.getId() +"\n" + this.getName() + "\n" + this.getOrigin()  +"\n"
        + this.getHallmark() +"\n" + this.getValue() +"\n" + this.getVisualParametrs().getColour()  +"\n"+ this.getVisualParametrs().getTypeOfCut()  +"\n"+ this.getVisualParametrs().getTransparency()  +"\n}";
        return super.toString();
    }
    
}
