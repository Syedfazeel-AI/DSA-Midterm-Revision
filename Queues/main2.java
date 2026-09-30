package Queues;

public class main2 {
    public static void main(String[] args) {
        LinkedQueue lq = new LinkedQueue();
        lq.enqueue("Fazeel");
        lq.enqueue("Aman");
        lq.enqueue("Izzi");
        lq.enqueue("Dheeru");

        System.out.println("First Element: " + lq.first());

        lq.dequeue();
        System.out.println("Now First is: " + lq.first());
    }
}
