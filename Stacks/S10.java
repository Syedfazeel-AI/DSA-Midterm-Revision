package Stacks;

public class S10 {
    public static void main(String[] args) {
        ArrayStack Original = new ArrayStack(10);
        ArrayStack Temp = new  ArrayStack(10);

        for (int i=1 ; i<11; i++){
            Original.push(i);
        }

        while (Original.size() > 1) {
            Temp.push(Original.pop());
        }

        int current = (int) Original.pop();
        
        while (Temp.size() > 0) {
            Original.push(Temp.pop());
        }
        Original.push(current);

        System.out.println("Top: " + Original.peek());
    }
}
