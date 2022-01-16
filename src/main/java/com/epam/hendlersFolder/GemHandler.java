package com.epam.hendlersFolder;

import java.util.ArrayList;
import java.util.List;

import com.epam.init.CommonGemEnum;
import com.epam.init.Gem;
import com.epam.init.NaturalGem;
import com.epam.init.SyntheticGem;
import com.epam.init.VisualParametrs;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class GemHandler extends DefaultHandler {

    List<Gem> gems = new ArrayList<>();
    CommonGemEnum currentTeg;

    @Override
    public void startDocument(){

    }

    private Integer getHallmark(Attributes attributes){
        Integer hallmark = 0;
        if(attributes.getLength() == 1) {
            hallmark = Integer.parseInt( attributes.getValue(1));
        }
        return hallmark;
    }

    @Override
    public void startElement(String uri, String localName,String qName, Attributes attributes){
        Gem currGem = null;
        if(qName.equals(CommonGemEnum.GEM.getValue())){
            currGem = new Gem(attributes.getValue(0), getHallmark(attributes));
            currentTeg = CommonGemEnum.GEM;
        }
        if(qName.equals(CommonGemEnum.NATURAL_GEM.getValue())){
            currGem = new NaturalGem(attributes.getValue(0), getHallmark(attributes));
            currentTeg = CommonGemEnum.NATURAL_GEM;
        }
        if(qName.equals(CommonGemEnum.SYNTHETIC_GEM.getValue())){ 
            currGem = new SyntheticGem(attributes.getValue(0), getHallmark(attributes));
            currentTeg = CommonGemEnum.SYNTHETIC_GEM;
        }
        if(qName.equals(CommonGemEnum.VISUAL_PARAMETRS.getValue())){
            gems.get(gems.size() - 1).setVisualParametrs(new VisualParametrs());
            currentTeg = CommonGemEnum.VISUAL_PARAMETRS;
        }
        if(qName.equals(CommonGemEnum.TRANSPARENCY.getValue())){
            //&&&&&&&&&&&&&&&&&&&
            currentTeg = CommonGemEnum.TRANSPARENCY;
        }
        if(qName.equals(CommonGemEnum.NAME.getValue())){
            currentTeg = CommonGemEnum.NAME;
        }
        if(qName.equals(CommonGemEnum.VALUE.getValue())){
            currentTeg = CommonGemEnum.VALUE;
        }
        if(qName.equals(CommonGemEnum.COLOUR.getValue())){
            currentTeg = CommonGemEnum.COLOUR;
        }
        if(qName.equals(CommonGemEnum.TYPE_OF_CUT.getValue())){
            currentTeg = CommonGemEnum.TYPE_OF_CUT;
        }
        if(qName.equals(CommonGemEnum.ORIGIN.getValue())){
            currentTeg = CommonGemEnum.ORIGIN;
        }
        if(qName.equals(CommonGemEnum.MANUFACTURER.getValue())){
            currentTeg = CommonGemEnum.MANUFACTURER;
        }
       

    }

    @Override
    public void characters(char[] ch, int start, int length){

    }

    @Override
    public void endElement(String uri, String localName, String qName){

    }

    @Override
    public void endDocument(){

    }
    
    public List<Gem> getGems() {
        return gems;
    }
    
}
