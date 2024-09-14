package binarySearch;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 5, 9, 14, 16, 18};
        int target = 1;
        //System.out.println(binarySearch(arr, target));
        System.out.println(binarySearchRecursive(arr, target, 0, arr.length));

    }

    private static int binarySearchRecursive(int[] arr, int target, int start, int end) {
        if (start >= end) {
            return -1;
        }

        int mid = (start + end)/2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, start, mid);
        } else {
            return binarySearchRecursive(arr, target, mid + 1, end);
        }
    }


    private static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                l = mid + 1;
            else if (arr[mid] > target)
                r = mid - 1;
        }
        return -1;
    }
}

