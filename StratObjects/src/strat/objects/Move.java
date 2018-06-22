/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strat.objects;

import java.io.Serializable;

/**
 *
 * @author Ahkriin
 */
public class Move implements Serializable{
    static final long serialVersionUID = 1472L;
    private final int startPosX;
    private final int startPosY;
    private final int destPosX;
    private final int destPosY;
    private final boolean stance;
    private boolean playerTwo;
    
    public Move (int startX, int startY, int destX, int destY, boolean atkDefStance){
        this.startPosX = startX;
        this.startPosY = startY;
        this.destPosX = destX;
        this.destPosY = destY;
        this.stance = atkDefStance;
        this.playerTwo = false;
    }
    
    public Move (int startX, int startY, int destX, int destY, boolean atkDefStance, boolean playerTwo){
        this.startPosX = startX;
        this.startPosY = startY;
        this.destPosX = destX;
        this.destPosY = destY;
        this.stance = atkDefStance;
        this.playerTwo = playerTwo;
    }
    
    public void setPlayerTwo (boolean value){
        this.playerTwo = value;
    }
    
    public int getStartPosX() {
        return startPosX;
    }

    public int getStartPosY() {
        return startPosY;
    }

    public int getDestPosX() {
        return destPosX;
    }

    public int getDestPosY() {
        return destPosY;
    }

    public boolean isStance() {
        return stance;
    }
    
    public boolean isPlayerTwo() {
        return playerTwo;
    }
    
}
