package sorting;

import java.util.Arrays;
import java.util.HashMap;

public class CountSort {
    public static void main(String[] args) {

        int[] arr = {3, 2, 3, 2, 1, 1, 8};
        System.out.println(Arrays.toString(countUsingArray(arr)));
        System.out.println(Arrays.toString(countUsingHashmaps(arr)));
    }

    private static int[] countUsingHashmaps(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for (int i = min; i <= max; i++) {
            int count = countMap.getOrDefault(i, 0);
            while (count > 0) {
                arr[index] = i;
                index++;
                count--;
            }
        }
        return arr;
    }

    private static int[] countUsingArray(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        int[] countNum = new int[max + 1];

        for (int num : arr) {
            countNum[num]++;
        }

        int index = 0;
        for (int i = 0; i < countNum.length; i++) {
            while (countNum[i] > 0) {
                arr[index] = i;
                index++;
                countNum[i]--;
            }
        }
        return arr;
    }
}

