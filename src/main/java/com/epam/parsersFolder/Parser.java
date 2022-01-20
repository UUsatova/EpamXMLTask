package com.epam.parsersFolder;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import com.epam.exeption.ParserCustomExeption;
import com.epam.init.Gem;

import org.xml.sax.SAXException;

public interface Parser {
    List<Gem> parse(String fileName)  throws SAXException, ParserConfigurationException,IOException, ParserCustomExeption ; 
    
}
