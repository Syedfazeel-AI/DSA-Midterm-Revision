package Stacks;

public class LinkedStack implements Stacks {
    private int size;
    private Node top;

    private static class Node {
        Object data;
        Node next;
        
        Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (size == 0) throw new IllegalStateException("Stack is empty");
        return top.data;
    }

    public void push(Object obj) {
        top = new Node(obj, top); 
        ++size;
    }

    public Object pop() {
        if (size == 0) throw new IllegalStateException("Stack is empty");
        Object temp = top.data;
        top = top.next; 
        --size;
        return temp;
    }

    // LinkedStack ka Data dekhne ke liye
    public String toString() {
        if (size == 0) {
            return "Stack is Empty []";
        }
        
        String result = "Top -> [ ";
        Node p = top;
        
        while (p != null) {
            result += p.data; // Data string mein jora
            if (p.next != null) {
                result += ", "; // Beech mein comma lagane ke liye
            }
            p = p.next; // Pointer ko aage barhaya
        }
        result += " ]";
        
        return result;
    }
}
