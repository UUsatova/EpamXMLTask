package com.epam.init;

public class Gem {
    private String id;
    private Integer hallmark = 0;

    private String name;
    private VisualParametrs visualParametrs ;
    private Float value;

    public Gem(String id,Integer hallmark ) {
        this.id = id;
        this.hallmark = hallmark;
    }


    public String getId() {
        return id;
    }
    public Integer getHallmark() {
        return hallmark;
    }

    public String getName() {
        return name;
    }

    public VisualParametrs getVisualParametrs() {
        return visualParametrs;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHallmark(Integer hallmark) {
        this.hallmark = hallmark;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   
    public void setVisualParametrs(VisualParametrs visualParametrs) {
        this.visualParametrs = visualParametrs;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Float getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder gemString = new StringBuilder();
        gemString.append(this.getClass().getSimpleName() );
        gemString.append("{\n" );
        gemString.append("ID: ").append(getId() ).append("\n" );
        gemString.append("Name: ").append(getName() ).append("\n" );
        gemString.append("Hallmark: ").append(getHallmark()).append("\n" );
        gemString.append("Value: ").append(getValue() ).append("\n" );
        gemString.append("Color: ").append(getVisualParametrs().getColour() ).append("\n" );
        gemString.append("Transparency: ").append(getVisualParametrs().getTransparency().getValue() ).append("\n" );
        gemString.append("TypeOfCut: ").append(getVisualParametrs().getTypeOfCut() );
        gemString.append("\n}" );

        return gemString.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Gem gem = (Gem)obj;
        return(id.equals(gem.getId()) && hallmark.equals(gem.getHallmark()) &&
         name.equals(gem.getName()) && Float.compare(value,gem.getValue()) == 0 && visualParametrs.equals(gem.getVisualParametrs()));

    }
    
}
