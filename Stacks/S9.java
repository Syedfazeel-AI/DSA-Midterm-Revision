package Stacks;

public class S9 {
    public static void main(String[] args) {
        ArrayStack Original = new ArrayStack(10);
        LinkedStack Even = new LinkedStack();
        LinkedStack Odd = new LinkedStack();
        
        for (int i = 1; i < 11; i++){
            Original.push(i*5);
        }

        while(Original.size() > 0){
            int current = (int) Original.pop();
            if (current % 2 == 0){
                Even.push(current);
            } else {
                Odd.push(current);
            }
        }
        System.out.println("Size of Even stack: " + Even.size());
        System.out.println("Top element of Even stack: " + Even.peek());
        System.out.println("Size of Odd stack: " + Odd.size());
        System.out.println("Top element of Odd stack: " + Odd.peek());
    }    
}
