package Stacks;

public class masti2 {
    public static void main(String[] args) {
        LinkedStack izzi = new LinkedStack();
        for (int i = 1; i < 11; i++){
            izzi.push(i*55);
        }

        Stacks[] mystack = new LinkedStack[10];
        for(int i = 0; i < 10; i++){
            mystack[i] = new LinkedStack();
            mystack[i].push(izzi.pop());
        }

        System.out.println(mystack[0].peek());
        System.out.println(mystack[1].peek());
        System.out.println(mystack[2].peek());
    }
}
