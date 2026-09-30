package Queues;

public class Q3p {
    public static void main(String[] args) {
        LinkedQueue Customers = new LinkedQueue();
        LinkedQueue Temp = new  LinkedQueue();
        LinkedQueue Copy = new LinkedQueue();

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

        while (Customers.size() != 0) {
            Temp.enqueue(Customers.dequeue());
        }

        while (Temp.size() != 0) {
            String temp = (String) Temp.dequeue();
            Copy.enqueue(temp);
            Customers.enqueue(temp);

        }
        System.out.println(Customers);
        System.out.println(Copy);
        
        

    }
}
