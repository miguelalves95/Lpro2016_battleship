/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_conection;

import java.io.*;
import java.net.*;

/**
 *
 * @author miguel
 */
public class Sockets {
    ghgjhg
    private static final int    servicePORT = 1621;
    private static final String HOST = "localhost";

   
    private Socket sockClient;
    private BufferedReader in;
    private PrintWriter out;  

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


    public void send(String mensagem){
        System.out.println("teste send socket client");
           out.println(mensagem);
    }

    public String receive(){
        String data_out = null;
        try {       
            System.out.println(data_out + "antes de receber"); 
           data_out = in.readLine();
            System.out.println(data_out); 
     
        } catch (IOException ex){
          System.out.println("Erro na receive do sockets client");
        }

        return data_out;
    }
    public void close() throws IOException{
      out.close();
      in.close();
      sockClient.close();
   }
    

}
