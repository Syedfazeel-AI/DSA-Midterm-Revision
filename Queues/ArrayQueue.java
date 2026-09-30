package Queues;

public class ArrayQueue implements Queues {
    private Object[] array;
    private int size;     
    private int front;    
    private int rear;

    // Constructor
    public ArrayQueue(int capacity) {
        array = new Object[capacity];
        size = 0;
        front = 0;
        rear = -1; 
    }

    public int size() {
        return size;
    }
    
    public void enqueue(Object obj) {
        if (size == array.length) {
            resize();
        }
        
        rear = (rear + 1) % array.length; 
        array[rear] = obj; 
        size++; 
    }

    public Object first() {
        if (size == 0) {
            throw new IllegalStateException("Queue is Empty!");
        }
        return array[front]; 
    }

    public Object dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is Empty!");
        }
        
        Object temp = array[front]; 
        array[front] = null; 
        front = (front + 1) % array.length; 
        
        size--; 
        return temp; 
    }

    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        for (int i = 0; i < size; i++) {
            // Asal array mein elements aage peechay ho sakte hain, uski sahi position dhoondo
            int actualIndex = (front + i) % array.length;             
            // Nayi array mein zero (0) se line lagana shuru karo
            newArray[i] = array[actualIndex];
        }
        //Purani array ko chhoro, nayi ko apna lo
        array = newArray;
        // Sab kuch seedha ho gaya hai, toh Front aur Rear ko reset kardo
        front = 0;
        rear = size - 1; 
    }

    // ArrayQueue ka Data dekhne ke liye
    public String toString() {
        if (size == 0) {
            return "Queue is Empty []";
        }
        
        String result = "Front -> [ ";
        
        // Loop 'size' ki tadad tak chalayenge
        for (int i = 0; i < size; i++) {
            // Asal position dhoondhne ke liye Modulo ka jadu!
            int actualIndex = (front + i) % array.length; 
            
            result += array[actualIndex];
            
            if (i < size - 1) { // Aakhri element ke baad comma nahi lagana
                result += ", "; 
            }
        }
        result += " ] <- Rear";
        
        return result;
    }
}
