package Stacks;

public class masti3 {
    public static void main(String[] args) {
        LinkedStack Original = new LinkedStack();
        LinkedStack Copy = new LinkedStack();
        LinkedStack Temp = new LinkedStack();

        for (int i = 1; i < 11; i++){
            Original.push(i*10);
        }

        while(Original.size() > 0){
            Temp.push(Original.pop());
        }

        while(Temp.size() > 0){
            int current = (int) Temp.pop();
            Copy.push(current);
            Original.push(current);
        }

         System.out.println("Copy Stack: " + Copy.peek());
    }
    
}
