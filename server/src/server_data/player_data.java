/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_data;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import server_data.PostgreSQLink.*;

/**
 * 
 * This class is responsible for connection with database. It holds all information about the user.
 */
    public class player_data extends PostgreSQLink{
   
    private final String user;
    private String first_name="";
    private String last_name="";
    public  String password="";
    private String email="";
    private Integer rank=0;
    private Integer age=0;
/**
 * Constuctor of the class for the user that already exists in database, sets the username to user
 * @param user username of the user
 */
    public player_data(String user) {
        this.user = user;
        this.getLine();
     
    }
    /**
     * Constuctor of the class for the user that is not yet existing in the database, set the properties of the user
     * @param user username of user
     * @param first_name first name of user
     * @param last_name last name of user
     * @param password password created by user
     * @param email email given by user
     * @param rank ranking of user, by default equal 0 
     * @param age age of user, by default equal 0
     */
    public player_data(String user, String first_name,  String last_name,  String password,  String email, Integer rank,  Integer age ) {
        this.user = user;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.rank = rank;
        this.age = age;
        
    }
    
   /**
    * Get an email of an user.
    * @return email of an user 
    */
    public String getEmail() {
        return email;
    }
/**
    * Get first name of an user.
    * @return first name of an user 
    */
    public String getFirst_name() {
        return first_name;
    }
/**
    * Get the last name of an user.
    * @return last name of an user 
    */
    public String getLast_name() {
        return last_name;
    }
    /**
    * Get the username of an user.
    * @return username of an user 
    */
   public String getUser() {
        return user;
    }
   /**
    * Get the password of an user.
    * @return password of an user 
    */
    public String getPassword() {
        return password;
    }
    /**
    * Get the ranking number of an user.
    * @return ranking number of an user 
    */
    public Integer getRank() {
        return rank;
    }
    /**
     * Set the value of an user email
     * @param email user email
     */
    public void setEmail(String email) {
        this.email = email;
    }
     /**
      * Set the last name of the user
      * @param last_name last name of user
      */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    /**
     * Set the first name of the user
     * @param first_name first name of user
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
/**
 * Set the password of the user
 * @param password password of user
 */
    public void setPassword(String password) {
        this.password = password;
    }
/**
 * Set the ranking number of user
 * @param rank ranking number of user
 */
       public void setRank(Integer rank) {
        this.rank = rank;
    }
    
    /**
     * Method that obtain the password of user from database, that later can be compared with the password given by user to log in.
     */
    public void getLine(){

        if (!isConnected())
            connect();
        
        try {
            Statement statement = getConnection().createStatement();
            ResultSet results = statement.executeQuery("SELECT \"id\",\"firstname\",\"lastname\",\"email\",\"user_name\",\"password\",\"rank\" FROM \"player\" WHERE \"user_name\" = '"+this.user+"'");
           
            if (results.next()){
                   this.password = results.getString("password");
                            }
             
        } catch (Exception ex) {
            System.out.println("You are not reading from the database in Player_DATA");
            Logger.getLogger(player_data.class.getName()).log(Level.SEVERE, null, ex);
        }

    }   
    /**
     * The method that insert information into database to register user.
     * @return "registed with sucess" if the user is registered successfully or "error" if an error occured.
     */
    public String putLine(){

        if (!isConnected()){
            connect();
        }    
   
  
        try {
             Statement statement = getConnection().createStatement();
             String sql="SELECT user_name FROM player WHERE user_name='"+this.user+"'";
             ResultSet results=statement.executeQuery(sql);
             if(results.next()) { 
               return "Is already a registed with this user";}
                  
                   
                 
                   statement.executeUpdate("INSERT INTO player(firstname, lastname, email, user_name, password, rank) VALUES ('"+ first_name +"','"+ last_name +"','"+ email + "','" + user+ "','"+ password + "'," + rank +")");
                    return "registed with sucess";
           
            
        
            }catch (Exception ex) {
                   System.out.println(ex);

                    }
        return "erro";

 


 }
}




