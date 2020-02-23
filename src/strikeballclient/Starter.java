/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeballclient;

import java.io.IOException;

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
        
        while(client.getConnessione().isConnected()){
            System.out.println(client.getLettore().readLine());
        }
    }
    
}
