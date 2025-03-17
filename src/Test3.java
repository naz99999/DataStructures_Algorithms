public class Test3 {

    //Given an array and a number n, rotated array clockwise n times. given an index i , tell the array element which is at i after roatation.

    public static void main(String args[]) {
        int[] arr = {10, 20, 30, 40 ,50};
        //50 10 20 30 40
        //40 50 10 20 30

//        int n = 2;
//        int i = 1;
        for (int i = 1; i <= 10; i++) {
            System.out.print("i -> " + i + "   ");
            System.out.println(findElement(arr, i, 0));
        }
    }

    private static int findElement(int[] arr, int n, int i) {
        int len = arr.length % n;
        if (len == 0) {
            return arr[0];
        }

        return arr[Math.abs(i - n + len) % len];

    }
}














