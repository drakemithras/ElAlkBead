/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratserver.objects;

/**
 * Egy mező amiből a térkép előáll.
 * @author Ahkriin
 */
public class Tile {
    protected boolean passable;
    protected int id;
    protected String name;
    
    public Tile (){
        this.passable = true;
        this.id = 0;
    }
    
    public Tile (boolean passable, int id){
        this.passable = passable;
        this.id = id;
    }
}
