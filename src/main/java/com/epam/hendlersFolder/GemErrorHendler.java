package com.epam.hendlersFolder;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class GemErrorHendler extends DefaultHandler {

   private final Logger LOGGER = LogManager.getLogger();
   private boolean isExeptionFound = false;
    
    @Override
    public void warning(SAXParseException exception) {
        LOGGER.warn(exception.getLineNumber() + ": " + exception.getMessage());
        isExeptionFound = true;
       
    }

    @Override
    public void error(SAXParseException exception) {
        LOGGER.error(exception.getLineNumber() + ": " + exception.getMessage());
        isExeptionFound = true;
       
    }

    @Override
    public void fatalError(SAXParseException exception) {
        LOGGER.fatal(exception.getLineNumber() + ": " + exception.getMessage());
        isExeptionFound = true;
        
    }

    public boolean isExeptionFound(){
        return isExeptionFound;
    }

    
}
