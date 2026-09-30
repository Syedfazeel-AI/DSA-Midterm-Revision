package Recursion;

public class linkedlist {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    void printlist(Node head){
        if (head == null){
            return ;
        }
        System.out.println(head.data);
        printlist(head.next);
    }
}
