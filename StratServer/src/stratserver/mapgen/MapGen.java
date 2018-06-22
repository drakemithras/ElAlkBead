/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratserver.mapgen;

import java.io.File;
import java.util.List;
import java.util.Random;
import strat.objects.Battleground;
import strat.objects.Constants;
import strat.objects.Tile;
import strat.objects.Unit;
import stratserver.xml.XmlReader;

/**
 * A kezdeti térkép generálását végző osztály
 * @author Ahkriin
 */
public class MapGen {
    private static Battleground bg;
    private static Tile[][] map;
    
    public static Battleground generate(){
        map = new Tile[Constants.MAP_Y_SIZE][Constants.MAP_X_SIZE];      
        for (int idy = 0; idy < map.length; ++idy){
            for (int idx = 0; idx < map[idy].length; ++idx){
                map[idy][idx] = new Tile();
            }
        }
        
        for (int idy = 0; idy < map.length; ++idy){
            for (int idx = 5; idx < map[idy].length-5; ++idx){
                Random r = new Random();
                if (r.nextInt(100)<10){
                    map[idy][idx] = new Tile(false, 1);
                }
            }
        }
        
        List<Unit> units = XmlReader.readXml(new File("Game_units.xml"));
        
        int offset = 0;
        for (Unit unit : units){
            map[0+offset][0] = unit;
            map[map.length-1-offset][0] = unit;
            
            unit.setPlayerTwoOwned(true);
            map[0+offset][map[0].length-1] = unit;
            map[map.length-1-offset][map[0].length-1] = unit;
            ++offset;
        }
        return new Battleground(map);
    }
}
