package Queues;

public class Q6p {
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

        System.out.println("Before Removing : " + Customers);

        String target = "Syed Fazeel 6";
        while (Customers.size() != 0) {
            String current = (String) Customers.dequeue();
            if (!current.equals(target)) {
                temp.enqueue(current);
            }
            
        }
        while (temp.size()!=0) {
            Customers.enqueue(temp.dequeue());
        }

        System.out.println("After Removing : " + Customers);

    }
}
