package com.epam.parsersFolder;


import com.epam.parsersFolder.iml.DomParser;
import com.epam.parsersFolder.iml.JaxbParser;
import com.epam.parsersFolder.iml.SaxParser;


public class ParserFactory {

    public Parser create(TypeOfParser type){
        switch (type) {
            case SAX_PARSER:
                return new SaxParser();
            case DOM_PARSER:
                return new DomParser();
            case JAXB_PARSER:
                return new JaxbParser();
            default:
            // чота выбросить 
                break;
        }
        return null;
        
    }
    
}
