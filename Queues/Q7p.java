package Queues;

public class Q7p {
    public static void main(String[] args) {
        LinkedQueue Practice = new LinkedQueue();
        LinkedQueue Even = new LinkedQueue();
        LinkedQueue Odd = new  LinkedQueue();

        Practice.enqueue(45);
        Practice.enqueue(89);
        Practice.enqueue(03);
        Practice.enqueue(31);
        Practice.enqueue(65);
        Practice.enqueue(93);
        Practice.enqueue(30);
        Practice.enqueue(80);
        Practice.enqueue(70);

        while (Practice.size() != 0) {
            int current = (int) Practice.dequeue();
            if (current % 2 == 0) {
                Even.enqueue(current);
            }
            if (current % 2 != 0) {
                Odd.enqueue(current);
            }
        }

        System.out.println(Even);
        System.out.println(Odd);
    }
}
