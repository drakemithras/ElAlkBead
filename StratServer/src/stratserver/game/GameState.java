/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratserver.game;

import strat.objects.Battleground;
import stratserver.mapgen.MapGen;

/**
 *
 * @author Ahkriin
 */
public class GameState {
    
    private static GameState instance = null;
    private static Battleground map;
    private static boolean playerTwoTurn;
    
    private GameState (){
        this.map = MapGen.generate();
        this.playerTwoTurn = false;
    }
    
    public static GameState getInstance (){
        if(instance == null) {
         instance = new GameState();
      }
      return instance;
    }
    
    public Battleground getMap (){
        return this.map;
    } 
    
    public boolean getPlayerTwoTurn (){
        return this.playerTwoTurn;
    }
    public synchronized void setPlayerTwoTurn (boolean value){
        this.playerTwoTurn = value;
    }
    
    private void move(int startX, int startY, int destX, int destY){
        
    }
}
