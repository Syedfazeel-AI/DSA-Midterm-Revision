package Recursion;

public class Counting {
    int count(int n){
        if (n >= 10){
            return n;
        }
        System.out.println(n);
        return count(n + 1);
    }
}
