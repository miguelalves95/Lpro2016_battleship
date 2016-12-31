/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player_GUI;

import java.awt.Color;
import java.awt.Rectangle;
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
   private JPanel[][] panels = new JPanel[10][10];
   private Integer[][] buttonsInt = new Integer[18][18];
   
   private Integer previousX = 0;
   private Integer previousY = 0;
                                             
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
     * Creates new form boardTrt
     */
    public boardTrt() {
        this.getContentPane().removeAll();
        initComponents();
        setSize(1200,600);
        setLocationRelativeTo(null);
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
        
        for(int x=0;x<10;x++){
            for(int y=0;y<10;y++){
               
                panels[x][y] = new javax.swing.JPanel();
                Integer iks = x;
                Integer ygreg = y;

                jPanel3.add(panels[x][y]);
            }
        }
        
       // initialize();

    }
    
      private void fifthPartOfShip(Integer x, Integer y){
         
           x= x+4;
        y= y+4;
          
         if(buttonsInt[x][y] == 0){
             if(vertical == true){
             
             if((previousX+1 == x && previousY == y) || (previousX-4 == x && previousY == y)){
            buttonsInt[x][y] = 2;
           buttons[x-4][y-4].setBackground(Color.orange);
            previousX = x;
            previousY = y;
            fifthFinished = true;
         } else{
        if((previousX-1 == x && previousY == y) || (previousX+4 == x && previousY == y)){
            buttonsInt[x][y] = 2;
           buttons[x-4][y-4].setBackground(Color.orange);
            previousX = x;
            previousY = y;
           fifthFinished = true;
         }else{}}} if(horizontal == true){
       
        if((previousX == x && previousY+1 == y) || (previousX == x && previousY-4 == y)){
            buttonsInt[x][y] = 2;
            buttons[x-4][y-4].setBackground(Color.orange);
            previousX = x;
            previousY = y;
            
           fifthFinished = true;
         }else{
         if((previousX == x && previousY-1 == y) || (previousX == x && previousY+4 == y)){
            buttonsInt[x][y] = 2;
            buttons[x-4][y-4].setBackground(Color.orange);
            previousX = x;
            previousY = y;
            fifthFinished = true;
                         }else{
         
                        }   
                    }
                } 
         else{
             
         }
          
     }}private String getID() { //jesli pierwszy return server jesli drugi return client
		return  "ID_CLIENT" ;//: "ID_SERVER";
	}
    
    
     private void fourthPartOfShip(Integer x, Integer y){
         
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
    
     private void thirdPartOfShip(Integer x, Integer y){
         
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
     
     private void secondPartOfShip(Integer x, Integer y){
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
                        buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
                firstFinished = true;
                        }else{
                        System.out.print("jakas lipa2");
                        }
                    }else{ 
                        if(y-4 == 9){
                            if(buttonsInt[x][y] == 0 && buttonsInt[x-1][y] == 0 && buttonsInt[x][y-1] == 0){
                             buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
                firstFinished = true;
                            }else{
                             System.out.println("jakas lipa4");
                            }
                        }else{ // yrandomowe
                              if(buttonsInt[x][y] == 0 && buttonsInt[x-1][y] == 0 && buttonsInt[x][y-1] == 0
                                      && buttonsInt[x][y+1] == 0){
                             buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
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
                        buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
                firstFinished = true;
                        }else{
                        System.out.print("jakas lipa2");
                        }
                    }else{ 
                        if(y-4 == 9){
                            if(buttonsInt[x][y] == 0 && buttonsInt[x+1][y] == 0 && buttonsInt[x][y-1] == 0){
                             buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
                firstFinished = true;
                            }else{
                             System.out.println("jakas lipa4");
                            }
                        }else{ // yrandomowe
                              if(buttonsInt[x][y] == 0 && buttonsInt[x+1][y] == 0 && buttonsInt[x][y-1] == 0
                                      && buttonsInt[x][y+1] == 0){
                             buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
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
                              buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
                firstFinished = true;
                             }else{
                             
                             }
                        }else{// y nie jest 9
                            if(y-4 == 0){
                                if(buttonsInt[x][y] == 0 && buttonsInt[x+1][y] == 0 && buttonsInt[x-1][y] == 0
                                      && buttonsInt[x][y+1] == 0){
                                 buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
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
                 buttonsInt[x-4][y] != 0      &&            // 2kierunek78
                  buttonsInt[x][y+4] != 0       &&            //3kierunek
                   buttonsInt[x][y-4] != 0                  //4kierunek
                ){
        System.out.println("jakas lipa");
        }else{ 
                 if(buttonsInt[x][y] == 0 && buttonsInt[x+1][y] == 0 && buttonsInt[x-1][y] == 0 && buttonsInt[x][y+1]  == 0 
                && buttonsInt[x][y-1] == 0){
                buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
                firstFinished = true;
                }else{
                //pole zajete
                }
            }
            }
        }
    }
        
       private void firstPartOfSecondShip(Integer x, Integer y){
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
                        buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
                firstFinished = true;
                        }else{
                        System.out.print("jakas lipa2");
                        }
                    }else{ 
                        if(y-4 == 9){
                            if(buttonsInt[x][y] == 0 && buttonsInt[x-1][y] == 0 && buttonsInt[x][y-1] == 0){
                             buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
                firstFinished = true;
                            }else{
                             System.out.println("jakas lipa4");
                            }
                        }else{ // yrandomowe
                              if(buttonsInt[x][y] == 0 && buttonsInt[x-1][y] == 0 && buttonsInt[x][y-1] == 0
                                      && buttonsInt[x][y+1] == 0){
                             buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
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
                        buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
                firstFinished = true;
                        }else{
                        System.out.print("jakas lipa2");
                        }
                    }else{ 
                        if(y-4 == 9){
                            if(buttonsInt[x][y] == 0 && buttonsInt[x+1][y] == 0 && buttonsInt[x][y-1] == 0){
                             buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
                firstFinished = true;
                            }else{
                             System.out.println("jakas lipa4");
                            }
                        }else{ // yrandomowe
                              if(buttonsInt[x][y] == 0 && buttonsInt[x+1][y] == 0 && buttonsInt[x][y-1] == 0
                                      && buttonsInt[x][y+1] == 0){
                             buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
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
                              buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
                firstFinished = true;
                             }else{
                             
                             }
                        }else{// y nie jest 9
                            if(y-4 == 0){
                                if(buttonsInt[x][y] == 0 && buttonsInt[x+1][y] == 0 && buttonsInt[x-1][y] == 0
                                      && buttonsInt[x][y+1] == 0){
                                 buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
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
                buttonsInt[x][y] = 1;
                buttons[x-4][y-4].setBackground(Color.red);
                previousX = x;
                previousY = y;
                firstFinished = true;
                }else{
                //pole zajete
                }
            }
            }
        }
    }    
    
    
    private void funkcjaTakaSamaDlaWszystkichGuzikowTylkoZabierzXY(java.awt.event.ActionEvent evt, Integer x, Integer y){
        System.out.println(x);
        System.out.println("dabadaba");
        buttons[7][7].setBackground(Color.black);
        
        if(firstFinished == false){
            buttons[x][y].setBackground(Color.DARK_GRAY);
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
        }else{
        }
        if(shootPossible == true){
        }else{}
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 530, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(288, 288, 288))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
     this.getContentPane().removeAll();
        initComponents();
        setSize(1200,600);
        setLocationRelativeTo(null);
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
        
        for(int x=0;x<10;x++){
            for(int y=0;y<10;y++){
               
                panels[x][y] = new javax.swing.JPanel();
                Integer iks = x;
                Integer ygreg = y;

                jPanel3.add(panels[x][y]);
            }
        }
      
        getStart();
        /*
        boardTrt ui = this;

        new Thread(){
            @Override
            public void run(){
                ui.disableAll();
                //Boolean orientation;
                //Position startingPoint;
                String wordToPlace; //place to shoot
                Tile[] tilesToShuffle;
                Boolean tmp;

                //orientation = ui.jRadioButton2.isSelected();

                Integer row = ui.boardTable.getSelectedRow();
                Integer col = ui.boardTable.getSelectedColumn();
                startingPoint = (Position)ui.boardTable.getModel().getValueAt(row, col);

                wordToPlace = ui.jTextField1.getText();

                tilesToShuffle = null;

                tmp = ui.play.submeter(orientation, startingPoint, wordToPlace, tilesToShuffle);

                if (!tmp){
                    JOptionPane.showMessageDialog(null, "Jogada inválida, tente outra vez!");
                    ui.enableAll();
                }
            }
        }.start();*/
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

private void disableAll(){
        
        for(int x=0;x<18;x++){
            for(int y=0;y<18;y++){
                this.buttons[x][y].setEnabled(false);
                jButton4.setEnabled(false);
            }
    }
}

private enum RodzajWiadomosci {
		WIADOMOSC_POZYTYWNA, WIADOMOSC_NEUTRALNA, WIADOMOSC_NEGATYWNA
	}
/*public boolean sendMessage(GameEvent ge) {
		if (client != null && client.isAlive()) {
			ge.setPlayerId(getID());
			client.sendMessage(ge);
			return true;
		} else {
			return false;
		}
	}*/

private void getStart() {
   //create new game
		
						
		} 
					
				
			
		
	
	
private void zmienStatus(String wiadomosc, RodzajWiadomosci rodzaj) {
		Color color;
		if (rodzaj == RodzajWiadomosci.WIADOMOSC_POZYTYWNA)
			color = new Color(196, 255, 196);
		else if (rodzaj == RodzajWiadomosci.WIADOMOSC_NEGATYWNA)
			color = new Color(255, 196, 196);
		else
			color = new Color(255, 255, 196);
		status.setBackground(color);
		status.setText("");
		status.append(wiadomosc);
	}

private void initialize() {
	
		new Thread() {
			@Override
			public void run() {
				while (true) {
						processMessages();
					 
				}
			}
		}.start();
	}

private void processMessages() {
		//if client receive message =! null
	}

}