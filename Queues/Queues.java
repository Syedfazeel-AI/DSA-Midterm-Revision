package Queues;

public interface Queues {
    public int size();
    public Object first();
    public void enqueue(Object obj); 
    public Object dequeue();
}