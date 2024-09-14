package threepointers;

import java.util.Arrays;

public class ThreePointers {
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,2,0,1,2};

        System.out.println(Arrays.toString(zeroesTwosOnes(arr)));
    }

    private static int[] zeroesTwosOnes(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while(mid<=high) {
            if(arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } else if(arr[mid] == 2) {
                mid++;
            } else if(arr[mid] == 1) {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        return arr;
    }
}
