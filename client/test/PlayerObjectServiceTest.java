/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.Test;
import org.junit.Assert;
import client_bl.Player;

/**
 *
 * @author Inez
 */
public class PlayerObjectServiceTest {
    
    @Test
    public void shouldCreateAPlayerAndReturnName(){
        
    String name = "player1";
    String first_name;
    String last_name;
    String password;
    String email;
    Integer rank;
    Integer age;
    
    Player player1 = new Player(name, "in", "ub", "qwerty", "asd@as.ss", 123, 16);
    
    Assert.assertTrue(player1.getUser().equals(name));
    }
}

