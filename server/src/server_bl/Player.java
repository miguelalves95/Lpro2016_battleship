/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_bl;

import server_data.*;

import java.sql.*;

/**
 *Class to store all infromation about user and work with it.
 * @author miguel
 */
public class Player {

    private String user="";
    private String password="";
    private String first_name="";
    private String last_name="";
    private String email="";
    private Integer rank=0;
    private Integer age=0; //-> acrescentar a tabela 
/**
 * Class constructor for registered user
 * @param user username of player
 * @param password password of player
 */
    public Player(String user, String password) {
       this.user = user;
       this.password=password;
    }
    /**
     * Class constructor for unregistered user
     * @param user username
     * @param first_name first name
     * @param last_name last name
     * @param password password
     * @param email email
     * @param rank ranking by default equal 0
     * @param age  age by default equal 0
     */
    public Player(String user, String first_name,  String last_name,  String password,  String email, Integer rank,  Integer age ){
        this.user = user;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.rank = rank;
        this.age = age;
        System.out.println(this.user +"playerrrrrrrrrr");
        System.out.println(this.password);
        System.out.println(this.age);
        
    }
    /**
     * Check if the password given by user is correct
     * @return true or false if is password is not valid
     */
    public boolean checkPassword(){
        player_data player= new player_data(user);
        return player.getPassword().equals(password);
    }
    /**
     * Register the player.
     * @return true or false if the registration returned error 
     */
    public String checkRegistered(){
    
   player_data player= new player_data(user, first_name, last_name, password, email, rank, age);
   return player.putLine();
   
   
    }
            
    
    
    
}