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
 
public class MultiServer {
   public static void main(String[] args) throws IOException {
      ServerSocket serverSocket = null;
      boolean listening = true;
 
      try {
         serverSocket = new ServerSocket(1621);
      } catch (IOException e) {
         System.err.println("Could not listen on port: 1621.");
         System.exit(-1);
      }
 
      while (listening){
      new MultiServerThread(serverSocket.accept()).start();
       System.out.println("merdadaaaaaaaaaaaaaaaaaa");
      
      }
      
       
      serverSocket.close();
   }
}