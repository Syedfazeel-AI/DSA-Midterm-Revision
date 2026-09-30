package Stacks;

public class main1 {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(5);
        for (int i = 1; i < 11; i++){
            as.push(i * 10);
        }

        System.out.println("Stack size: " + as.size());
        System.out.println("Top element: " + as.peek());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int count = 0;

        while (!as.isEmpty()) { // (as.size() > 0) --> ye bhi chalega 
            
            int current = (int) as.pop();
            count++;
            sum = sum + current;
            if (current > max) {
                max = current;
            }
            if (current < min) {
                min = current;
            }
        }
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
        System.out.println("Sum: " + sum);
        System.out.println("Count: " + count);
        // int target = 50;
        // while(!as.isEmpty()){
        //     int current = (int) as.pop();
        //     if (current == target) {
        //         System.out.println("Found target: " + target);
        //         break;
        //     }
        // }

        // while(as.size() > 1){
        //     as.pop();
        // }
        // System.out.println("Bottom element: " + as.peek());

        // int half = as.size() / 2;
        // for (int i = 0; i < half; i++){
        //     as.pop();
        // }
        // System.out.println("Middle element: " + as.peek());

    }
}