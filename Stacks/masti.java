package Stacks;

public class masti {
    public static void main(String[] args) {
        Stacks[] bigStack = new ArrayStack[5];
        for (int i = 0; i < bigStack.length; i++){
            bigStack[i] = new ArrayStack(10);
            for(int j = 1; j < 11; j++){
                bigStack[i].push((j * 10) + (i * 100));
            }
        }
        
        int target = 410;
        for (int i = 0; i < bigStack.length; i++){
            int position = 0;
            while(bigStack[i].size() > 0){
                position++;
                int current = (int) bigStack[i].pop();
                if (current == target){
                    System.out.println("Found target: " + target + " in stack " + i + " at position " + position);
                    break;
                }
            }
        }
    }
}
