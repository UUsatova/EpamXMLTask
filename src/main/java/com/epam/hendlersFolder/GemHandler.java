package com.epam.hendlersFolder;

import java.util.ArrayList;
import java.util.List;

import com.epam.init.Gem;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class GemHandler extends DefaultHandler {

    List<Gem> gems = new ArrayList<>();

    @Override
    public void startDocument(){

    }

    @Override
    public void startElement(String uri, String localName,String qName, Attributes attributes){

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
