/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratserver.mapgen;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import stratserver.objects.Battleground;
import stratserver.objects.Tile;

/**
 *
 * @author Ahkriin
 */
public class MapGenTest {
    
    public MapGenTest() {
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
     * Test of generate method, of class MapGen.
     */
    @Test
    public void testGenerate() {
        System.out.println("generate");
        MapGen instance = new MapGen();
        Battleground result = instance.generate();
        System.out.println(result);
    }
    
}
