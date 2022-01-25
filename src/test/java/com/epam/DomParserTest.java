package com.epam;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import com.epam.exeption.ParserCustomExeption;
import com.epam.init.Gem;
import com.epam.init.NaturalGem;
import com.epam.init.SyntheticGem;
import com.epam.init.Transparency;
import com.epam.init.VisualParametrs;
import com.epam.parsersFolder.iml.DomParser;

import org.junit.Test;

public class DomParserTest {

    private String fileName = "src/test/java/com/epam/resourses/GemsOneMore.xml";

    @Test
    public void parseTestShouldReturnListOfGems() throws  ParserCustomExeption{
        //given
        List<Gem> expected = new ArrayList<>();
        NaturalGem nGem = new NaturalGem("id-1t67", 123);
        nGem.setName("gem1");
        nGem.setValue((float)34.4);
        nGem.setVisualParametrs(new VisualParametrs());
        nGem.getVisualParametrs().setColour("blue");
        nGem.getVisualParametrs().setTypeOfCut(6);
        nGem.getVisualParametrs().setTransparency(Transparency.LOW);
        nGem.setOrigin("veryogigin");
        SyntheticGem sGem = new SyntheticGem("id-k3", 0);
        sGem.setName("hhhhhhh");
        sGem.setValue((float)78.8);
        sGem.setVisualParametrs(new VisualParametrs());
        sGem.getVisualParametrs().setColour("goopy");
        sGem.getVisualParametrs().setTypeOfCut(7);
        sGem.getVisualParametrs().setTransparency(Transparency.HIGH);
        sGem.setManufacturer("perdak");

        expected.add(nGem);
        expected.add(sGem);
        //when
        DomParser domParser = new DomParser();
        List<Gem> actual = domParser.parse(fileName);
        //then
        assertEquals(expected, actual);
        
    }
    
}
