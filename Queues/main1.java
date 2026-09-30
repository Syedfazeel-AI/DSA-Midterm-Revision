package Queues;

public class main1 {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(10);
        for (int i=1; i<11 ; i++ ){
            aq.enqueue(i*10);
        }

        System.out.println("Size of Queue: " + aq.size());
        System.out.println("First Number is: " + aq.first());
    }
}
