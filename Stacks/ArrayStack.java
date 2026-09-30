package Stacks;

public class ArrayStack implements Stacks {
    private int size;
    private Object[] a;

    public ArrayStack(int capacity) {
        a = new Object[capacity];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (size == 0) throw new IllegalStateException("Stack is empty");
        return a[size - 1];
    }

    public void push(Object obj) {
        if (size == a.length) {
            resize(); 
        }
        a[size++] = obj;
    }

    public Object pop() {
        if (size == 0) throw new IllegalStateException("Stack is empty");
        Object temp = a[--size];
        a[size] = null; // Memory free karne ke liye
        return temp;
    }

    private void resize() {
        Object[] aa = a;
        a = new Object[2 * aa.length];
        System.arraycopy(aa, 0, a, 0, size);
    }

    // ArrayStack ka Data dekhne ke liye
    public String toString() {
        if (size == 0) {
            return "Stack is Empty []";
        }
        
        String result = "Top -> [ ";
        // Loop ko Top se shuru karke zero index tak le jayenge
        for (int i = size - 1; i >= 0; i--) {
            result += a[i]; // Element add kiya
            if (i > 0) {
                result += ", "; // Beech mein comma lagane ke liye
            }
        }
        result += " ]";
        
        return result;
    }
    
}
