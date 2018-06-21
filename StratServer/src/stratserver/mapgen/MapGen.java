/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratserver.mapgen;

import java.util.Random;
import strat.objects.Battleground;
import strat.objects.Constants;
import strat.objects.Tile;

/**
 * A kezdeti térkép generálását végző osztály
 * @author Ahkriin
 */
public class MapGen {
    private Battleground bg;
    private Tile[][] map;
    
    public Battleground generate(){
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
        
        return new Battleground(map);
    }
}
