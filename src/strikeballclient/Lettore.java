/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeballclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mirco
 */
public class Lettore extends Thread{
    
    private BufferedReader lettore;
    private StrikeBallClient client;
    
    public Lettore(StrikeBallClient client){
        this.lettore=client.getLettore();
        this.client=client;
    }
    
    @Override
    public void run() {
        while(client.isConnesso()){
            try {
                System.out.println(lettore.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Lettore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
