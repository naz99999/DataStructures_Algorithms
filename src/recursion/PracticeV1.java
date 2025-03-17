package recursion;

import java.util.ArrayList;
import java.util.List;

public class PracticeV1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,8};
        //System.out.println(sortedOrNot(arr, 0));
        int key = 7;
        //System.out.println(linearSearch(arr, key, 0));
        List<Integer> ans = new ArrayList<>();
        //System.out.println(findIndices(arr, key, 0, ans));
        //System.out.println(findIndices2(arr, key, 0));
        //System.out.println(rotatedBinarySearch(arr, key, 0, arr.length-1));
        System.out.println(isSorted(arr));
        System.out.println(findIndices(arr, 0, 4, new ArrayList<>()));
    }

    public static boolean isSorted(int[] arr) {
        return isSortedHelper(arr, 0);
    }

    private static boolean isSortedHelper(int[] arr, int i) {
        if (i == arr.length) {
            return true;
        }

        if (i + 1 < arr.length && arr[i] > arr[i + 1]) {
            return false;
        }

        return isSortedHelper(arr, i + 1);
    }

    public static List<Integer> findIndices(int[] arr, int i, int target, List<Integer> list) {
        if (i == arr.length) {
            return list;
        }

        if (arr[i] == target) {
            list.add(i);
        }

        return findIndices(arr, i + 1, target, list);
    }
}
