package Queues;

public class Q2p {
    public static void main(String[] args) {
        LinkedQueue Customers = new LinkedQueue();

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

        LinkedQueue temp = new LinkedQueue();
        int counter = 1;
        while (Customers.size() != 0) {
            String id = (String) Customers.dequeue();
            if (id.equals("Syed Fazeel 8")){
                System.out.println("Position " + counter);
                break;
            }
            temp.enqueue(id);
            counter++;
        }
    }
    
}