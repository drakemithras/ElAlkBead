/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratserver.xml;

import java.io.File;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import strat.objects.Unit;

/**
 *
 * @author Ahkriin
 */
public class XmlReaderTest {
    
    public XmlReaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readXml method, of class XmlReader.
     */
    @Test
    public void testReadXml() {
        System.out.println("readXml");
        File inputFile = new File("Game_units.xml");
        XmlReader instance = new XmlReader();
        List<Unit> result = instance.readXml(inputFile); 
        for (Unit unit : result){
            System.out.println(unit);
        }
    }
    
}
