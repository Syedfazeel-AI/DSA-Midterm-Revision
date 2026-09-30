package Queues;

public class Q4p {
    public static void main(String[] args) {
        LinkedQueue Practice = new LinkedQueue();
        LinkedQueue Temp = new LinkedQueue();

        Practice.enqueue(45);
        Practice.enqueue(89);
        Practice.enqueue(03);
        Practice.enqueue(31);
        Practice.enqueue(65);
        Practice.enqueue(93);
        Practice.enqueue(30);
        Practice.enqueue(80);
        Practice.enqueue(70);
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (Practice.size()!=0) {
            int Value = (int) Practice.dequeue();
            if (Value > max) {
                max = Value;
            }
            if (Value < min) {
                min = Value;
            }
            Temp.enqueue(Value);
        }
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);

    }
}
