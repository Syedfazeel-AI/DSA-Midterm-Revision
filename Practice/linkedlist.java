package Practice;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }
}

public class linkedlist {

    public static void main(String[] args) {
    Node start = new Node(10);
    // start.next = new Node(20);
    // start.next.next = new Node(30);
    // start.next.next.next = new Node(40);
    

    // yahan pe 10 ke baad 20 se 100 insert kiye hai
    Node p = start;
    for (int i = 2; i < 11; i++){
        p.next = new Node(i*10);
        p = p.next;
    }
    

    // yahan pe 25 ko 20 ke baad insert kiya hai
    Node newNode = new Node(25);
    Node temp = start;

    while(temp.data != 20){
        temp = temp.next;
    }

    newNode.next = temp.next;
    temp.next = newNode;


    // yahan pe 5 ko start se pehle insert kiya hai (new head)
    Node temp2 = new Node(5);
    temp2.next = start;
    start = temp2;

    // yahan pe 40 ko delete kiya hai
    Node temp3 = start;    
    while(temp3.next.data != 40){
        temp3 = temp3.next;
    }
    temp3.next = temp3.next.next;
    
    // yahan pe 150 ko end me insert kiya hai
    Node temp4 = start;
    while(temp4.next != null){
        temp4 = temp4.next;
    }
    temp4.next = new Node(150);


    // yahan reverse kiya hai!!! das whyy comment kar diya hai wrna list ki mkc hojati!!!!

    // Node prev = null;
    // Node current = start;
    // Node next = null;

    // while(current != null) {
    //     next = current.next;
    //     current.next = prev;
    //     prev = current;
    //     current = next;
    // }
    // start = prev;

    // yahan pe 5 ko delete kiya hai
    int y = 5;
    if(start.data == y){
        start = start.next;
    }

    int max = start.data;
    int min = start.data;
    int count = 0;
    int sum = 0;
    int x = 25;

    // yahan aik hi loop me max, min, count aur sum nikal k mkc krdi iski
    // btw yehi main traversal loop hai Linked list wala (iykyk)
    for(Node q = start; q != null; q = q.next){
        System.out.println(q.data);
        count++;
        sum = sum + q.data;

        if (q.data > max){
            max = q.data;
        }
        
        if (q.data < min){
            min = q.data;
        }
    }

    // yahan pe 25 ko search kiya hai (bas aise hi masti)
    boolean found = false;
    for (Node q = start; q != null; q = q.next) {
        if (q.data == x) {
            found = true;
            break;
        }
    }

    if (found) {
        System.out.println("Found: " + x);
    } else {
        System.out.println("Not Found: " + x);
    }


    // baqi ye batane ki tu need nhi!
    System.out.println("Max: " + max);
    System.out.println("Min: " + min);
    System.out.println("Count: " + count);
    System.out.println("Sum: " + sum);
}
}