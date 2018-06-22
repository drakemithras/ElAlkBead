/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import strat.objects.Constants;
import stratserver.game.GameThread;

/**
 * Hálózati komunikációért felelős fő osztály, inicializálja a térképet
 * és lebonyolítja a kliensek közötti kommmunikációt.
 * @author Ahkriin
 */
public class StratServer {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket playerOne = null;
        Socket playerTwo = null;
        
        try {
            serverSocket = new ServerSocket(Constants.PORT);
        } catch (IOException e) {
            e.printStackTrace();

        }
        while (playerOne == null || playerTwo == null){
            while (playerOne == null) {
                System.out.println("Waiting for player one.");
                try {
                    playerOne = serverSocket.accept();
                } catch (IOException e) {
                    System.out.println("I/O error: " + e);
                }
                // new thread for a client
                System.out.println("Player one connected");
                new GameThread(playerOne, false).start();
                System.out.println("Thread start");
            }

            while (playerTwo == null) {
                System.out.println("Waiting for player two.");
                try {
                    playerTwo = serverSocket.accept();
                } catch (IOException e) {
                    System.out.println("I/O error: " + e);
                }
                // new thread for a client
                System.out.println("Player two connected");
                new GameThread(playerTwo, true).start();
                System.out.println("Thread start");
            }
        }
    }
    
}
