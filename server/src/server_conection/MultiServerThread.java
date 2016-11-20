/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_conection;

/**
 *
 * @author Miguel
 */

import java.net.*;
import java.io.*;
 
public class MultiServerThread extends Thread {
   private Socket socket = null;
 
   public MultiServerThread(Socket socket) {
      super("MultiServerThread");
      this.socket = socket;
   }
 
   @Override
   public void run() {
 
      try {
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         System.out.println("entrou 1");
         String inputLine, outputLine=null;
         Protocol prot = new Protocol();
         System.out.println("entrou 2");
         if ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            outputLine = prot.protReceive(inputLine);
            
            
         }
          System.out.println(outputLine +"l+f+f+f+f+f+f+f+");
          out.println(outputLine);
          out.close();
          in.close();
          socket.close();
          System.out.println("passou do socket");
         
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}