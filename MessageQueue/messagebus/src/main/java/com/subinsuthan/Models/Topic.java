package main.java.com.subinsuthan.Models;

@Getter
public class Topic {

    private final  String id;

    private final String name;

    private  final List<Message> messages;

    private final List<Subscriber> subscribers;


    public Topic(String id, String name){
        this.id=id;
        this.name=name;
        this.messages=new ArrayList<>();
        this.subscribers=new ArrayList<>();
    }

    
    
}
