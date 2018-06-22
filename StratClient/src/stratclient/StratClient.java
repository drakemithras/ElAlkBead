/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import strat.objects.Battleground;
import strat.objects.Constants;

/**
 *
 * @author Ahkriin
 */
public class StratClient {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Socket socket = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        boolean yourTurn;
        boolean active;
        Battleground map;
        
        try{
            
            socket = new Socket("localhost", Constants.PORT);
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            active = true;
            while (active){
                map = (Battleground) ois.readObject();
                yourTurn = ois.readBoolean();
                System.out.println("my turn: "+yourTurn);
                System.out.println("map:\n"+map);
                
                if (yourTurn){
                    oos.writeObject("");
                }
            }
 
        } catch (UnknownHostException ex) { 
            System.out.println("Server not found: " + ex.getMessage());
            
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found error: " + ex.getMessage());
            
        }
    }
    
}
