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
    protected int health;
    protected int attack;
    protected int defense;
    protected int movement;
    
    public Unit (int id, int health, int attack, int defense, int movement){
        super(false, id);
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.movement = movement;
    }
}
