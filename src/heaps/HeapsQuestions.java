package heaps;

import java.util.ArrayList;
import java.util.List;

public class HeapsQuestions {

    public ArrayList<Integer> unsortedToMaxHeap(ArrayList<Integer> input) {
        ArrayList<Integer> arr = new ArrayList<>();
        //downheap(arr, 0);
        return arr;
    }

//    public void downheap(ArrayList<Integer> arr, int index) {
//        int min = index;
//        int left = left(index);
//        int right = right(index);
//
//        if (left < arr.size() && arr.get(min).compareTo(arr.get(left)) > 0) {
//            min = left;
//        } else if (right < arr.size() && arr.get(min).compareTo(arr.get(left)) > 0) {
//            min = right;
//        }
//
//        if (min != index) {
//            downheap(min);
//        }
//    }

    private int parent(int index) {
        return (index - 1)/2;
    }

    private int left(int index) {
        return (2 * index) + 1;
    }

    private int right(int index) {
        return (2 * index) + 2;
    }
}
