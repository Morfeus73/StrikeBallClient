/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeballclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author mirco
 */
public class StrikeBallClient {

    private static String ipServer="localhost";
    private static int portaServer=3500;
    private Socket connessione;
    private BufferedReader Lettore;
    private PrintWriter Scrittore;

    public StrikeBallClient() {
        try{
            connessione = new Socket(ipServer,portaServer);
            System.out.println("Connessione stabilita con il server "+ipServer+" nella porta "+portaServer);
            Lettore = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
            Scrittore = new PrintWriter(connessione.getOutputStream(),true);
        }catch (PortUnreachableException ex){
            System.err.println("Impossibile connettersi alla porta "+portaServer+" dell'indirizzo ip "+ipServer);
        }catch (UnknownHostException ex){
            System.err.println("Impossibile connettersi all'indirizzo ip "+ipServer);
        }catch (NoRouteToHostException ex){
            System.err.println("Impossibile connettersi all'indirizzo ip "+ipServer+" (Host irraggiungibile)");
        }catch (IOException ex){
            System.err.println("Errore nello stabilire la connessione con il server "+ipServer+" nella porta "+portaServer);
        }
    }
    
    public Socket getConnessione(){
        return connessione;
    }

    public BufferedReader getLettore() {
        return Lettore;
    }

    public PrintWriter getScrittore() {
        return Scrittore;
    }
    
    
}
