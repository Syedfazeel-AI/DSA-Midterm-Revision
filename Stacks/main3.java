package Stacks;

public class main3 {
    public static void main(String[] args) {
        ArrayStack arr = new ArrayStack(10);
        arr.push(10);
        arr.push(20);
        arr.push(30);
        arr.push(40);
        arr.push(50);
        arr.push(40);
        arr.push(40);
        arr.push(40);
        arr.push(90);
        arr.push(40);

        int count = 0;
        int target = 40;
        while(!arr.isEmpty()){
            int current = (int) arr.pop();
            if (current == target){
                count++;
            }
        }
        System.out.println("Target " + target + " is found " + count + " times");
    }
}
