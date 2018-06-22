/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratserver.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import strat.objects.Unit;

/**
 * Az egység XML-eket beolvasó osztály. 
 * @author Ahkriin
 */
public class XmlReader {
    public List<Unit> readXml (File inputFile){
        List<Unit> retVal = new ArrayList<Unit>();
        try {
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         NodeList nList = doc.getElementsByTagName("unit");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               String name = eElement.getElementsByTagName("name").item(0).getTextContent();
               int health = Integer.parseInt(eElement.getElementsByTagName("health").item(0).getTextContent());
               int attack = Integer.parseInt(eElement.getElementsByTagName("attack").item(0).getTextContent());
               int defense = Integer.parseInt(eElement.getElementsByTagName("deffense").item(0).getTextContent());
               int movement = Integer.parseInt(eElement.getElementsByTagName("move").item(0).getTextContent());
               Unit parsedUnit = new Unit(temp+2,name,health, attack, defense, movement);
               retVal.add(parsedUnit);
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
        return retVal;
    }
}
