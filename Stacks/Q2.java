package Stacks;

public class Q2 {
    public static void main(String[] args) {
        ArrayStack as1 = new ArrayStack(5);
        ArrayStack as2 = new ArrayStack(5);
        ArrayStack as3 = new ArrayStack(5);
        ArrayStack as4 = new ArrayStack(5);

        for(int i = 1; i < 6; i++){
            as1.push("as1_post " + i);
            as2.push("as2_post " + i);
            as3.push("as3_post " + i);
            as4.push("as4_post " + i);

        }

        // q2 b
        // LinkedStack newStack = new LinkedStack();
        // newStack.push(as1.pop());
        // newStack.push(as2.pop());
        // newStack.push(as3.pop());
        // newStack.push(as4.pop());

        // System.out.println(newStack.peek());

        // q2 c
        LinkedStack newStackB = new LinkedStack();
        LinkedStack temp = new LinkedStack();
        
        newStackB.push(as1.pop());
        temp.push(as2.pop());
        newStackB.push(as2.pop());
        for (int i = 0; i <2; i++){
            temp.push(as3.pop());
        }
        newStackB.push(as3.pop());
        // while (temp.size() != 0) {  
        //     as3.push(temp.pop());
        // }
        for(int i=0;i<3;i++){
            temp.push(as4.pop());
        }
        newStackB.push(as4.pop());
        // while (temp.size() != 0) {
        //     as4.push(temp.pop());
        // }

        // System.out.println(newStackB.peek());
        System.out.println(newStackB);
    } 
}
