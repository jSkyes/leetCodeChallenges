import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MedianTwoSortAr {

    int[] combineArrays(int[] nums1, int[] nums2) {
//        check if any are empty, if so just return the other
        if (nums1.length ==0){
            return nums2;
        }else if (nums2.length == 0){
            return nums1;
        }
        int[] ans = new int[nums1.length+nums2.length];
        System.arraycopy(nums1, 0, ans, 0,nums1.length);
        System.arraycopy(nums2, 0, ans, nums1.length,nums2.length);
        Arrays.sort(ans);
        return ans;
    }

    boolean checkIfValid(int[] nums1, int[] nums2){
        if (nums1 == null && nums2 == null) return false;
        if (nums1.length == 0 && nums2.length == 0) return false;
        else return true;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(!checkIfValid(nums1,nums2)) return 0;
//        else lets get crackalackin
        double ans = 0;
        int[] combinedAr = combineArrays(nums1,nums2);
        if (combinedAr.length%2 == 0){
            //even we need to divy up two nums
            ans = ((double) combinedAr[combinedAr.length/2] + (double)combinedAr[(combinedAr.length/2)-1])/2;
        }else{
            //let's just grab and go folks!
            ans = combinedAr[combinedAr.length/2];
        }
        return ans;
    }

    public static void main(String[] args) {
        MedianTwoSortAr newSol = new MedianTwoSortAr();
        assertEquals(2.0,newSol.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        assertEquals(2.5,newSol.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        assertEquals(0.0,newSol.findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));
        assertEquals(1.0,newSol.findMedianSortedArrays(new int[]{},new int[]{1}));
        assertEquals(2.0,newSol.findMedianSortedArrays(new int[]{2},new int[]{}));
        assertEquals(0.0,newSol.findMedianSortedArrays(new int[]{}, new int[]{}));
//        newSol.findMedianSortedArrays(new int[]{}, new int[]{});
//        System.out.println("Expected answer is: 0.0\n---------------------------------");
    }
}
