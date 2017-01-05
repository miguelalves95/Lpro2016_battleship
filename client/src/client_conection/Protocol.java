/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_conection;
import client_bl.*;
/**
 *The protocol class of client connection.
 * @author miguel
 */
public class Protocol {
        
    private static Sockets sc;
    private static boolean connected = false;
    
   
     /**
      * Disconnecting from server and changing the value of variable connected to false.
      */
     public static void  disconnect(){
        connected = false;
    }
    /**
     * Connecting to server. Creating a new socket and changing the value of variable connected to true.
     */
    public static void connect(){
        if (!connected)
            sc = new Sockets();
        connected = true;
        System.out.println("Reception");
         }
/**
 * Checking if the connection is active.
 * @return True if connected.
 */
    public static boolean isConnected() {
        return connected;
    }
    
    
    
     /**
      * Send user board to server.
      * @param user username
      * @param boatsxy coordinates of boats 
      * @return success or not message from server
      */
    public static String sendBoard(String user,String boatsxy){
    
         connect();
        String toSend = "Board#"+user+"#"+boatsxy;
        String receivedReply;
        System.out.println(toSend);
        sc.send(toSend);
                           
        receivedReply = sc.receive();// you will receive OK or FAILL
        disconnect();
        if(receivedReply.equals("Connected2"))
            return "Connected2";
        else return "Connected1";
    
    }
    
 /**
  * Checking if the user can be connected.
  * @param user user login
  * @param password user password
  * @return success or not message from server
  */
    public static String sendLogin(String user, String password){
        
       
        
        connect();
        String toSend = "Login#"+user+"#"+password;
        String receivedReply;
        System.out.println(toSend);
        sc.send(toSend);
                           
        receivedReply = sc.receive(); 
        System.out.println(receivedReply);
        System.out.append(receivedReply);
        disconnect();
        if("clean".equals(receivedReply))
        return "falhou_a_conexao";
        
        else return receivedReply;
        
       }
    
    /**
     * Checking if user is already in database.
     * @param player username
     * @return true if user hasn't been registered before
     */
    public static String sendResgister(Player player)
    {
        connect();
        
        String toSend = "Register#"+player.getUser()+"#"+player.getFirst_name()+"#"+player.getLast_name()+"#"+player.getPassword()+"#"+player.getEmail()+"#"+player.getRank()+"#"+player.getAge();
        
        
        
         
         String receivedReply;
        
        System.out.println(toSend);
        
        sc.send(toSend);
                           
        receivedReply = sc.receive(); 
        System.out.println("passou 5");
        System.out.append(receivedReply);
        disconnect();
        if("ERRO".equals(receivedReply))
            System.out.println(" just erro" );
        if("clean".equals(receivedReply))
        return "falhou_a_conexao";
        else return receivedReply;
    } 
    /**
     * Join user to the game.
     * @param username username 
     * @param boats list of coordinates of boats
     * @return success if the user is connected to the game.
     */
     public static String sendUserToGame(String username, String boats){
        connect();
        String toSend = "StartGame#"+username+"#"+boats;
        String receivedReply;
        System.out.println(toSend);
        sc.send(toSend);
                           
        receivedReply = sc.receive();// you will receive OK or FAILL
        disconnect();
        if(receivedReply.equals("Connected2"))
            return "Connected2";
        else return "Connected1";
       
     } 
     
     
     /**
      * Make a shot.
      * @param playerNumber the username
      * @param x x coordinate of shot
      * @param y y coordinate of shot
      * @return true if the shoot was correct, false if missed
      */
     public static Boolean shoot(String playerNumber, Integer x, Integer y){
          connect();
        String toSend = "Shoot#"+playerNumber+"#"+x+y;
        String receivedReply;
        System.out.println(toSend);
        sc.send(toSend);
                           
        receivedReply = sc.receive();// you will receive OK or FAILL
        disconnect();
        if(receivedReply.equals("YES")){
            System.out.println("odpowedz");
            return true;
            }else{
        return false;
        }
     }
     
     /**
      * Check if this is the turn of the player.
      * @param playerNumber username 
      * @return the name of the player that the turn is.
      */
     public static String checkMyTurn(String playerNumber){
     
         connect();
        String toSend = "Turn#"+playerNumber+"#"+"adads";
        String receivedReply;
        System.out.println(toSend);
        sc.send(toSend);
                           
        receivedReply = sc.receive();// you will receive OK or FAILL
        disconnect();
        if(receivedReply.equals("player2")){
            System.out.println("odpowedz");
            return "player2";}
        else return "player1";
     
     }
}
        
      