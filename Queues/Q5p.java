package Queues;

import Stacks.LinkedStack;

public class Q5p {
    public static void main(String[] args) {
        LinkedQueue Original = new LinkedQueue();
        LinkedStack Stack = new LinkedStack();

        Original.enqueue(10);
        Original.enqueue(20);
        Original.enqueue(30);
        Original.enqueue(40);

        System.out.println("Normal Queue: " + Original);

        while (Original.size() !=0) {
            Stack.push(Original.dequeue());
        }
        while (!Stack.isEmpty()) {
            Original.enqueue(Stack.pop());
        }
        System.out.println("Reverse Queue: " + Original);
    }
    
}
