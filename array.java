public class array {
    public static void main(String[] args) {
        // int[] arr = new int[5];
        // arr[0] = 10;
        // arr[1] = 20;
        // arr[2] = 30;
        // arr[3] = 40;

        int[] arr = {10, 20, 30, 40, 50};

        for (int i = 3; i>=1; i--){
            arr[i+1] = arr[i];
        }

        arr[1] = 15;

        for (int i = 2; i < arr.length; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
