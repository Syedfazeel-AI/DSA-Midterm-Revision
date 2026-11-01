// class Node{
//     int data;
//     Node next;

//     Node(int data, Node next){
//         this.data = data;
//         this.next = next;
//     }
// }

// public class InventorySystem {
//     static Node insert(Node start, int x){
//         if (start == null || start.data > x){
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

//     static boolean search(Node start, int target){
//         for (Node i = start; i != null; i = i.next){
//             if(i.data == target){
//                 return true;
//             }
//         }
//         return false;
//     }

//     public static void main(String[] args) {
//         Node mainStock = null;
//         Node clearanceStock = null;
//         Node mergedList = null;

//         mainStock = insert(mainStock, 45);
//         mainStock = insert(mainStock, 12);
//         mainStock = insert(mainStock, 89);
//         mainStock = insert(mainStock, 23);
//         mainStock = insert(mainStock, 60);
//         mainStock = insert(mainStock, 35);

//         // mainStock = delete(mainStock, 23);

//         clearanceStock = insert(clearanceStock, 10);
//         clearanceStock = insert(clearanceStock, 50);

//         for (Node i = mainStock ; i != null; i=i.next){
//             mergedList = insert(mergedList, i.data);
//         }
//         for (Node j = clearanceStock; j != null; j=j.next){
//             mergedList = insert(mergedList, j.data);
//         }

//         System.out.println("Merged List: ");
//         for (Node k = mergedList ; k != null; k = k.next){
//             System.out.println(k.data);
//         }
//         int sum = 0;
//         // int count = 0;
//         int max = 0;
//         int min = 12;
//         // System.out.println("Calculations: ");

//         for (Node i = mainStock; i!= null; i = i.next){
//              sum = sum + i.data;
//             //  count ++;
//              if (i.data > max){
//                 max = i.data;
//              }
//              if (i.data < min){
//                 min = i.data;
//              }
//         }

//         // System.out.println("Sum of all Prices: "+ sum);
//         // System.out.println("Total Items: " + count);
//         // System.out.println("Expensive Price: " + max);
//         // System.out.println("Cheapest Price: " + min);
//         // System.out.println("Searching for 89: " + search(mainStock, 89));
//     }
// }
