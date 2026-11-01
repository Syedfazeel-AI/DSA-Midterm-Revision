package Practice;

public class idk {
    public static void main(String[] args) {
        int [] arr = {34,67,90,65,78,80,45,23,12};
        int n = arr.length;
        // int low = 0;
        // int high = arr.length - 1;
    // while (low <= high) {
    //     int mid = (low + high) / 2;
    //     if (arr[mid] == 80) {
    //         System.out.println("Element found at index: " + mid);
    //         break;
    //     } else if (arr[mid] < 80) {
    //         low = mid + 1;
    //     } else {
    //         high = mid - 1;
    //     }
    // }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - 1 - i; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


}
