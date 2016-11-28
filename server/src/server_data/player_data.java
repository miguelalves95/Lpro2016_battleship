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
 * @author Miguel
 */ 


    public class player_data extends PostgreSQLink{
   
    private final String user;
    private String first_name="";
    private String last_name="";
    public  String password="";
    private String email="";
    private Integer rank=0;
    private Integer age=0; //-> acrescentar a tabela 
/**
 * PUTAS E VINHO VERDE
 * @param user 
 */
    public player_data(String user) {
        this.user = user;
        this.getLine();
    }
    public player_data(String user, String first_name,  String last_name,  String password,  String email, Integer rank,  Integer age ) {
        this.user = user;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.rank = rank;
        this.age = age;
        
    }
    
   
        public String getEmail() {
        return email;
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
    public String getPassword() {
        return password;
    }
    
    public Integer getRank() {
        return rank;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

       public void setRank(Integer rank) {
        this.rank = rank;
    }
    
    /**
     * O player tem um conjunto de atributos como por exemplo o email o primeiro nome o ultimo nome (...)
     * Os metodos set servem para escrever/alterar o valor do atributo na base de dados, os get servem para obter o valor na base de dados
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
            System.out.println("nao está a ler da base de dados  ERRO no Player_DATA");
            Logger.getLogger(player_data.class.getName()).log(Level.SEVERE, null, ex);
        }

    }   
    public String putLine(){

        if (!isConnected()){
            connect();
        }    
   
  //   Connection con = DriverManager.getConnection();
        try {
             Statement statement = getConnection().createStatement();
             String sql="SELECT user_name FROM player WHERE user_name='"+this.user+"'";
             ResultSet results=statement.executeQuery(sql);
             if(results.next()) { System.out.println("2vez");
               return "Is already a registed with this user";}
                  
                   System.out.println("putas ");
                 
                   statement.executeUpdate("INSERT INTO player(firstname, lastname, email, user_name, password, rank) VALUES ('"+ first_name +"','"+ last_name +"','"+ email + "','" + user+ "','"+ password + "'," + rank +")");
                    return "registed with sucess";
           
            
        
            }catch (Exception ex) {
                   System.out.println(ex);

                    }
        return "erro";

 


 }
}




