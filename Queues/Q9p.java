package Queues;

public class Q9p {
    public static void main(String[] args) {
        LinkedQueue Customers = new LinkedQueue();
        LinkedQueue Practice = new LinkedQueue();
        LinkedQueue Merged = new LinkedQueue();

        Customers.enqueue("Syed Fazeel 1");
        Customers.enqueue("Syed Fazeel 2");
        Customers.enqueue("Syed Fazeel 3");
        Customers.enqueue("Syed Fazeel 4");
        Customers.enqueue("Syed Fazeel 5");
        Customers.enqueue("Syed Fazeel 6");
        Customers.enqueue("Syed Fazeel 7");
        Customers.enqueue("Syed Fazeel 8");
        Customers.enqueue("Syed Fazeel 9");
        Customers.enqueue("Syed Fazeel 10");

        Practice.enqueue(45);
        Practice.enqueue(89);
        Practice.enqueue(03);
        Practice.enqueue(31);
        Practice.enqueue(65);
        Practice.enqueue(93);
        Practice.enqueue(30);
        Practice.enqueue(80);
        Practice.enqueue(70);

        // while (Customers.size()!=0 && Practice.size()!=0) {
        //     Merged.enqueue(Customers.dequeue());
        //     Merged.enqueue(Practice.dequeue());
            
        // }

        while (Customers.size() !=0) {
            Merged.enqueue(Customers.dequeue());
        }
        while (Practice.size()!=0) {
            Merged.enqueue(Practice.dequeue());
        }

        System.out.println(Merged);
    }
}
