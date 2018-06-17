/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratserver.game;

import java.net.Socket;

/**
 * Játékszabályokat lebonyolító osztály
 * @author Ahkriin
 */
public class GameThread extends Thread{
    
    protected Socket socket;

    public GameThread(Socket clientSocket) {
        this.socket = clientSocket;
    }
    
    /**
     * Egy az éppen soron következő kliens által megtehető lépés.
     * @param x
     * @param y
     * @return 
     */
    public synchronized boolean move(int x, int y){
        return true;
    }
    
}
