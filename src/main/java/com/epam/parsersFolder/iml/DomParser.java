package com.epam.parsersFolder.iml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.epam.init.CommonGemEnum;
import com.epam.init.Gem;
import com.epam.init.NaturalGem;
import com.epam.init.SyntheticGem;
import com.epam.init.Transparency;
import com.epam.init.VisualParametrs;
import com.epam.parsersFolder.Parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParser implements Parser {
    
    private CommonGemEnum getTypeOfNode(Node node){
        for(CommonGemEnum item : CommonGemEnum.values()){
            if(item.getValue().equals(node.getNodeName())) return item;
        }
        return null;
    }

    private VisualParametrs createVisualParametrs(Node nodeWithVisualParametrs){
        VisualParametrs visualParametrs = new VisualParametrs();
      NodeList listWithAllVPFields = nodeWithVisualParametrs.getChildNodes();
      for(int i = 0;i < listWithAllVPFields.getLength(); i++){
          Node currVPField = listWithAllVPFields.item(i);
          CommonGemEnum currVPTagType = getTypeOfNode(currVPField);
          String textInCurrVPField = "";
          if(currVPTagType != null){
              textInCurrVPField = currVPField.getChildNodes().item(0).getNodeValue();
          }
          
          if(currVPTagType == CommonGemEnum.TRANSPARENCY){
              for(Transparency item : Transparency.values()){
                  if(item.getValue().equals(textInCurrVPField)){
                  visualParametrs.setTransparency(item);
                  }
              }
          }
          if(currVPTagType == CommonGemEnum.TYPE_OF_CUT){
              visualParametrs.setTypeOfCut(Integer.parseInt(textInCurrVPField));
          }
          if(currVPTagType == CommonGemEnum.COLOUR){
              visualParametrs.setColour(textInCurrVPField);
          }
      }
      return visualParametrs;

    }

    private Gem createGem(Node nodeWithGem){
         String id = "";
         Integer hallmark = 0;
         String name = "";
         VisualParametrs visualParametrs = null ;
         Float value = (float) 0;
         String manufacturer = "" ;
         String origin = "";

         NamedNodeMap gemAtributs = nodeWithGem.getAttributes();
         id = gemAtributs.getNamedItem("id").getTextContent();    
         if(gemAtributs.getNamedItem("hallmark") != null ) {
             hallmark = Integer.parseInt( gemAtributs.getNamedItem("hallmark").getTextContent());
         }

         NodeList listWithAllGemFields = nodeWithGem.getChildNodes();
         for(int i = 0;i < listWithAllGemFields.getLength(); i++){
            Node currGemField = listWithAllGemFields.item(i);
            CommonGemEnum currGemTagType = getTypeOfNode(currGemField );
            String textInCurrGemField = "";
            if(currGemTagType != null) textInCurrGemField = currGemField .getChildNodes().item(0).getNodeValue();
          
            if(currGemTagType == CommonGemEnum.NAME){
                name = textInCurrGemField ;
            }
            if(currGemTagType == CommonGemEnum.VALUE){
             value = Float.parseFloat(textInCurrGemField );
            }
            if(currGemTagType == CommonGemEnum.VISUAL_PARAMETRS){
             visualParametrs = createVisualParametrs(currGemField);
            }
            if(currGemTagType == CommonGemEnum.MANUFACTURER){
              manufacturer = textInCurrGemField ;
            }
            if(currGemTagType == CommonGemEnum.ORIGIN){
              origin = textInCurrGemField ;
            }
           
        }

        if(CommonGemEnum.NATURAL_GEM.getValue().equals(nodeWithGem.getNodeName())) {
              return new NaturalGem(id,hallmark ,name, visualParametrs, value,origin);
        }
        if(CommonGemEnum.SYNTHETIC_GEM.getValue().equals(nodeWithGem.getNodeName())){
             return new SyntheticGem(id,hallmark ,name, visualParametrs, value,manufacturer);
        }
        return null;
        
    }

    public List<Gem> createListOfGems(NodeList nodeList){
        List<Gem> gems = new ArrayList<>();
        for(int i = 0;i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if(nodeList.item(i).hasChildNodes()) {
               gems.add( createGem(node) );
            }
           
        }
        return gems;
    }


    @Override
    public List<Gem> parse(String fileName) throws ParserConfigurationException {
        try{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(fileName));
        Element root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        return createListOfGems(nodeList);
        }catch(ParserConfigurationException | SAXException | IOException e ){
            throw new ParserConfigurationException();
        }
        
    }


   
}


/*
            if(nodeList.item(i).hasChildNodes()) {
            System.out.println( );
            System.out.print("<"+ nodeList.item(i).getNodeName()+ ">"  );
             foo(nodeList.item(i).getChildNodes());   
            } 
            else if(!nodeList.item(i).getNodeValue().trim().equals("")) {
                System.out.print( nodeList.item(i).getNodeValue() );  
            }
            */