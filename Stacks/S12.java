package Stacks;

public class S12 {
    public static void main(String[] args) {
        ArrayStack Original = new ArrayStack(5);
        ArrayStack Temp = new ArrayStack(10);

        Original.push(58);
        Original.push(46);
        Original.push(60);
        Original.push(85);
        Original.push(34);

        while (Original.size() > 0) {
            int current = (int) Original.pop();
            while (Temp.size()>0 && (int) Temp.peek() > current) {
                Original.push(Temp.pop());
            }
            Temp.push(current);
        }

        System.out.println("Sorted Top: "+ Temp.peek());
    }
}
