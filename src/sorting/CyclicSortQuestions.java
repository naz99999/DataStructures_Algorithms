package sorting;
import java.util.ArrayList;
import java.util.List;
public class CyclicSortQuestions {

    //https://leetcode.com/problems/first-missing-positive/
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] <= 0) {
                i++;
            } else if (correct < nums.length && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }
 
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                return k + 1;
            }
        }
        return nums.length + 1;
    }

    //https://leetcode.com/problems/set-mismatch/
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (k != nums[k] - 1) {
                return new int[] {nums[k], k + 1};
            }
        }
        return new int[] {-1, -1};
    }

    //https://leetcode.com/problems/find-all-duplicates-in-an-array/
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != i + 1) {
                if (nums[i] != nums[correct]) {
                    int temp = nums[correct];
                    nums[correct] = nums[i];
                    nums[i] = temp;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                ans.add(nums[k]);
            }
        }
        return ans;
    }

    //https://leetcode.com/problems/find-the-duplicate-number/
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        return nums[nums.length - 1];
    }

    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                ans.add(j + 1);
            }
        }

        return ans;
    }

    //https://leetcode.com/problems/missing-number/
    public int missingNumber2(int[] nums) {//KK Approach
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == nums.length) {
                i++;
            }
            else if (i != nums[i]) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k) {
                return k;
            }
        }
        return nums.length;
    }

    //https://leetcode.com/problems/missing-number/
    public int missingNumber(int[] nums) {//NAZ MAST APPROACH
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                i++;
            } else if (i != nums[i] - 1) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == 0) {
                return k + 1;
            }
        }
        return 0;
    }
}
