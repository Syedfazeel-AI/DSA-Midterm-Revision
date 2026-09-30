package Recursion;

public class Odd {
    void printOdd(int n , int limit){
        if ( n > limit){
            return ;
        }
        if (n % 2 != 0) {
            System.out.println(n);
        }
        printOdd(n + 1, limit);
    }
}
