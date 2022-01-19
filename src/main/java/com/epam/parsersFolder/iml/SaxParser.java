package com.epam.parsersFolder.iml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.epam.hendlersFolder.GemHandler;
import com.epam.init.Gem;
import com.epam.parsersFolder.Parser;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SaxParser implements Parser {

    @Override
    public List<Gem> parse(String fileName) throws SAXException, ParserConfigurationException, IOException  {
        List<Gem> gems = new ArrayList<>();
        
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        XMLReader xmlReader = parser.getXMLReader();
        GemHandler handler = new GemHandler();
        xmlReader.setContentHandler(handler); // setErrorHandler
        xmlReader.parse(fileName);
        gems = handler.getGems();

        return gems;
    }

    
    
}
