package Stacks;

public class S15 {
    public static void main(String[] args) {
        ArrayStack Original = new ArrayStack(10);
        ArrayStack Temp = new  ArrayStack(10);

        for (int i=1 ; i<11; i++){
            Original.push(i*10);
        }

        int counter = 0;
        int target = 40;
        boolean found = false;
        while(Original.size() > 0){
            int current = (int) Original.pop();
            if (current == target){
                System.out.println("Target: " + target + " Found!");
                System.out.println("Numbers above: " + counter);
                System.out.println("Numbers below: " + Original.size());
                Temp.push(current);
                found = true;
                break;
            } else{
                counter++;
                Temp.push(current);
            }
        }
        if (!found) {
            System.out.println("Target not found!");
        }

        while (!Temp.isEmpty()) {
            Original.push(Temp.pop());
        }


        // ==========================================
        // PART 2: Find the Middle Element
        // ==========================================
        // System.out.println("\n--- Middle Element ---");
        
        // int totalSize = Original.size();
        // int midIndex = totalSize / 2; 

        // // Upar walon ko nikal kar Temp mein dalo
        // for (int i = 0; i < midIndex; i++) {
        //     Temp.push(Original.pop());
        // }

        // // Ab jo top par hai, wo middle hai!
        // int middleElement = (int) Original.peek(); 
        // System.out.println("The Middle Element is: " + middleElement);

        // // Wapas restore kar do
        // while (Temp.size() > 0) {
        //     Original.push(Temp.pop());
        // }
    }
}
