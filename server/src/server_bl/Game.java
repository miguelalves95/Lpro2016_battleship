/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_bl;

/**
 *The class to create and store all information about the game.
 * @author Inez 
 */
public class Game {
    public String player1;
    public String player2;
    public Boolean player1connected;
    public Boolean player2connected;
    public String turn;
    private String[] player1Board = new String[15];
    private String[] player2Board = new String[15];
  protected static Game shared = new Game();
   
    /**
     * The constructor of the class that can be used just inside of the class.
     */
     private Game(){ //game id
       this.player1connected = false;
       this.player2connected = false;
       turn = "player1";
     }
     /**
      * Checking if any user if already in the game. Adding users if false.
      * @param username username of user
      * @return false if just one player is connected, return true if both users are connected and the game can be started.
      */
     public Boolean noPlayers(String username){
     if(shared.player1connected == true){
         shared.player2 = username;
          return false;
     }else{
         shared.player1 = username;
         shared.player1connected = true;
         return true;
     }
     }
     /**
      * Check whose turn it is.
      * @param user username of user
      * @return true if this is the turn of player that sent the request. False in the opposite case.
      */
     public Boolean myTurn(String user){
     if(shared.turn.equals(user) == false){
     return false;
     }else{
     return true;
     }
     }
     /**
      * Ckeck if the shot was correct or missed
      * @param shot the coordinates of shot
      * @return true if shooted, false if missed
      */
     public Boolean shot(String shot){
     if(shared.turn.equals("player1") == true){
         
         shared.turn = "player2";
     return checkBoard("player1", shot);
     }else{
         shared.turn = "player1";
     return checkBoard("player2", shot);
     }
     }
     /**
      * Check if the player shoot is inside opponents board
      * @param user username of player who shoot
      * @param shot the coordinates of shoot
      * @return true if the shot is inside the board, false if the shot is missed.
      */
     public Boolean checkBoard(String user, String shot){
         Boolean result = false;
     if(user.equals("player1")){
         for(int i =0; i <15; i++){
             if(shared.player2Board[i].equals(shot)){
             result = true;
             }
         }
     }else{
       for(int i =0; i <15; i++){
             if(shared.player1Board[i].equals(shot)){
             result = true;
             }
         }
     }
      return result; 
     }
     
     /**
      * Save the board of player on server.
      * @param user username of whose the board is.
      * @param boats coordinates of placed boats.
      * @return true if the board was saved succesfully.
      */
     public Boolean setBoard(String user, String boats){
       
        String[] ships;
        ships= boats.split("@");
         
         if(user.equals("player1")){
   
             shared.player1Board = ships;
            
         
         }else{
         
            shared.player2Board = ships;
        }
     
        
         return true;
     }
     /**
      * Get object of the game
      * @return the shared object of the game
      */
     public static Game getObject()
    {
        return shared;
    }
}
