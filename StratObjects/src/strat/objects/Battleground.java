/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strat.objects;

import java.io.Serializable;

/**
 * A térkép szerkezete.
 * @author Ahkriin
 */
public class Battleground implements Serializable{
    static final long serialVersionUID = 1234L;
    protected Tile[][] map;
    public Battleground (Tile[][] map){
        this.map = map;
    }
    
    @Override
    public String toString(){
        StringBuilder retVal = new StringBuilder();
        for (int idy = 0; idy < map.length; ++idy){
            for (int idx = 0; idx < map[idy].length; ++idx){
                retVal.append(map[idy][idx].id);
            }
            retVal.append("\n");
        }
        return retVal.toString();
    }
}
