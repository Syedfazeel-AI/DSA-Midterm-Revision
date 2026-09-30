package Stacks;

public class S14 {
    public static void main(String[] args) {
        ArrayStack Original = new ArrayStack(5);
        ArrayStack Temp = new ArrayStack(5);
        ArrayStack Unique = new ArrayStack(5);

        Original.push(10);
        Original.push(20);
        Original.push(10);
        Original.push(30);
        Original.push(20);
        
        while (Original.size() > 0) {
            int current = (int) Original.pop();
            boolean isDuplicate = false;
            while (Unique.size() > 0) {
                int checkVal = (int) Unique.pop();
                Temp.push(checkVal); 
    
                if (checkVal == current) {
                isDuplicate = true; 
                }
            }
            while (Temp.size() > 0) {
               Unique.push(Temp.pop());
            }
            if (isDuplicate == false) {
               Unique.push(current);
            }
        }
        

    }
}
