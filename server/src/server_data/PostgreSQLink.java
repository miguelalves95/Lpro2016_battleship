/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_data;

import java.sql.*;
import java.util.logging.*;


/**
 * Class that is responsible for helding the session with database.
 * @author miguel
 */
public class PostgreSQLink { 
    private static boolean connected = false;
    private static Connection connection = null;
    
   public static boolean isConnected() {
        return connected;
    }

    public static Connection getConnection() {
        return connection;
    }

    
    public static void setConnected(boolean connected) {
        PostgreSQLink.connected = connected;
    }
    
    /**
     * See if it is connected.
     * If it is not, start the connection, if it is true the boolean connected, but gives the value of false 
     */
    void connect (){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostgreSQLink.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (connected==false)
                connection = DriverManager.getConnection("jdbc:postgresql://dbm.fe.up.pt/lpro1621", "lpro1621", "I!3716mwd");
            connected = true;
        } catch (SQLException ex) {
            System.out.println("erro no postgree server");
            Logger.getLogger(PostgreSQLink.class.getName()).log(Level.SEVERE, null, ex);
            connected = false;
        }
    }
    
    /**
     * Try to clear the database connection correctly
     * Assigns the value of false to connected variable
     */
    void close(){
        connected = false;
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLink.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
