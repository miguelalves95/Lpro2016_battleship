/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_conection;

import java.io.*;
import java.net.*;

/**
 *The class of sockets.
 * @author miguel
 */
public class Sockets {
    
    private static final int    servicePORT = 1032;
    private static final String HOST = "localhost";

   
    private Socket sockClient;
    private BufferedReader in;
    private PrintWriter out;  
/**
 * Constructor of the class.
 */
    public Sockets(){
            try{
                    sockClient = new Socket(HOST, servicePORT);
                    in  = new BufferedReader(new InputStreamReader( sockClient.getInputStream()));
                    out = new PrintWriter( sockClient.getOutputStream(), true );
            }
            catch(Exception e){  
                    System.out.println(e);  
            }               
    }

/**
 * Send the message to server.
 * @param mensagem message to the server
 */
    public void send(String mensagem){
        System.out.println("teste send socket client");
           out.println(mensagem);
    }
/**
 * Receive the message from the server
 * @return the received message
 */
    public String receive(){
        String data_out = null;
        try {       
            
           data_out = in.readLine();
            System.out.println(data_out); 
     
        } catch (IOException ex){
          System.out.println("Error to receive");
        }

        return data_out;
    }
    public void close() throws IOException{
      out.close();
      in.close();
      sockClient.close();
   }
    

}
