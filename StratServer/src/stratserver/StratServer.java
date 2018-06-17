/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import stratserver.game.GameThread;

/**
 * Hálózati komunikációért felelős fő osztály, inicializálja a térképet
 * és lebonyolítja a kliensek közötti kommmunikációt.
 * @author Ahkriin
 */
public class StratServer {
    
    public static final int PORT = 7654;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();

        }
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            new GameThread(socket).start();
        }
    }
    
}
