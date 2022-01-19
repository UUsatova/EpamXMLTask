package com.epam;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import com.epam.init.Gem;
import com.epam.init.NaturalGem;
import com.epam.init.SyntheticGem;
import com.epam.init.Transparency;
import com.epam.init.VisualParametrs;
import com.epam.parsersFolder.iml.SaxParser;

import org.junit.Test;
import org.xml.sax.SAXException;

public class SaxParserTest {
    private String fileName = "src/test/java/com/epam/resourses/GemsOneMore.xml";

    @Test
    public void parserTestShouldReturnListOfGemsAccodingToXML() throws SAXException, ParserConfigurationException, IOException{
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
        SaxParser saxParser = new SaxParser();
        List<Gem> actual = saxParser.parse(fileName);
        //then
        assertEquals(expected, actual);
        
    }



    @Test
    public void test(){

        VisualParametrs vp1 = new VisualParametrs();
        vp1.setColour("blue");
        vp1.setTypeOfCut(9);
        vp1.setTransparency(Transparency.HIGH);
        VisualParametrs vp2 = new VisualParametrs();
        vp2.setColour("blue");
        vp2.setTypeOfCut(9);
        vp2.setTransparency(Transparency.HIGH);

        Gem nGem = new Gem("id-1t67", 123);
        nGem.setName("gem1");
        nGem.setValue((float)34.4);
        nGem.setVisualParametrs(vp1);
        //nGem.setOrigin("veryogigin");

        Gem nnGem = new Gem("id-1t67", 123);
        nnGem.setName("gem1");
        nnGem.setValue((float)34.4);
        nnGem.setVisualParametrs(vp1);
       // nnGem.setOrigin("veryogigin");

        assertEquals(nGem, nnGem);
    }
    
}
//parserfactory?saxparser?hendler?errorhendler