package Queues;

public class Q3 {
    public static void main(String[] args) {

        // q3 a
        LinkedQueue tollQueue = new LinkedQueue();
        tollQueue.enqueue("ABC768");
        tollQueue.enqueue("ABC567");
        tollQueue.enqueue("ABC795");
        tollQueue.enqueue("OBH097");
        tollQueue.enqueue("ABC523");
        tollQueue.enqueue("ARH9087");
        tollQueue.enqueue("ABC781");
        tollQueue.enqueue("ACB097");

        // q3 b
        LinkedQueue temp = new LinkedQueue();

        // String first = (String) tollQueue.dequeue();
        // System.out.println("1st Car " + first);
        // temp.enqueue(first);

        // for (int i = 0; i < 5; i++ ){
        //     temp.enqueue(tollQueue.dequeue());
        // }
        // String seventh =  (String) tollQueue.dequeue();
        // System.out.println("7th car " + seventh);
        // temp.enqueue(seventh);
        // int size = tollQueue.size() - 2;
        // for (int i =0; i < size ; i++){
        //     temp.enqueue(tollQueue.dequeue());
        // }

        // String secondLast = (String) tollQueue.dequeue();
        // System.out.println("Second Last Car " + secondLast);
        // temp.enqueue(secondLast);

        // String last = (String) tollQueue.dequeue();
        // System.out.println("Last Car " +  last);
        // temp.enqueue(last);

        // while (temp.size() != 0) {
        //     tollQueue.enqueue(temp.dequeue());
        // }

        // q3 c

        tollQueue.enqueue("ABC123");
        tollQueue.enqueue("XYZ005");

        int count =1;
        while (tollQueue.size() !=0){
           String plate = (String) tollQueue.dequeue();
           if (plate.equals("ABC123")){

            System.out.println("Position: " + count);
            break;
           }
           temp.enqueue(plate);
           count++;
        }

        while (temp.size() !=0 ){
            tollQueue.enqueue(temp.dequeue());
        }

            
    }

 }

