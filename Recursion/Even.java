package Recursion;

public class Even {
    void printEven(int n , int limit){
        if ( n > limit){
            return ;
        }
        if (n % 2 == 0) {
            System.out.println(n);
        }
        printEven(n + 1, limit);
    }
}
