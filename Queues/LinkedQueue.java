package Queues;

public class LinkedQueue implements Queues{
    private static class Node {
        Object data;
        Node prev = this, next = this; 

        Node(Object data) {
            this.data = data;
        }

        Node(Object data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private int size;
    private Node head = new Node(null);

    public int size() {
        return size;
    }

    public Object first() {
        if (size == 0) throw new IllegalStateException("Queue is empty"); 
        return head.next.data; 
    }

    public void enqueue(Object obj) {
        ++size;
        head.prev.next = new Node(obj, head.prev, head);
        head.prev = head.prev.next;
    }

    public Object dequeue() {
        if (size == 0) throw new IllegalStateException("Queue is empty"); 
        
        --size; 

        Object temp = head.next.data; 
        head.next = head.next.next; 
        head.next.prev = head; 
        return temp;
    }

    // LinkedQueue ka Data dekhne ke liye
    public String toString() {
        if (size == 0) {
            return "Queue is Empty []";
        }
        
        String result = "Front -> [ ";
        
        // Guard ke theek aage wale asli bande se shuru karo
        Node p = head.next; 
        
        // Jab tak ghoom kar wapas Guard (head) par na aajao, chalte raho
        while (p != head) {
            result += p.data;
            
            if (p.next != head) { // Agar agla banda Guard nahi hai, toh comma lagao
                result += ", ";
            }
            p = p.next; // Agle bande par jao
        }
        result += " ] <- Rear";
        
        return result;
    }
}
