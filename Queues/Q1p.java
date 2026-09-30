package Queues;

public class Q1p {
    public static void main(String[] args) {
        LinkedQueue Customers = new LinkedQueue();
        LinkedQueue temp = new  LinkedQueue();

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

        for(int i =0; i<3; i++){
            temp.enqueue(Customers.dequeue());
        }
        System.out.println(Customers);
    }
    
}