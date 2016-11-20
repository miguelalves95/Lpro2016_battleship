/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_bl;

import server_data.*;

import java.sql.*;

/**
 *
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

    public Player(String user, String password) {
       this.user = user;
       this.password=password;
    }
    
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
    
    public boolean checkPassword(){
        player_data player= new player_data(user);
        return player.getPassword().equals(password);
    }
    
    public String checkRegistered(){
    
   player_data player= new player_data(user, first_name, last_name, password, email, rank, age);
   return player.putLine();
   
   
    }
            
    
    
    
}