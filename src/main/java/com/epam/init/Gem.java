package com.epam.init;

import javax.print.attribute.standard.MediaSize.NA;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gem",  propOrder = { "id", "hallmark" ,"name", "value", "visualParametrs"} )
//@XmlRootElement( name = "Gem", namespace="http://www.epam.com/gems" )
@XmlSeeAlso({NaturalGem.class, SyntheticGem.class})

public class Gem {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)

    
    @XmlAttribute( name = "id", required = true )
    private String id;
    @XmlAttribute( name = "hallmark", required = false )
    private Integer hallmark = 0;

    @XmlElement (namespace="http://www.epam.com/gems", required = true)
    private String name;
    @XmlElement (namespace="http://www.epam.com/gems", required = true)
    private VisualParametrs visualParametrs = new VisualParametrs() ;
    @XmlElement (namespace="http://www.epam.com/gems", required = true)
    private Float value;

    public Gem(){}

    public Gem(String id,Integer hallmark ) {
        this.id = id;
        this.hallmark = hallmark;
    }

    public Gem(String id,Integer hallmark ,String name,VisualParametrs visualParametrs,Float value){
        this.id = id;
        this.hallmark = hallmark;
        this.name = name;
        this.visualParametrs = visualParametrs;
        this.value = value;
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
