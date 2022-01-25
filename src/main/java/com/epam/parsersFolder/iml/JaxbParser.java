package com.epam.parsersFolder.iml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.epam.exeption.ParserCustomExeption;
import com.epam.init.Gem;
import com.epam.init.NaturalGem;
import com.epam.init.SyntheticGem;
import com.epam.init.Transparency;
import com.epam.init.VisualParametrs;
import com.epam.parsersFolder.Parser;

public class JaxbParser implements Parser {

    @Override
    public List<Gem> parse(String fileName) throws ParserCustomExeption  {

        try{

           

            // NaturalGem gem1 = new NaturalGem();
            // gem1.setId("o");
            // gem1.setHallmark(8);
            // gem1.setName("7777");
            // gem1.setValue((float)9.444449999);
            // VisualParametrs v1p = new VisualParametrs();
            // v1p.setColour("ljjjjol");
            // v1p.setTypeOfCut(94);
            // v1p.setTransparency(Transparency.LOW);
            // gem1.setVisualParametrs(vp);
            // gem1.setOrigin("kkkkkk");

            // List<Gem> gemss = new ArrayList<>();
            // gemss.add(gem);
            //  gemss.add(gem1);
            // Gems gems = new Gems();
            // gems.setGems(gemss);

        JAXBContext jaxbContext = JAXBContext.newInstance( Gems.class );
        //Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        
        /* set this flag to true to format the output */
       // jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
        
        /* marshaling of java objects in xml (output to file and standard output) */
        //jaxbMarshaller.marshal( countries, new File( "country.xml" ) );
       // jaxbMarshaller.marshal( gems, System.out );




        File file = new File( fileName );
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Gems gems = (Gems)jaxbUnmarshaller.unmarshal( file );
        System.out.println( gems.getGems());

       // VisualParametrs vp = (VisualParametrs)jaxbUnmarshaller.unmarshal( file );



        }
        catch(JAXBException e){
            throw new ParserCustomExeption(e);
        }



        return null;
        // TODO Auto-generated method stub
        
    }

     public static void main(String[] args) throws ParserCustomExeption {

        JaxbParser jp = new JaxbParser();
        jp.parse("src/test/java/com/epam/resourses/Gems.xml");
        
    }
    
}
