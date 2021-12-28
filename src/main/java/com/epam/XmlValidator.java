package com.epam;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import com.epam.hendlersFolder.GemErrorHendler;

import org.xml.sax.SAXException;

public class XmlValidator {

    public boolean valid(String xmlName,String xsdName) throws SAXException, IOException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language) ;
        Source sourse = new StreamSource( xsdName);//&&
        Schema schema =  factory.newSchema(sourse);
        Validator validator = schema.newValidator();

        GemErrorHendler gemErrorHendler = new GemErrorHendler();
        validator.setErrorHandler(gemErrorHendler);
        validator.validate(new StreamSource(new File(xmlName)));
            
        return !gemErrorHendler.isExeptionFound() ;
        
    }
   
  

   
    
}
