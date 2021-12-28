package com.epam;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class XmlValidatorTest {

    @Test
    public void validTestShouldReturnTrueOnCorrectData() throws SAXException, IOException{
        XmlValidator xmlValidator = new XmlValidator();
        assertTrue(xmlValidator.valid("src//test//java//com//epam//resourses//Gems.xml", "src//test//java//com//epam//resourses//GemsCheck.xsd"));
        
    }

    @Test
    public void validTestShouldReturnFalseOnIncorrectData() throws SAXException, IOException{
        XmlValidator xmlValidator = new XmlValidator();
        assertFalse(xmlValidator.valid("src//test//java//com//epam//resourses//IncorrectGems.xml", "src//test//java//com//epam//resourses//GemsCheck.xsd"));
        
    }

    @Test(expected = org.xml.sax.SAXException.class)
    public void validTestShouldThrowSAXEceptionOnIncorrectSyntax() throws SAXException, IOException{
        XmlValidator xmlValidator = new XmlValidator();
        xmlValidator.valid("src//test//java//com//epam//resourses//SyntaxMistakeGems.xml", "src//test//java//com//epam//resourses//GemsCheck.xsd");
        
    }

    @Test(expected = java.io.IOException.class)
    public void validTestShouldThrowIOExceptionOnMissingFile() throws SAXException, IOException{
        XmlValidator xmlValidator = new XmlValidator();
        xmlValidator.valid("file not found", "src//test//java//com//epam//resourses//GemsCheck.xsd");
        
    }
   

    
}
