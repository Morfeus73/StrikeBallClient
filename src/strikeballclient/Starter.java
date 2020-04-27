/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeballclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mirco
 */
public class Starter {

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        StrikeBallClient client = new StrikeBallClient();
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in)); 
        
        Lettore lettore=new Lettore(client);
        lettore.start();
        
        while(lettore.isAlive()){
            client.getScrittore().println(tastiera.readLine());
        }
        System.out.println("Connessione Chiusa!");
    }
    
}
