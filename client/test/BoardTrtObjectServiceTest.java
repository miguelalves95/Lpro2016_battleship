/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.Test;
import org.junit.Assert;
import player_GUI.boardTrt;




public class BoardTrtObjectServiceTest {
    @Test
    public void shouldCreateABoardTrtObjectAndReturnUserID(){
     
    String playerId = "ID_SERVER";
    String wrongPlayerId = "qwerty";
    boardTrt game = new boardTrt();
    Assert.assertTrue(game.getID().equals(playerId));
    
    }
}
