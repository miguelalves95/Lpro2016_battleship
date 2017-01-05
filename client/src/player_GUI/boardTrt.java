/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player_GUI;
import client_bl.*;
import client_conection.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
/**
 *
 * @author Inez
 */
public class boardTrt extends javax.swing.JFrame {
    
   // private Client client = null;

   public JButton[][] buttons = new JButton[10][10];
   public JButton[][] buttons2 = new JButton[10][10];
   private JPanel[][] panels = new JPanel[10][10];
   private Integer[][] buttonsInt = new Integer[18][18];
   private String stringOfboats = "";
   private Boolean MyTurn = false;
   
   private String playerNumber;
   private String playerNumber1 = "player1";
   
   private Integer previousX = 0;
   private Integer previousY = 0;
   
    private Boolean unoFinished = false;
     private Boolean dosFinished = false;
      private Boolean tresFinished = false;
       private Boolean quartoFinished = false;
        private Boolean cincoFinished = false;
                                             
    private Boolean firstFinished = false;
    private Boolean secondFinished = false;
    private Boolean thirdFinished = false;
    private Boolean fourthFinished = false;
    private Boolean fifthFinished = false;
    
    private Boolean next1stFinished = false;
    
    private Boolean vertical = false;
    private Boolean horizontal = false;
   
    private Boolean shootPossible = false;
    private Boolean clientStarted = false;
    /**
     * Creates new form boardTrt, constructor of the class.
     */
    public boardTrt() {
        this.getContentPane().removeAll();
        initComponents();
        setSize(1200,600);
        setLocationRelativeTo(null);
        jButton4.setEnabled(false);
            this.jButton4.setBackground(Color.red);
        for(int x=0;x<18;x++){
            for(int y=0;y<18;y++){
                if((x>3 && x<14) && (y>3 && y<14)){
                buttonsInt[x][y] = 0;
                System.out.print(buttonsInt[x][y]);
                }else{
                buttonsInt[x][y] = 1;
                System.out.print(buttonsInt[x][y]);
                }
            }
            System.out.println("");
           
        }
        
        for(int x=0;x<10;x++){
            for(int y=0;y<10;y++){
               
                buttons[x][y] = new javax.swing.JButton("");
                Integer iks = x;
                Integer ygreg = y;
                buttons[x][y].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funkcjaTakaSamaDlaWszystkichGuzikowTylkoZabierzXY(evt, iks, ygreg);
            }
        });
                jPanel2.add(buttons[x][y]);
            }
        }
        
        /*for(int x=0;x<10;x++){
            for(int y=0;y<10;y++){
               
                panels[x][y] = new javax.swing.JPanel();
                Integer iks = x;
                Integer ygreg = y;

                jPanel3.add(panels[x][y]);
            }
        }*/
      
    }
    
    
    
    /**
     * Enable to put the 4th part of the boat on the board if the logic of the game validates.
     * @param x x coordinate
     * @param y y coordinate
     */
     private void fourthPartOf2Ship(Integer x, Integer y){
         
          x= x+4;
          y= y+4;
         if(buttonsInt[x+1][y] != 0 &&     //1kierunek
                 buttonsInt[x-1][y] != 0      &&            // 2kierunek
                  buttonsInt[x][y+1] != 0       &&            //3kierunek
                   buttonsInt[x][y-1] != 0                  //4kierunek
                ){
        System.out.println("jakas lipa");
        }else{ 
         if(buttonsInt[x][y] == 0){
             if(vertical == true){
             
             if((previousX+1 == x && previousY == y) || (previousX-3 == x && previousY == y)){
            buttonsInt[x][y] = 2;
            buttons[x-4][y-4].setBackground(Color.pink);
            previousX = x;
            previousY = y;
            fourthFinished = true;
         } else{
        if((previousX-1 == x && previousY == y) || (previousX+3 == x && previousY == y)){
            buttonsInt[x][y] = 2;
            buttons[x-4][y-4].setBackground(Color.pink);
            previousX = x;
            previousY = y;
           fourthFinished = true;
         }else{}}} if(horizontal == true){
       
        if((previousX == x && previousY+1 == y) || (previousX == x && previousY-3 == y)){
            buttonsInt[x][y] = 2;
            buttons[x-4][y-4].setBackground(Color.pink);
            previousX = x;
            previousY = y;
            
           fourthFinished = true;
         }else{
         if((previousX == x && previousY-1 == y) || (previousX == x && previousY+3 == y)){
            buttonsInt[x][y] = 2;
            buttons[x-4][y-4].setBackground(Color.PINK);
            previousX = x;
            previousY = y;
            fourthFinished = true;
                         }else{
         
                        }   
                    }
                } 
         else{
             
         }
         } 
     }}
     
     /**
      * Enable to put the 3th part of the boat on the board if the logic of the game validates.
      * @param x x coordinate 
      * @param y y coordinate
      */
    
     private void thirdPartOf2Ship(Integer x, Integer y){
         
          x= x+4;
          y= y+4;
         
          if(buttonsInt[x+2][y] != 0 &&     //1kierunek
                 buttonsInt[x-2][y] != 0      &&            // 2kierunek
                  buttonsInt[x][y+2] != 0       &&            //3kierunek
                   buttonsInt[x][y-2] != 0                  //4kierunek
                ){
        System.out.println("jakas lipa");
        }else{ 
         if(buttonsInt[x][y] == 0){
             if(vertical == true){
             
             if((previousX+1 == x && previousY == y) || (previousX-2 == x && previousY == y)){
            buttonsInt[x][y] = 2;
            buttons[x-4][y-4].setBackground(Color.green);
            previousX = x;
            previousY = y;
            if(secondFinished == true){
            thirdFinished = true;
            }
            secondFinished = true;
         } else{
        if((previousX-1 == x && previousY == y) || (previousX+2 == x && previousY == y)){
            buttonsInt[x][y] = 2;
            buttons[x-4][y-4].setBackground(Color.green);
            previousX = x;
            previousY = y;
            if(secondFinished == true){
            thirdFinished = true;
            }
            secondFinished = true;
         }else{}}} if(horizontal == true){
       
        if((previousX == x && previousY+1 == y) || (previousX == x && previousY-2 == y)){
            buttonsInt[x][y] = 2;
            buttons[x-4][y-4].setBackground(Color.green);
            previousX = x;
            previousY = y;
            thirdFinished = true;
            secondFinished = true;
            if(secondFinished == true){
            
            }
         }else{
         if((previousX == x && previousY-1 == y) || (previousX == x && previousY+2 == y)){
            buttonsInt[x][y] = 2;
            buttons[x-4][y-4].setBackground(Color.green);
            previousX = x;
            previousY = y;
            if(secondFinished == true){
            thirdFinished = true;
            }
            secondFinished = true;
                         }else{
         
                        }   
                    }
                } 
         else{
             
         }
         }
     }}
     /**
      * Enable to put the 5th part of the boat on the board if the logic of the game validates.
      * @param x x coordiante
      * @param y y coordinate
      */
     private void fifthPartOfShip(Integer x, Integer y){
         x= x+4;
      y= y+4;
      
       if(buttonsInt[x][y]==0){
          if(horizontal){
              if(previousY == y){
          if(previousX == x+1 || previousX == x-1 || previousX == x-4 || previousX == x+4   ){
                  putBoat1(x,y);
                  fifthFinished = true;   
              }}else{}
          }else{
              if(previousX == x){
           if(previousY == y+1 || previousY == y-1 || previousY == y-4 || previousY == y+4  ){
                   putBoat1(x,y);
                   fifthFinished = true;
              }}else{}
          } 
      }else{}
     }
     /**
      * Enable to put the 4th part of the boat on the board if the logic of the game validates.
      * @param x x coordinate
      * @param y y coordinate
      */
     private void fourthPartOfShip(Integer x, Integer y){
            x= x+4;
      y= y+4;
      
 if(buttonsInt[x][y]==0){
          if(horizontal){
              if(previousY == y){
          if(previousX == x+1 || previousX == x-1 || previousX == x-3 || previousX == x+3   ){
                  putBoat1(x,y);
                  fourthFinished = true;   
              }}else{}
          }else{
              if(previousX == x){
           if(previousY == y+1 || previousY == y-1 || previousY == y-3 || previousY == y+3  ){
                   putBoat1(x,y);
                   fourthFinished = true;
              }}else{}
          }
          
        
          
          
      }else{}
     }
     /**
      * Enable to put the 3th part of the boat on the board if the logic of the game validates.
      * @param x x coordinate
      * @param y y coordinate
      */
     private void thirdPartOfShip(Integer x, Integer y){
       x= x+4;
      y= y+4;
      
      if(buttonsInt[x][y]==0){
          if(horizontal){
              if(previousY == y){
          if(previousX == x+1 || previousX == x-1 || previousX == x-2 || previousX == x+2   ){
                  putBoat1(x,y);
                  thirdFinished = true;   
              }}else{}
          }else{
              if(previousX == x){
           if(previousY == y+1 || previousY == y-1 || previousY == y-2 || previousY == y+2 ){
                   putBoat1(x,y);
                   thirdFinished = true;
              }}else{}
          }       
      }else{}
      
     }
     /**
      * Enable to put the 2nd part of the boat on the board if the logic of the game validates.
      * @param x x coordinate
      * @param y y coordinate
      */
      private void secondPartOfShip(Integer x, Integer y){
      x= x+4;
      y= y+4;
      
      if(buttonsInt[x][y]==0){
          if(previousY == y){
              if(previousX == x+1 || previousX == x-1 ){
                  putBoat1(x,y);
                  secondFinished = true;
                   horizontal = true;
                  
              }
          }else if (previousX == x){
              if(previousY == y+1 || previousY == y-1 ){
                   putBoat1(x,y);
                   secondFinished = true;
                   vertical = true;
              }
          }else{}
      }else{}
      
      }
     
     /**
      * Enable to put the 2nd part of the boat on the board if the logic of the game validates.
      * @param x x coordinate
      * @param y y coordinate
      */
     private void secondPartOf2Ship(Integer x, Integer y){
        x= x+4;
        y= y+4;
         
         if(buttonsInt[x+3][y] != 0 &&     //1kierunek
                 buttonsInt[x-3][y] != 0      &&            // 2kierunek
                  buttonsInt[x][y+3] != 0       &&            //3kierunek
                   buttonsInt[x][y-3] != 0                  //4kierunek
                ){
        System.out.println("jakas lipa");
        }else{ 
         if(buttonsInt[x][y] == 0){
         if(previousX+1 == x && previousY == y && buttonsInt[x+1][y] == 0 && buttonsInt[x-3][y] != 0 ){
            buttonsInt[x][y] = 2;
            buttons[x-4][y-4].setBackground(Color.blue);
            previousX = x;
            previousY = y;
            secondFinished = true;
            vertical = true; //czy na pewno
         } else{
        if(previousX-1 == x && previousY == y && buttonsInt[x-1][y] == 0 && buttonsInt[x+3][y] != 0){
            buttonsInt[x][y] = 2;
            buttons[x-4][y-4].setBackground(Color.blue);
            previousX = x;
            previousY = y;
            secondFinished = true;
            vertical = true;
         }else{
        if(previousX == x && previousY+1 == y && buttonsInt[x][y+1] == 0 && buttonsInt[x][y-3] != 0 ){
            buttonsInt[x][y] = 2;
            buttons[x-4][y-4].setBackground(Color.blue);
            previousX = x;
            previousY = y;
            secondFinished = true;
            horizontal = true;
            
         }else{
         if(previousX == x && previousY-1 == y  && buttonsInt[x][y-1] == 0 && buttonsInt[x][y+3] != 0){
            buttonsInt[x][y] = 2;
             buttons[x-4][y-4].setBackground(Color.blue);
            previousX = x;
            previousY = y;
            secondFinished = true;
            horizontal = true;
                         }else{
         
                        }   
                    }
                }
            }
         }
        }
     }
    
     
     
   
    /**
     * Put the boat on the board, make a picture of the boat on the right place in the board
     * @param x x coordinate
     * @param y y coordinate
     */
    private void putBoat1(Integer x, Integer y){
         
         buttonsInt[x][y] = 1;
         System.out.println("teraz"+x+y);
          System.out.println("poprzedniX"+previousX);
         System.out.println("poprzdniY"+previousY);
         previousX = x;
        
         previousY = y;
         ImageIcon icon = new ImageIcon(
    getClass().getResource(
    "resources/boat1.png"));
         
        x= x-4;
        y= y-4;
         if(unoFinished == false){
          icon = new ImageIcon(
    getClass().getResource(
    "resources/boat1.png"));
         }else if(dosFinished == false){
          icon = new ImageIcon(
    getClass().getResource(
    "resources/lodka_zolta.jpg"));
         }else if(tresFinished == false){
      icon = new ImageIcon(
    getClass().getResource(
    "resources/lodka_biala.jpg"));
         }else if (quartoFinished == false){
         icon = new ImageIcon(
    getClass().getResource(
    "resources/lodka_zolta.jpg"));
         }else if(cincoFinished == false){
        icon = new ImageIcon(
    getClass().getResource(
    "resources/boat1.png"));
         }
          
          
     buttons[x][y].setBackground(Color.blue);
     buttons[x][y].setIcon(icon);
     buttons[x][y].setDisabledIcon(icon);
     
    
     }
    
       
        /**
         * Enable to put the 1st part of the boat on the board if the logic of the game validates.
         * @param x x coordinate
         * @param y y coordinate
         */
       private void firstPartOfShip(Integer x, Integer y){
        x= x+4;
        y= y+4;
        
        if(buttonsInt[x+4][y] != 0 &&     //1kierunek
                 buttonsInt[x-4][y] != 0      &&            // 2kierunek
                  buttonsInt[x][y+4] != 0       &&            //3kierunek
                   buttonsInt[x][y-4] != 0                  //4kierunek
                ){
        System.out.println("jakas lipa");
        }else{ 
            if(x-4 == 9 || x-4 == 0 || y-4 == 9 || y-4 == 0){
                if(x-4 == 9){
                    if(y-4 == 0){
                        if(buttonsInt[x][y] == 0 && buttonsInt[x-1][y] == 0 && buttonsInt[x][y+1] == 0){
                         putBoat1(x,y);
                firstFinished = true;
                        }else{
                        System.out.print("jakas lipa2");
                        }
                    }else{ 
                        if(y-4 == 9){
                            if(buttonsInt[x][y] == 0 && buttonsInt[x-1][y] == 0 && buttonsInt[x][y-1] == 0){
                            
                 putBoat1(x,y);
                firstFinished = true;
                            }else{
                             System.out.println("jakas lipa4");
                            }
                        }else{ // yrandomowe
                              if(buttonsInt[x][y] == 0 && buttonsInt[x-1][y] == 0 && buttonsInt[x][y-1] == 0
                                      && buttonsInt[x][y+1] == 0){
                             putBoat1(x,y);
                firstFinished = true;
                            }else{
                             System.out.println("zajete i chuj");
                            }
                        }
                    }
                }
                else{ //iks nie jest 9
                    if(x-4 == 0){  
                    
                          if(y-4 == 0){
                        if(buttonsInt[x][y] == 0 && buttonsInt[x+1][y] == 0 && buttonsInt[x][y+1] == 0){
                        putBoat1(x,y);
                firstFinished = true;
                        }else{
                        System.out.print("jakas lipa2");
                        }
                    }else{ 
                        if(y-4 == 9){
                            if(buttonsInt[x][y] == 0 && buttonsInt[x+1][y] == 0 && buttonsInt[x][y-1] == 0){
                            putBoat1(x,y);
                firstFinished = true;
                            }else{
                             System.out.println("jakas lipa4");
                            }
                        }else{ // yrandomowe
                              if(buttonsInt[x][y] == 0 && buttonsInt[x+1][y] == 0 && buttonsInt[x][y-1] == 0
                                      && buttonsInt[x][y+1] == 0){
                             putBoat1(x,y);
                firstFinished = true;
                            }else{
                             System.out.println("zajete i chuj");
                            }
                        }
                    }
                    }else{//x nie jest ani 0 ani 9
                        if(y-4 == 9){
                             if(buttonsInt[x][y] == 0 && buttonsInt[x+1][y] == 0 && buttonsInt[x-1][y] == 0
                                      && buttonsInt[x][y-1] == 0){
                               putBoat1(x,y);
                firstFinished = true;
                             }else{
                             
                             }
                        }else{// y nie jest 9
                            if(y-4 == 0){
                                if(buttonsInt[x][y] == 0 && buttonsInt[x+1][y] == 0 && buttonsInt[x-1][y] == 0
                                      && buttonsInt[x][y+1] == 0){
                                 putBoat1(x,y);
                firstFinished = true;
                                }else{
                                }
                             }else{ 
                        System.out.println("nie powinno tu dojsc");
                            }
                        }
                    }
                }  
            }else{    
                 if(buttonsInt[x+4][y] != 0 &&     //1kierunek
                 buttonsInt[x-4][y] != 0      &&            // 2kierunek
                  buttonsInt[x][y+4] != 0       &&            //3kierunek
                   buttonsInt[x][y-4] != 0                  //4kierunek
                ){
        System.out.println("jakas lipa");
        }else{ 
                if(buttonsInt[x][y] == 0 && buttonsInt[x+1][y] == 0 && buttonsInt[x-1][y] == 0 && buttonsInt[x][y+1]  == 0 
                && buttonsInt[x][y-1] == 0){
                 putBoat1(x,y);
                firstFinished = true;
                }else{
                //pole zajete
                }
            }
            }
        }
    }    

    
    
      /**
       * Get player ID
       * @return the id of player
       */
      public String getID() { //jesli pierwszy return server jesli drugi return client
	if(playerNumber1 == "player1")	{
            return   "ID_SERVER";
            
        }else{
          return  "ID_CLIENT" ;//: "ID_SERVER";}
	}
    
      }
  
        
     
    private BufferedImage image;
    /**
     * The function of the buttons on the board being clicked. Set the boats and do the shoot if possible.
     * @param evt event of button clicked
     * @param x x coordinate
     * @param y y coordinate
     */
    private void funkcjaTakaSamaDlaWszystkichGuzikowTylkoZabierzXY(java.awt.event.ActionEvent evt, Integer x, Integer y){
     
        if(unoFinished == false){
            
        if(firstFinished == false){
         firstPartOfShip(x,y);
        }
        else if(secondFinished == false){
            secondPartOfShip(x,y);
        }else if(thirdFinished == false){
           thirdPartOfShip(x,y);
        }else if(fourthFinished == false){
            fourthPartOfShip(x,y);
        }else if(fifthFinished == false){
        fifthPartOfShip(x,y);
        unoFinished = true;
        firstFinished = false;
        secondFinished = false;
        thirdFinished = false;
        fourthFinished = false;
        fifthFinished = false;
         vertical = false;
    horizontal = false;
        
        }
        
        }else if(dosFinished == false){
            
        if(firstFinished == false){
         firstPartOfShip(x,y);
        }
        else if(secondFinished == false){
            secondPartOfShip(x,y);
        }else if(thirdFinished == false){
           thirdPartOfShip(x,y);
        }else if(fourthFinished == false){
            fourthPartOfShip(x,y);
        dosFinished = true;
        firstFinished = false;
        secondFinished = false;
        thirdFinished = false;
        fourthFinished = false;
        fifthFinished = false;
         vertical = false;
    horizontal = false;
        }
            
    }else if(tresFinished == false){
        
        if(firstFinished == false){
         firstPartOfShip(x,y);
        }
        else if(secondFinished == false){
            secondPartOfShip(x,y);
        }else if(thirdFinished == false){
           thirdPartOfShip(x,y);
            tresFinished = true; firstFinished = false;
        secondFinished = false;
        thirdFinished = false;
        fourthFinished = false;
        fifthFinished = false;
         vertical = false;
    horizontal = false;
            
        }
        
    }else if(quartoFinished == false){
        
        if(firstFinished == false){
         firstPartOfShip(x,y);
        }
        else if(secondFinished == false){
            secondPartOfShip(x,y);
            quartoFinished = true;
             firstFinished = false;
        secondFinished = false;
        thirdFinished = false;
        fourthFinished = false;
        fifthFinished = false;
         vertical = false;
         horizontal = false;
        }
        
    }else if(cincoFinished == false){
        if(firstFinished == false){
         firstPartOfShip(x,y);
         cincoFinished = true;
         shootPossible = true;
         
         cleanAll();
         disableAll();
         jButton4.setEnabled(true);
         this.jButton4.setBackground(Color.green);
         jLabel2.setText("Your board");
         jLabel1.setText("Opponents board, let's shoot!");
         
         for(int f=0;f<10;f++){
            for(int h=0;h<10;h++){
               
                buttons2[f][h] = new javax.swing.JButton("");
                Integer iks = f;
                Integer ygreg = h;
                jPanel3.add(buttons2[f][h]);
                if(buttonsInt[f+4][h+4] != 0){
                buttons2[f][h].setBackground(Color.blue);
                stringOfboats = stringOfboats + f + h +"@" ;
                }else{
                
                }
            }
        }
         
        }
        
          
    }else{
     if(shootPossible == true){
            if(Protocol.shoot(playerNumber,x,y) == true){
                buttons[x][y].setBackground(Color.red);
                zmienStatus("Shooted!");
                status.setBackground(Color.GREEN);
                  ImageIcon icon = new ImageIcon(
    getClass().getResource(
    "resources/lodka_zolta_2.jpg"));
        
                this.buttons[x][y].setIcon(icon);
                this.buttons[x][y].setDisabledIcon(icon);
            }else{
            buttons[x][y].setBackground(Color.blue);
            zmienStatus("Missed");
              ImageIcon icon = new ImageIcon(
    getClass().getResource(
    "resources/lodka_zolta_3.jpg"));
        
                this.buttons[x][y].setIcon(icon);
                this.buttons[x][y].setDisabledIcon(icon);
            status.setBackground(Color.RED);
            }
            MyTurn = false;  
            shootPossible = false;
        }else{}
    
    }
         
       

     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        status = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 102, 153));
        jPanel2.setLayout(new java.awt.GridLayout(10, 10, 1, 1));

        jPanel3.setBackground(new java.awt.Color(51, 255, 102));
        jPanel3.setLayout(new java.awt.GridLayout(10, 10, 1, 1));

        jLabel1.setText("my Board");

        jLabel2.setText("another Board");

        jButton4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        jButton4.setText("PLAY!");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        status.setColumns(20);
        status.setRows(5);
        jScrollPane1.setViewportView(status);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(288, 288, 288))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton4)
                .addContainerGap(554, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jButton4)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * Function of start game button. Begin the game againt the opponent
 * @param evt click button event
 */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      zmienStatus("waiting for opponent");
    Protocol gameProt= new Protocol();
    if("Connected1".equals(Protocol.sendUserToGame("user1","lipa"))){
    System.out.print("uzytkownik numer 1");
    this.playerNumber = "player1";
    }else{
        this.playerNumber = "player2";
    System.out.print("uzytkowbnik numerr 2");
    }  
    
    System.out.println(stringOfboats);
         Protocol.sendBoard(playerNumber,stringOfboats);
    
        getStart();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(boardTrt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(boardTrt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(boardTrt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(boardTrt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new boardTrt().setVisible(true);
            }
        });
        
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea status;
    // End of variables declaration//GEN-END:variables
/**
 * Disable all buttons while waiting for your turn
 */
private void disableAll(){
        
        for(int x=0;x<10;x++){
            for(int y=0;y<10;y++){
                this.buttons[x][y].setEnabled(false);
            }
           
            jButton4.setEnabled(false);
            this.jButton4.setBackground(Color.red);
    }
}
/**
 * Enable all buttons.
 */
private void enableAll(){
        
        for(int x=0;x<10;x++){
            for(int y=0;y<10;y++){
                this.buttons[x][y].setEnabled(true);
            }
           
           
            
    }
}



/**
 * Start the main thread of the game.
 */
private void getStart() {
   //create new game
   //threaddisableAll()
                disableAll();
                
             new Thread(){
            @Override
            public void run(){
               
		while(true){
                    
                    
                        
                           
                            if("player1".equals(Protocol.checkMyTurn(playerNumber)) == true){
                                MyTurn = true;
                                shootPossible = true;
                                enableAll();
                                zmienStatus("It is your turn!");
                                status.setBackground(Color.green);
                                 System.out.println(" moja kolej");
                                 
                                 
                             }else{
                                disableAll();
                                System.out.println("innakolej");
                                shootPossible = false;
                                zmienStatus("Wait for your turn");
                                status.setBackground(Color.yellow);
                            }   
                             try {
                             Thread.sleep(20*10);
                                } catch(InterruptedException e) {
                                }
                       
                      
                }
               

            }
        }.start();
        } 
	
	/**
         * Change the message in the message window.
         * @param wiadomosc 
         */
private void zmienStatus(String wiadomosc) {
		
		status.setBackground(Color.yellow);
		status.setText("");
		status.append(wiadomosc);
	}
/**
 * Clean all buttons to prepeare the game to shot.
 */
    private void cleanAll() {
        ImageIcon icon = new ImageIcon(
    getClass().getResource(
    "resources/lodka_zolta_1.jpg"));
        
        
       for(int x=0;x<10;x++){
            for(int y=0;y<10;y++){
                this.buttons[x][y].setEnabled(true);
                this.buttons[x][y].setBackground(Color.blue);
                
                this.buttons[x][y].setIcon(icon);
                this.buttons[x][y].setDisabledIcon(icon);
            }
    }
    }

}
