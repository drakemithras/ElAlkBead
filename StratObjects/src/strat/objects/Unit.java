/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strat.objects;

/**
 * Egy egység.
 * @author Ahkriin
 */
public class Unit extends Tile{
    static final long serialVersionUID = 7891L;
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;
    protected int movement;
    protected boolean defending;
    
    public Unit (int id, String name, int health, int attack, int defense, int movement){
        super(false, id);
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.movement = movement;
    }
    
    public void setDefending (boolean value){
        this.defending = value;
    }
    
    public void setHealth (int value){
        this.health = value;
    }
    
    @Override
    public String toString (){
        return "unit: id = "+this.id+
                " name = "+this.name+
                " health = "+this.health+
                " attack = "+this.attack+
                " defense = "+this.defense+
                " movement = "+this.movement+
                " defending = "+this.defending;
    }
}
