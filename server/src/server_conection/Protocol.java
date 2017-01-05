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
 * The class protocol of server connection.
 * @author miguel
 */
public class Protocol {
     
/**
 * In case of received request calls different methods of the class and return the message from the result. If an error occurs retur null.
 * @param toReceive request from client
 * @return the answer from protocol, different for every case
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
        else if(stringTokens[0].equals("StartGame")){
         String string = receiveStartGame(stringTokens);
            System.out.println(string  +"taka to odpowiedz");
            return string;
        }else if(stringTokens[0].equals("Turn")){
       System.out.println("sprawdzm czyja kolej");
                 String string =  receiveTurn(stringTokens);
            System.out.println(string  +"whse turn ");
            return string;
        }else if(stringTokens[0].equals("Shoot")){
         System.out.println("sprawdzm czyja shoot kolej");
                 String string =  receiveShot(stringTokens);
            System.out.println(string  +"szot! ");
            return string;
        }else if(stringTokens[0].equals("Board")){
         String string =  receiveBoard(stringTokens);
            System.out.println(string  +"board! ");
            return string;
        }else
            return "string";
	}
    /**
     * Creating the connection between an user and the game. The game consist always of two users. 
     * @param stringTokens message received from client include username
     * @return the order of appear in the game
     */
      public String receiveStartGame(String[] stringTokens){
          /////////////
      //Game ga1me = new Game();
        Player player = new Player(stringTokens[1],stringTokens[2]);
        System.out.println("tokenyy");
        System.out.println(stringTokens[1]);
        System.out.println(stringTokens[2]);
       ///////////////
      
        if (Game.getObject().noPlayers(stringTokens[1]) == true)
        return "Connected1";
        else
        return "Connected2";
          ////////////     
    }
      /**
       * The method to handle the shot, checking if the shot is missed or correct
       * @param stringTokens message received from client include username and coordinates of shot
       * @return the YES/NO message meaning shooted/missed
       */
        public String receiveShot(String[] stringTokens){
          /////////////
      //Game ga1me = new Game();
        Player player = new Player(stringTokens[1],stringTokens[2]);
        System.out.println("receiveShot");
        System.out.println(stringTokens[1]);
        System.out.println(stringTokens[2]);
       ///////////////
      
        if (Game.getObject().shot(stringTokens[2]) == true){
            System.out.println("TRAF");
        return "YES";}
        else{
             System.out.println("PUDLO");
        return "NO";}
          ////////////     
    }
      
      /**
       * The method to set the board of an user on server. 
       * @param stringTokens message received from client include username and coordinates of ships
       * @return message of user that created the Board 
       */
         public String receiveBoard(String[] stringTokens){
          /////////////
      //Game ga1me = new Game();
        Player player = new Player(stringTokens[1],stringTokens[2]);
        System.out.println("taka plansza");
        System.out.println(stringTokens[1]);
        System.out.println(stringTokens[2]);
       ///////////////
      
        if (Game.getObject().setBoard(stringTokens[1],stringTokens[2]) == true){
            System.out.println("dzialam");
        return "player1";}
        else
        return "player2";
          ////////////     
    }
        /**
         * Checking whose turn it is.
         * @param stringTokens message received from client include username
         * @return the information about the turn, return the name of the player that turn it is.
         */
       public String receiveTurn(String[] stringTokens){
          /////////////
      //Game ga1me = new Game();
        Player player = new Player(stringTokens[1],stringTokens[2]);
        System.out.println("tokenkjjjjhyy");
        System.out.println(stringTokens[1]);
        System.out.println(stringTokens[2]);
       ///////////////
      
        if (Game.getObject().myTurn(stringTokens[1]) == true){
            System.out.println("dzialam");
        return "player1";}
        else
        return "player2";
          ////////////     
    }
   /**
    * Method to log in the user. Checking if the password is correct.
    * @param stringTokens message received from client include username and password
    * @return string to inform if the login was successfull
    */
    public String receiveLogin(String[] stringTokens){
        Player player = new Player(stringTokens[1],stringTokens[2]);
        System.out.println(stringTokens[1]);
        System.out.println(stringTokens[2]);
       
          
        if (player.checkPassword())
        return "LOGIN_WITH_SUCCESS";
        else
        return "LOGIN_FAIL";
               
    }
     /**
      * Method to register an user.
      * @param stringTokens message received from client include all information about user, username, first name, last name, password, age
      * @return an information of successfull registration
      */
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
    
    
 
