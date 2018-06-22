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
import strat.objects.Move;

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
    ObjectOutputStream oos;
    ObjectInputStream ois;
    
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
                oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(gameStateInstance.getMap());
                ois = new ObjectInputStream(socket.getInputStream());
                oos.flush();
                
                this.playerTwoTurn = gameStateInstance.getPlayerTwoTurn();
                if (this.playerTwo){
                    oos.writeBoolean(this.playerTwoTurn);
                    oos.flush();
                    if (this.playerTwoTurn){
                        waitForValidCommand(playerTwo);
                    }
                }else{
                    oos.writeBoolean(!this.playerTwoTurn);
                    oos.flush();
                    if (!this.playerTwoTurn){
                        waitForValidCommand(!playerTwo);
                    }
                }
                oos.flush();
            } catch (IOException ex) {
                System.out.println("IOException");
                break;
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException");
                break;
            }
        }
        if (playerTwo){
            System.out.println("Player two disconnected");
        }else{
            System.out.println("Player one disconnected");
        }
    }
    
    private void waitForValidCommand (boolean playerTwo) throws IOException, ClassNotFoundException{
        boolean valid = false;
        while (!valid){
            Move move = (Move) ois.readObject();
            move.setPlayerTwo(playerTwo);
            valid = gameStateInstance.move(move);
            oos.writeBoolean(valid);
        }
    }
}
