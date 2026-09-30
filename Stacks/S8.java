package Stacks;

public class S8 {
    public static void main(String[] args) {
        ArrayStack Original = new ArrayStack(10);
        ArrayStack Stack1 = new ArrayStack(5);
        ArrayStack Stack2 = new ArrayStack(5);

        for (int i = 1; i < 11; i++){
            Original.push(i*10);
        }

        int half = Original.size() / 2;
        for (int i = 0; i < half; i++){
            Stack1.push(Original.pop());
        }
        while(Original.size() > 0){
            Stack2.push(Original.pop());
        }

        System.out.println("Size of Stack1: " + Stack1.size());
        System.out.println("Top element of Stack1: " + Stack1.peek());
        System.out.println("Size of Stack2: " + Stack2.size());
        System.out.println("Top element of Stack2: " + Stack2.peek());
    }    
    
}
