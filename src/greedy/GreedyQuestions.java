package greedy;

import java.util.*;

public class GreedyQuestions {
    public static void main(String[] args) {
        int n = 3;
        Item[] arr = new Item[n];
        arr[0] = new Item(60, 10);
        arr[1] = new Item(100, 20);
        arr[2] = new Item(120, 30);
        //System.out.println(fractionalKnapsack(50, arr, n));

        Job[] arr2 = new Job[7];
        arr2[0] = new Job(1, 3, 35);
        arr2[1] = new Job(2, 4, 30);
        arr2[2] = new Job(3, 4, 25);
        arr2[3] = new Job(4, 2, 20);
        arr2[4] = new Job(5, 3, 15);
        arr2[5] = new Job(6, 1, 12);
        arr2[6] = new Job(7, 2, 5);

        System.out.println(JobScheduling(arr2, 7));
    }

    static class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    public static class jobComparator1 implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            return o2.profit - o1.profit;
        }
    }

    static int[] JobScheduling(Job arr[], int n)
    {
        int totalTime = 0;
        for (int i = 0; i < n; i++) {
            totalTime = Math.max(totalTime, arr[i].deadline);
        }
        Arrays.sort(arr, new jobComparator1());

        int[] jobSlots = new int[totalTime];
        for (int i = 0; i < totalTime; i++) {
            jobSlots[i] = 0;
        }

        int jobsDone = 0, maxProfit = 0;

        for (int i = 0; i < n; i++) {
            int jobSlotIndex = arr[i].deadline - 1;
            if (jobSlots[jobSlotIndex] == 0) {
                jobSlots[jobSlotIndex] = i;
                maxProfit += arr[i].profit;
            } else {
                for (int j = jobSlotIndex - 1; j >= 0; j--) {
                    if (jobSlots[j] == 0) {
                        jobSlots[j] = i;
                        maxProfit+=arr[i].profit;
                        break;
                    }
                }
            }
        }

        for (int jobSlot : jobSlots) {
            if (jobSlot != 0) {
                jobsDone++;
                maxProfit += jobSlot;
            }
        }
        return new int[] {jobsDone, maxProfit};
    }

    //https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
    static class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            double vpw1 = (double)o1.value / (double)o1.weight;
            double vpw2 = (double)o2.value / (double)o2.weight;
            if (vpw2>vpw1) return 1;
            else if (vpw1>vpw2) return -1;
            else return 0;
        }
    }
    static double fractionalKnapsack(int w, Item arr[], int n) {
        Arrays.sort(arr, new ItemComparator());

        double maxValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (arr[i].weight <= w) {
                w = w - arr[i].weight;
                maxValue += arr[i].value;
            } else {
                maxValue += ((double)arr[i].value / (double)arr[i].weight) * (double)w;
                break;
            }
        }
        return maxValue;
    }
}



























