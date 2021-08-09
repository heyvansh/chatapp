package chatapp;

import java.io.*;
import java.net.*;
import java.util.*;

public class Message {
    String message;
    Person p;
    
    public void sendMessage(){
        try {
            Socket s = new Socket("localhost", 8191);
            try{
                OutputStream out = s.getOutputStream();
                PrintWriter pw = new PrintWriter(out,true);
                pw.println(message);
            }catch(IOException ioe){
                ioe.printStackTrace();
            }finally{
                s.close();
            }
        }catch (IOException ioexc) {
            ioexc.printStackTrace();
        }
    }
    
    public String receiveMessage(){
        String nextMessage = "dnm";
        try {
           Socket s = new Socket("localhost", 8191);
           try{
               OutputStream out = s.getOutputStream();
               PrintWriter pw = new PrintWriter(out,true);
               InputStream in = s.getInputStream();
               Scanner sc = new Scanner(in);
               pw.println("Receive button pressed");
               nextMessage = sc.nextLine();
           }catch(IOException ioe){
               ioe.printStackTrace();
           }finally{
               s.close();
           }
        }catch (IOException ioexc) {
            ioexc.printStackTrace();
        }
        return nextMessage;
    }
    
    public String getMessage(){
        return "";
    }
    
    public void setMessage(String m){
        this.message = m;
    }
    
    public Person getPerson(){
        return this.p;
    }
    
    public void setPerson(Person np){
        this.p = np;
    }
}
