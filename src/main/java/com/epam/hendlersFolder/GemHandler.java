package com.epam.hendlersFolder;

import java.util.ArrayList;
import java.util.List;

import com.epam.init.CommonGemEnum;
import com.epam.init.Gem;
import com.epam.init.NaturalGem;
import com.epam.init.SyntheticGem;
import com.epam.init.Transparency;
import com.epam.init.VisualParametrs;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class GemHandler extends DefaultHandler {

    List<Gem> gems = new ArrayList<>();
    CommonGemEnum currentTeg;
    Gem currGem ;

    private Integer getHallmark(Attributes attributes){
        Integer hallmark = 0;
        if(attributes.getLength() == 2) {
            hallmark = Integer.parseInt( attributes.getValue(1));
        }
        return hallmark;
    }

    @Override
    public void startElement(String uri, String localName,String tegName, Attributes attributes){
        for(CommonGemEnum item : CommonGemEnum.values() ){
            if(item.getValue().equals(tegName)){
                currentTeg = item;
                if(item.equals(CommonGemEnum.GEM)){
                    currGem = new Gem(attributes.getValue(0), getHallmark(attributes));
                }
                if(item.equals(CommonGemEnum.NATURAL_GEM)){
                    currGem = new NaturalGem(attributes.getValue(0), getHallmark(attributes));
                }
                if(item.equals(CommonGemEnum.SYNTHETIC_GEM)){ 
                    currGem = new SyntheticGem(attributes.getValue(0), getHallmark(attributes));
                }
                if(item.equals(CommonGemEnum.VISUAL_PARAMETRS)){
                    currGem.setVisualParametrs(new VisualParametrs());
                }
            }
        }

    }

    @Override
    public void characters(char[] allDataFromXML, int startOfCurrentContext, int lengthOfCurrentContext){
        String data = String.copyValueOf(allDataFromXML,startOfCurrentContext,lengthOfCurrentContext).trim();
        if(currentTeg  == CommonGemEnum.NAME){
            if((currGem.getName()) == (null)) {
                currGem.setName(data);
            }
        }
        if(currentTeg == CommonGemEnum.VALUE){
            if(currGem.getValue() == null){
                currGem.setValue(Float.parseFloat(data));
            }
        }
        if(currentTeg == CommonGemEnum.COLOUR){
            if(currGem.getVisualParametrs().getColour() == (null)) {
                currGem.getVisualParametrs().setColour(data);
            }
        }
        if(currentTeg == CommonGemEnum.TRANSPARENCY){
            for(Transparency item : Transparency.values()){
                if(item.getValue().equals(data)) {
                currGem.getVisualParametrs().setTransparency(item);
                }
            }

        }

        if(currentTeg == CommonGemEnum.TYPE_OF_CUT){
            if(currGem.getVisualParametrs().getTypeOfCut() == null){
                currGem.getVisualParametrs().setTypeOfCut(Integer.parseInt(data));
            }
        }

        if(currentTeg == CommonGemEnum.ORIGIN){
            if(((NaturalGem) currGem).getOrigin() == null){
                ((NaturalGem) currGem).setOrigin(data);
            }
        }

        if(currentTeg == CommonGemEnum.MANUFACTURER){
            if(((SyntheticGem)currGem).getManufacturer() == null){
                ((SyntheticGem)currGem).setManufacturer(data);
            }
           
        }

    }

    @Override
    public void endElement(String uri, String localName, String tagName){
        if(CommonGemEnum.GEM.getValue().equals(tagName) || 
        CommonGemEnum.NATURAL_GEM.getValue().equals(tagName) || 
        CommonGemEnum.SYNTHETIC_GEM.getValue().equals(tagName) ){
            gems.add(currGem);
        }
        
    }

    public List<Gem> getGems() {
        return gems;
    }
    
}
