package chatapp;


public class Person {
    String puid;
    
    public Person(String id){
        this.puid = id;
    }
    
    public void setPuid(String p){
        this.puid = p;
    }
    
    public String getPuid(){
        return this.puid;
    }
    
}