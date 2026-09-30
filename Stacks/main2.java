package Stacks;

public class main2 {
    public static void main(String[] args) {
        LinkedStack ls = new LinkedStack();
        for (int i = 1; i < 11; i++){
            ls.push(i * 10);
        }
        System.out.println("Stack size: " + ls.size());
        System.out.println("Top element: " + ls.peek());

        int half = ls.size() / 2;
        for (int i = 0; i < half; i++){
            ls.pop();
        }
        System.out.println("Middle element: " + ls.peek());

        // int max = Integer.MIN_VALUE;
        // int min = Integer.MAX_VALUE;
        // int sum = 0;
        // int count = 0;
        // int target = 50;
        
        // while (!ls.isEmpty()) { // (ls.size() > 0) --> ye bhi chalega 
        //     // count++;
        //     int current = (int) ls.pop();
        //     if (current == target) {
        //         System.out.println("Found target: " + target);
        //         break;
        //     }
        //     // sum = sum + current;
        //     // if (current > max) {
        //     //     max = current;
        //     // }
        //     // if (current < min) {
        //     //     min = current;
        //     // }
        // }
        // // System.out.println("Maximum: " + max);
        // // System.out.println("Minimum: " + min);
        // // System.out.println("Sum: " + sum);
        // // System.out.println("Count: " + count);
        // while(ls.size() > 1){
        //     ls.pop();
        // }
        // System.out.println("Bottom element: " + ls.peek());
        
    }
}
