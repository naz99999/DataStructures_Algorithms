package binarySearch;

public class Floor {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 5, 9, 14, 16, 18};
        int target = 15;
        int index = binarySearch(arr, target);
        System.out.println("binarySearch.Floor : " + arr[index] + " and index is : " + index);
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
        return r; //floor
    }
}
