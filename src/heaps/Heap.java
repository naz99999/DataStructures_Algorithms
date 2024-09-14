package heaps;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {

    private final ArrayList<T> arr;
    public Heap() {
        this.arr = new ArrayList<>();
    }

    private int parent(int index) {
        return (index - 1)/2;
    }

    private int left(int index) {
        return (2 * index) + 1;
    }

    private int right(int index) {
        return (2 * index) + 2;
    }

    public void insert(T value) {
        arr.add(value);
        upheap(arr.size() - 1);
    }

    private void upheap(int index) {
        if (index == 0) {
            return;
        }
        int p = parent(index);

        if (arr.get(index).compareTo(arr.get(p)) < 0) {
            swapNodes(index, p);
            upheap(p);
        }
    }

    public ArrayList<Integer> unsortedToMaxHeap(int[] arr) {
        this.downheap(0);
        return new ArrayList<>();
    }

    public T delete() throws Exception {
        if (arr.isEmpty()) {
            throw new Exception("Cannot delete in an empty Heap!");
        }
        T value = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);
        if (!arr.isEmpty()) {
            downheap(0);
        }
        return value;
    }

    private void downheap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < arr.size() && arr.get(min).compareTo(arr.get(left)) > 0) {
            min = left;
        } else if (right < arr.size() && arr.get(min).compareTo(arr.get(left)) > 0) {
            min = right;
        }

        if (min != index) {
            downheap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> ans = new ArrayList<>();
        while (!arr.isEmpty()) {
            ans.add(this.delete());
        }
        return ans;
    }

    public void insert2(T value) {
        arr.add(value);
        int current = arr.size() - 1;
        int parent = (current - 1)/2;

        while (current > 0 && arr.get(current).compareTo(arr.get(parent)) < 0) {
            swapNodes(current, parent);

            current = parent;
            parent = (current - 1)/2;
        }
    }

    public T delete2() {
        if (arr.isEmpty()) {
            return null;
        }

        T root = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);

        int currentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while (leftChildIndex < arr.size()) {
            if (arr.get(currentIndex).compareTo(arr.get(leftChildIndex)) > 0) {
                swapNodes(currentIndex, leftChildIndex);
                currentIndex = leftChildIndex;
                leftChildIndex = (2 * currentIndex) + 1;
                rightChildIndex = (2 * currentIndex) + 2;
            }
            else if (rightChildIndex < arr.size() && arr.get(currentIndex).compareTo(arr.get(rightChildIndex)) > 0) {
                swapNodes(currentIndex, rightChildIndex);
                currentIndex = rightChildIndex;
                leftChildIndex = (2 * currentIndex) + 1;
                rightChildIndex = (2 * currentIndex) + 2;
            } else {
                break;
            }
        }
        return root;
    }

    public T peek() {
        if (arr.isEmpty()) {
            return null;
        }
        return arr.get(0);
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    private void swapNodes(int currentIndex, int secondIndex) {
        T temp = arr.get(secondIndex);
        arr.set(secondIndex, arr.get(currentIndex));
        arr.set(currentIndex, temp);
    }
}
