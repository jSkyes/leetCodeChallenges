import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class TwoSum {
//    since constraints say that input has to be longer than 2 no need to check for null
//    constraints also say only one answer exists so moment we find we can dump
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.sort(nums);
        int indexOfSecondVal = nums.length-1;
        for (int i = 0; i < indexOfSecondVal; i++){
            if (nums[i] + nums[indexOfSecondVal] == target){
                ans[0] = i;
                ans[1] = indexOfSecondVal;
                System.out.println("Value 1 Index: " + ans[0]+". Value of Index1: " + nums[ans[0]]);
                System.out.println("Value 2 Index: " + ans[1]+". Value of Index2: " + nums[ans[1]]);
                return ans;
            }
            indexOfSecondVal--;
        }
        return ans;
    }

    public static void main(String[] args) {
        TwoSum newSol = new TwoSum();

        newSol.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println("Expected answer is: 0, 1. Target: 9\n---------------------------------");

        newSol.twoSum(new int[]{3,2,4}, 6);
        System.out.println("Expected answer is: 1, 2. Target: 6\n---------------------------------");

        newSol.twoSum(new int[]{3,3}, 6);
        System.out.println("Expected answer is: 0,1. Target: 6\n---------------------------------");

        newSol.twoSum(new int[]{-5,0,16,8}, 11);
        System.out.println("Expected answer is: 0, 2. Target: 11\n---------------------------------");

//        newSol.twoSum(new int[]{}, 0);
//        System.out.println("Expected answer is: 0.0\n---------------------------------");
    }
}
