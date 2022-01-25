package com.epam.parsersFolder.iml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import com.epam.init.Gem;
import com.epam.init.NaturalGem;
import com.epam.init.SyntheticGem;

@XmlRootElement( name = "Gems", namespace="http://www.epam.com/gems" )
public class Gems {

    @XmlElements({ 
        @XmlElement(name = "NaturalGem",namespace="http://www.epam.com/gems", type = NaturalGem.class),
        @XmlElement(name = "SyntheticGem",namespace="http://www.epam.com/gems", type = SyntheticGem.class)
       })

    List<Gem> gems = new ArrayList<>();

    public Gems(){}

    public List<Gem> getGems() {
        return gems;
    }

}
