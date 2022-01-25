package com.epam.parsersFolder;

import java.util.List;


import com.epam.exeption.ParserCustomExeption;
import com.epam.init.Gem;


public interface Parser {
    List<Gem> parse(String fileName)  throws ParserCustomExeption ; 
    
}
