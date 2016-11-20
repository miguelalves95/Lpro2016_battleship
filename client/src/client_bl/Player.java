/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_bl;

import client_conection.*;
import java.sql.*;

/**
 *
 * @author miguel
 */
public class Player {
    private final String user;
    private String first_name;
    private String last_name;
    public String password;
    private String email;
    private Integer rank;
    private Integer age;
    
    public Player(String user, String first_name, String last_name, String password, String email, Integer rank, Integer age) {
        this.user = user;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = Criptografia.criptografar(password);
        this.email = email;
        this.rank = rank;
        this.age = age;
       
    }

    //Construtor de um objecto da classe player, recebe diferentes parametros referentes ao player 
      
   
     
    public Player(String user, String password) {
        this.user = user;
        this.password = Criptografia.criptografar(password);
    
        this.rank = 0;
    }
    


    public String getEmail() {
        return email;
    }



    public String getPassword() {
        return password;
    }
    
    public String getFirst_name() {
        return first_name;
    }
     public String getLast_name() {
        return last_name;
    }

    public String getUser() {
        return user;
    }
    public Integer getAge() {
        return age;
    } 
    public Integer getRank() {
        return rank;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setFirt_name(String first_name) {
        this.first_name = first_name;
    }
 public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void setPassword(String password) {
        this.password = Criptografia.criptografar(password);
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    
    
    public boolean comparePasswords(String pass){
        return this.password.equals(Criptografia.criptografar(password));
    }
    
    //*Método vai perguntar ao server se o conjunto do user e password são verdadeiros
     
    public boolean checkLogin(){
        Protocol.connect();
        String check = Protocol.sendLogin(user, password);
        if (check == null)
            return false;
        
        else if (check.equals("falhou_a_conexao")){
            System.err.println("falhou a conexao no checkLogin");
            return false;
        }
        
        else return check.equals("OK");
    }
    
    
}