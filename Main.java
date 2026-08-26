class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }
}

public class Main{
    public static void main(String[] args){
        Node start = new Node(1);
        // start.next = new Node(4);
        // start.next.next = new Node(6) 
        // start.next.next.next = new Node(8);
        Node p = start;
        for (int i = 2; i < 11; i++){
            p.next = new Node(i);
            p=p.next;
        }
        
        int sum = 0;
        int count = 0;
        int max = 0;
        int min = 0;
        System.out.println("Linked List: ");
        for (Node i = start; i != null; i=i.next){
            sum = sum + i.data;
            count++;
            if (i.data > max){
                max = i.data;
            }
            if (i.data < min){
                min = i.data;
            }
        }

        double average = 0;
        average = (double) sum/count;
        System.out.println("Sum: " + sum);
        System.out.println("Count: " + count);
        System.out.println("Average: " + average);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}