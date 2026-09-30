package Stacks;

public class S7 {
    public static void main(String[] args) {
        LinkedStack Original = new LinkedStack();
        LinkedStack temp = new LinkedStack();

        for (int i = 1; i < 11; i++){
            Original.push(i*20);
        }

        int target = 80;
        int newValue = 85;
        while(Original.size() > 0){
            int current = (int) Original.pop();
            if (current != target){
                temp.push(current);
            } else {
                temp.push(newValue);
            }
        }
        
        while(temp.size() > 0){
            Original.push(temp.pop());
        }
        System.out.println("Size of Original stack after replacing target " + target + ": " + Original.size());
        
    }
}
