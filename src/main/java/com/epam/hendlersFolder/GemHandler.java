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

    @Override
    public void startDocument(){

    }

    private Integer getHallmark(Attributes attributes){
        Integer hallmark = 0;
        if(attributes.getLength() == 2) {
            hallmark = Integer.parseInt( attributes.getValue(1));
        }
        return hallmark;
    }

    @Override
    public void startElement(String uri, String localName,String qName, Attributes attributes){
       
        if(qName.equals(CommonGemEnum.GEM.getValue())){
            currGem = new Gem(attributes.getValue(0), getHallmark(attributes));
            currentTeg = CommonGemEnum.GEM;
          //  System.out.println("GEM");
        }
        if(qName.equals(CommonGemEnum.NATURAL_GEM.getValue())){
            currGem = new NaturalGem(attributes.getValue(0), getHallmark(attributes));
            currentTeg = CommonGemEnum.NATURAL_GEM;
           // System.out.println("NATURAL_GEM");
        }
        if(qName.equals(CommonGemEnum.SYNTHETIC_GEM.getValue())){ 
            currGem = new SyntheticGem(attributes.getValue(0), getHallmark(attributes));
            currentTeg = CommonGemEnum.SYNTHETIC_GEM;
          //  System.out.println("SYNTHETIC_GEM");
        }
        if(qName.equals(CommonGemEnum.VISUAL_PARAMETRS.getValue())){
            currGem.setVisualParametrs(new VisualParametrs());
            currentTeg = CommonGemEnum.VISUAL_PARAMETRS;
          //  System.out.println("VISUAL_PARAMETRS");
        }
        if(qName.equals(CommonGemEnum.TRANSPARENCY.getValue())){
            currentTeg = CommonGemEnum.TRANSPARENCY;
          //  System.out.println("TRANSPARENCY");
        }
        if(qName.equals(CommonGemEnum.NAME.getValue())){
            currentTeg = CommonGemEnum.NAME;
          //  System.out.println("NAME");
        }
        if(qName.equals(CommonGemEnum.VALUE.getValue())){
            currentTeg = CommonGemEnum.VALUE;
          //  System.out.println("VALUE");
        }
        if(qName.equals(CommonGemEnum.COLOUR.getValue())){
            currentTeg = CommonGemEnum.COLOUR;
          //  System.out.println("COLOUR");
        }
        if(qName.equals(CommonGemEnum.TYPE_OF_CUT.getValue())){
            currentTeg = CommonGemEnum.TYPE_OF_CUT;
            //System.out.println("TYPE_OF_CUT");
        }
        if(qName.equals(CommonGemEnum.ORIGIN.getValue())){
            currentTeg = CommonGemEnum.ORIGIN;
           // System.out.println("ORIGIN");
        }
        if(qName.equals(CommonGemEnum.MANUFACTURER.getValue())){
            currentTeg = CommonGemEnum.MANUFACTURER;
           // System.out.println("MANUFACTURER");
        }
       

    }

    @Override
    public void characters(char[] ch, int start, int length){
        if(currentTeg  == CommonGemEnum.NAME){
            currGem.setName(String.copyValueOf(ch,start,length).trim());
            System.out.println(currGem.getName());
        }
        if(currentTeg == CommonGemEnum.VALUE){
            //currGem.setValue(Float.parseFloat(String.copyValueOf(ch)));
        }
        if(currentTeg == CommonGemEnum.COLOUR){
            currGem.getVisualParametrs().setColour(String.copyValueOf(ch));
        }
        if(currentTeg == CommonGemEnum.TRANSPARENCY){
            
            for(Transparency item : Transparency.values()){
                if(item.getValue().equals(String.copyValueOf(ch))) {
                currGem.getVisualParametrs().setTransparency(item);
                }
            }

        }

        if(currentTeg == CommonGemEnum.TYPE_OF_CUT){
          //  currGem.getVisualParametrs().setTypeOfCut(Integer.parseInt(String.copyValueOf(ch)));
        }

        if(currentTeg == CommonGemEnum.ORIGIN){
            ((NaturalGem) currGem).setOrigin(String.copyValueOf(ch));
        }

        if(currentTeg == CommonGemEnum.MANUFACTURER){
            ((SyntheticGem)currGem).setManufacturer(String.copyValueOf(ch));
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName){
        if(qName.equals(CommonGemEnum.GEM.getValue())){
            gems.add(currGem);
        }
        if(qName.equals(CommonGemEnum.NATURAL_GEM.getValue())){
            gems.add(currGem);
        }
        if(qName.equals(CommonGemEnum.SYNTHETIC_GEM.getValue())){ 
            gems.add(currGem);
        }
    }

    @Override
    public void endDocument(){

    }
    
    public List<Gem> getGems() {
        return gems;
    }
    
}
