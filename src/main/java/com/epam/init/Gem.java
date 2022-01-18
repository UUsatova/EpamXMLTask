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
    
}
