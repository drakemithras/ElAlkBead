/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratserver.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Játékszabályokat lebonyolító osztály
 * @author Ahkriin
 */
public class GameThread extends Thread{
    
    protected Socket socket;
    protected boolean turn;
    protected int connTest = 0;
    protected boolean playerTwo;
    protected boolean playerTwoTurn;
    private boolean active;
    private GameState gameStateInstance;
    
    public GameThread(Socket clSocket, boolean playerTwo) {
        active = true;
        this.socket = clSocket;
        this.playerTwo = playerTwo;
        gameStateInstance = GameState.getInstance();
    }
    
    @Override
    public void run (){
        while(active){
            try {
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(gameStateInstance.getMap());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                
                
                this.playerTwoTurn = gameStateInstance.getPlayerTwoTurn();
                if (this.playerTwo){
                    oos.writeBoolean(this.playerTwoTurn);
                    if (this.playerTwoTurn){
                        ois.readObject();
                    }
                }else{
                    oos.writeBoolean(!this.playerTwoTurn);
                    if (!this.playerTwoTurn){
                        ois.readObject();
                    }
                }
                
            } catch (IOException ex) {
                System.out.println("error");
            } catch (ClassNotFoundException ex) {
                System.out.println("error");
            }
        }
        if (playerTwo){
            System.out.println("Player two disconnected");
        }else{
            System.out.println("Player one disconnected");
        }
    }
    
    
}
