package chatapp;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {    
    String message1 = "";
    String message2 = "";

    public static void main(String[] args) {
        ChatServer cs = new ChatServer();
        cs.runChatServer();
    }
    
    public  void runChatServer(){
        try {
            ServerSocket s = new ServerSocket(8191); //the server socket 
            boolean over = false;
            
            while (!over) {
                Socket incoming = s.accept(); //accept a connection from a client 
                System.out.println("Connection Established");
                try {
                    InputStream inStream = incoming.getInputStream(); // the INPUT stream handler 
                    OutputStream outStream = incoming.getOutputStream(); // the OUTPUT stream handler
                    Scanner in = new Scanner(inStream); //setup of input 
                    PrintWriter out = new PrintWriter(outStream, true); // sends output

                    message1 = in.nextLine().trim();
                    
                    if(message1.equals("Receive button pressed")){
                        out.println(message2);
                    }else if(message1.equals("Bye!") || message2.equals("Bye!")){
                        System.out.println("The chat session has ended");
                        System.exit(0);
                    }
                    else{
                        message2 = message1;
                    }
                } catch (Exception exc1) {
                    exc1.printStackTrace();
                }
            }
        } catch (Exception exc2) {
            exc2.printStackTrace();
        }
    }
}