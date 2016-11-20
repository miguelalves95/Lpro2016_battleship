/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_conection;

import java.util.*;
import server_bl.*;
import server_conection.*;
import server_data.*;
import java.sql.*;



/**
 *
 * @author miguel
 */
public class Protocol {
     
    /**
     *O método receiveLogin recebe uma string do cliente através do método receive.
     *Depois divide essa string em tokens de modo a interpretar os diferentes campos da
     * mesma. Retorna o username e a password recebidos.
     */
    
    
    public String protReceive(String toReceive)
    {    System.out.println(toReceive);
        
        String[] stringTokens;
        stringTokens= toReceive.split("#");
        if(stringTokens[0].equals("Login"))
            return receiveLogin(stringTokens);
        else if(stringTokens[0].equals("Register")){
            String string = receiveRegister(stringTokens);
            System.out.println(string  +"protreceive sistem ");
            return string;}
        else return "string";
    
	}
    
    
   
    public String receiveLogin(String[] stringTokens){
        Player player = new Player(stringTokens[1],stringTokens[2]);
        System.out.println(stringTokens[1]);
        System.out.println(stringTokens[2]);
       
          
        if (player.checkPassword())
        return "LOGIN_WITH_SUCCESS";
        else
        return "LOGIN_FAIL";
               
    }
     
     public String receiveRegister(String[] stringTokens){
         
         String rt;
      
         Player player = new Player(stringTokens[1], stringTokens[2], stringTokens[3], stringTokens[4], stringTokens[5], Integer.parseInt(stringTokens[6]), Integer.parseInt(stringTokens[7]));
         
         String result = player.checkRegistered();
         
         if("Is already a registed with this user".equals(result)){
             System.out.println("Is already a registed with this user");
             rt="Is already a registed with this user";
                return rt;
         }
         
        else if ("registed with sucess".equals(result) ){
             System.out.println("registed with sucess");
         rt="registed with sucess";
             return rt;
         }
         return "ERRO";
        /* String[] data_from_client_player = new String[7];
        String toReceive;
        String[] stringTokens;
        String[] data_player;

        data_player = toReceive.split("#");
        stringTokens= toReceive.split("#");
        
        int state = 0;
        System.out.println("Login".equals(stringTokens[0]));
        if("register".equals(stringTokens[0])){
        System.out.println("teste do register antes devia dar true");
        data_from_client_player[0]=data_player[1];
        data_from_client_player[1]=data_player[2];
        data_from_client_player[2]=data_player[3];
        data_from_client_player[3]=data_player[4];
        data_from_client_player[4]=data_player[5];
        data_from_client_player[5]=data_player[6];
        data_from_client_player[6]=data_player[7];
        
        return null;}
        else*/
            
     }
    
    
            
   
  

   
}
    
    
 
