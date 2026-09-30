// class Node {
//     int data;
//     Node next;

//     Node(int data, Node next){
//         this.data = data;
//         this.next = next;
//     }
// }


// public class Insertion{

//     static Node insert(Node start, int x){
//         if (start == null || start.data > x) {
//             start = new Node(x, start);
//             return start;        
//         }
//         Node p = start;
//         while (p.next != null) {
//             if(p.next.data > x)
//                break;
//             p = p.next;
//         } 
//         p.next = new Node(x, p.next);
//         return start;
//     }

//     static int count(Node start){
//         int count = 0;
//         for (Node i= start; i != null; i=i.next){
//             count++;
//         }
//         return count;
//     }

//     static int sum(Node start){
//         int sum = 0;
//         Node p = start;
//         while (p!=null) {
//             sum = sum + p.data;
//             p=p.next;
//         }
//         return sum;
//     }

//     static int max(Node start){
//         int max = Integer.MIN_VALUE; // start.data; is also correct but if the list is empty then it will give error
//         for (Node p = start; p != null ; p =p.next){
//             if (p.data > max){
//                 max = p.data;
//             }
//         }
//         return max;
//     }

//     static int min(Node start){
//         int min = Integer.MAX_VALUE; // start.data; is also correct but if the list is empty then it will give error
//         for (Node p = start; p != null ; p =p.next){
//             if (p.data < min){
//                 min = p.data;
//             }
//         }
//         return min;
//     }

//     static Node inserAtBegining(Node start, int x){
//         start = new Node(x, start);
//         return start;
//     }

//     static Node insertAtEnd(Node start, int x){
//         if (start == null){
//             start = new Node(x, start);
//             return start;
//         }
//         Node p = start;
//         while (p.next != null) {
//             p=p.next;
//         }
//         p.next = new Node(x, null);
//         return start;
//     }

//     static Node insertAfter(Node start, int target, int x){
//         Node p = start;
//         while (p.next != null) {
//             if (p.data == target) {
//                 break;
//             }
//             p=p.next;
//         }
//         p.next = new Node(x, p.next);
//         return start;
//     }

//     static boolean search(Node start, int target){
//         for (Node i = start; i != null; i = i.next){
//             if(i.data == target){
//                 return true;
//             }
//         }
//         return false;
//     }

//     static Node delete(Node start, int target){
//         if (start == null || start.data > target){
//             return start;
//         }
//         if(start.data == target){
//             return start.next;
//         }
//         Node p = start;
//         while (p.next != null){
//             if (p.next.data > target){
//                 break;
//             }
//             if (p.next.data == target){
//                 p.next = p.next.next;
//                 break; 
//             }
//             p = p.next;
//         }
//         return start;
//     }


//     static Node replace(Node start, int x, int y){
//         if (start == null || start.data > x){
//             return start;
//         }
//         if (start.data == x){
//             start.data = y;
//         }
//          Node p = start;
//         while (p.next != null){
//             if (p.next.data > x){
//                 break;
//             }
//             if (p.next.data == x){
//                 p.next.data = y;
//                 break; 
//             }
//             p = p.next;
//         }
//         return start;
//     }

//     static Node replaceAllOccurance(Node start, int x, int y){
//         for(Node p = start; p != null; p=p.next){
//             if (p.data == x){
//                 p.data = y;
//             }
//         }
//         return start;
//     }
    
//     static Node deleteAllOccurance(Node start, int x){
//         while (start != null && start.data == x) {
//             start = start.next;
//             if (start == null){
//                 return start;
//             }
//         }
//         Node p = start;
//         while (p.next != null) {
//             if (p.next.data == x) {
//                 p.next = p.next.next;
//             }else{p=p.next;}
//         }
//         return start;
//     }

//     static Node reverse(Node start){
//         Node prev = null;
//         Node current = start;
//         Node next = null;

//         while(current != null) {
//             next = current.next;
//             current.next = prev;
//             prev = current;
//             current = next;
            
//         }
//         return prev;
//     }

//     static Node splitInHalf(Node start){
//         if (start == null || start.next == null ){
//             return null;
//         }
//         Node slow = start;
//         Node fast = start;
//         while (fast.next != null && fast.next.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         Node start4 = slow.next;
//         slow.next = null;
//         return start4;
//     }
//     public static void main(String[] args) {
//         // Node start = null;
//         // start = insert(start, 5);
//         // start = insert(start, 25);
//         // start = insert(start, 15);
//         // start = insert(start, 2);
//         // start = insert(start, 20);
//         // start = insert(start, 30);
//         // start = insertAfter(start, 25, 28);

//         // System.out.println("Sorted List: ");
//         // for (Node i = start ; i != null ; i = i.next){
//         //     System.out.println(i.data);
//         // }

//         // Merging two LinkedList!!

//         // Node start1 = null;
//         // Node start2 = null;
//         // Node start3 = null;

//         // for (int i = 5; i <= 30; i+=5){
//         //     start1 = insert(start1, i);
//         // }

//         // start2 = insert(start2, 11);
//         // start2 = insert(start2, 13);
//         // start2 = insert(start2, 19);
//         // start2 = insert(start2, 26);
//         // start2 = insert(start2, 21);
//         // start2 = insert(start2, 29);

//         // System.out.println("Merged List: ");
//         // for(Node i = start1; i != null ; i = i.next){
//         //     start3 = insert(start3, i.data);
//         // }
//         // for(Node j = start2; j != null ; j = j.next){
//         //     start3 = insert(start3, j.data);
//         // }

//         // start3 = delete(start3, 10);
//         // start3 = replace(start3, 29, 69);
//         // start3 = reverse(start3);
        
        
//         // Node secondHalfHead;
//         // secondHalfHead = splitInHalf(start3);
//         // System.out.println("First Half: ");
//         // start3 = insertAfter(start3, 30, 31);
//         // for(Node k = start3; k != null ; k = k.next){
//         //     System.out.println(k.data);
//         // }
//         // System.out.println("Count: " + count(start3));
//         // System.out.println("Sum: " + sum(start3));
//         // System.out.println("Maximum: " + max(start3));
//         // System.out.println("Minimum: " + min(start3));
//         // System.out.println("Second Half: ");
//         // for (Node k = secondHalfHead; k != null; k = k.next){
//         //     System.out.println(k.data);
//         // }
        
//         // Searching for a specific value!!
        
//         // System.out.println("Searching 20: " + search(start3, 20));
//         Node list1 = null;
//         Node list2 = null;

//         list1 = insert(list1, 8);
//         list1 = insert(list1, 7);
//         list1 = insert(list1, 19);
//         list1 = insert(list1, 16);

//         list2 = insert(list2, 15);
//         list2 = insert(list2, 14);
//         list2 = insert(list2, 20);
//         list2 = insert(list2, 101);

//         System.out.println("Printing both lists using ONE loop:");
//         Node p = list1;
//         Node q = list2;

//         while (p != null || q != null){
//             if (p != null) {
//             System.out.print(p.data + "\n");
//             p = p.next;
//             }
//             if (q != null) {
//             System.out.print(q.data + "\n");
//             q = q.next;
//             }
//         }
        
//     }
        

// } 
