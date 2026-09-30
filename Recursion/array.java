package Recursion;

public class array {
    void print(int arr[], int n){
        if (n == arr.length) {
            return;
        }
        System.out.println(arr[n]);
        print(arr, n + 1);
    }
}
