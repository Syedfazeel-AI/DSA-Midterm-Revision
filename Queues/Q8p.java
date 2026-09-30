package Queues;

public class Q8p {
    public static void main(String[] args) {
        LinkedQueue Customers = new LinkedQueue();
        LinkedQueue Queue1 = new LinkedQueue();
        LinkedQueue Queue2 = new LinkedQueue();

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

        int half = Customers.size() / 2;
        for(int i =0; i<half ; i++){
            Queue1.enqueue(Customers.dequeue());
        }

        while (Customers.size()!=0) {
            Queue2.enqueue(Customers.dequeue());
        }

        System.out.println(Queue1);
        System.out.println(Queue2);
    }
}
