package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetSubsets {
    public static void main(String[] args) {
        int[] up = {4,1,2,3,1};
        int target = 4;
        Arrays.sort(up);
        targetSubsets(up, target, "", 0);
    }

    private static void targetSubsets(int[] up, int target, String p, int index) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i=index; i<up.length; i++) {
            if (up[i] > target)
                continue;

            if (i > index && up[i] == up[i-1]) //i>index instead of i>0 makes sure it wont consider a duplicate element in the first iteration. the same elements can
                continue;                      // occur in the together though

            targetSubsets(up, target - up[i], p + up[i], i + 1);
        }
    }
}
