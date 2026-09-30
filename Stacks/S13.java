package Stacks;

public class S13 {
    public static void main(String[] args) {
        LinkedStack Stack1 =  new LinkedStack();
        LinkedStack Stack2 =  new LinkedStack();

        for(int i =1; i < 11; i++){
            Stack1.push(i*100);
        }
        for(int i =1; i < 11; i++){
            Stack2.push(i*100);
        }
        
        boolean isEqual = true; 

        if (Stack1.size() == Stack2.size()) {
            while (Stack1.size() > 0) {
                int a = (int) Stack1.pop();
                int b = (int) Stack2.pop();
                if (a != b) {
                    isEqual = false; 
                    break; 
                }
            }
        } else {
            isEqual = false; 
        }

        System.out.println("Are the stacks exactly equal? " + isEqual);
    
    }
}
