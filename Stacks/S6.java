package Stacks;

public class S6 {
    public static void main(String[] args) {
        LinkedStack Original = new LinkedStack();
        LinkedStack temp = new LinkedStack();

        for (int i = 1; i < 11; i++){
            Original.push(i*20);
        }

        int target = 80;
        while(Original.size() > 0){
            int current = (int) Original.pop();
            if (current != target){
                temp.push(current);
            }
        }

        while(temp.size() > 0){
            Original.push(temp.pop());
        }

        System.out.println("Size of Original stack after removing target " + target + ": " + Original.size());
    }
}
