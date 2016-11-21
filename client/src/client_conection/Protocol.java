/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_conection;
import client_bl.*;
/**
 *
 * @author miguel
 */
public class Protocol {
    
   inezzz
    private static Sockets sc;
    private static boolean connected = false;
    
   
     //O método connect cria um objecto do tipo Sockets. O construtor estabelece a conexão, alterando-se a variável connected para true
     public static void  disconnect(){
        connected = false;
    }
    
    public static void connect(){
        if (!connected)
            sc = new Sockets();
        connected = true;
        System.out.println("Reception");
         }

    public static boolean isConnected() {
        return connected;
    }
    
    
     //O método sendLogin recebe o user e a password encriptada e mete os numa string.  
     //Envia a string para o server através da função send espera a resposta.
     
 
    public static String sendLogin(String user, String password){
        
       
        
        connect();
        String toSend = "Login#"+user+"#"+password;
        String receivedReply;
        System.out.println(toSend);
        sc.send(toSend);
                           
        receivedReply = sc.receive(); 
        System.out.println(receivedReply);
        System.out.append(receivedReply);
        if("clean".equals(receivedReply))
        return "falhou_a_conexao";
        else return receivedReply;
       }
    public static String sendResgister(Player player)
    {
        connect();
        System.out.print(player.getPassword()+"entrou no sendRegister");
        String toSend = "Register#"+player.getUser()+"#"+player.getFirst_name()+"#"+player.getLast_name()+"#"+player.getPassword()+"#"+player.getEmail()+"#"+player.getRank()+"#"+player.getAge();
        System.out.println("passou 1");
        System.out.println(toSend);
         System.out.println("passou 2");
        
         
         String receivedReply;
         System.out.println("passou 3");
        System.out.println(toSend);
         System.out.println("passou 4");
        sc.send(toSend);
                           
        receivedReply = sc.receive(); 
        System.out.println("passou 5");
        System.out.append(receivedReply);
        if("ERRO".equals(receivedReply))
            System.out.println(" just erro" );
        if("clean".equals(receivedReply))
        return "falhou_a_conexao";
        else return receivedReply;
    }
}
