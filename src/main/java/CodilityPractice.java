import java.util.Arrays;

public class CodilityPractice {
    boolean isValid(int[] arrayToCheck){
        if (arrayToCheck.length == 0){
            return false;
        }
        return true;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int ans = 1;
        if (!isValid(A)) return 1;
//        sort the array first to make binary search fast
        Arrays.sort(A);
        int indexOfZero = 1;
//        lets find it
        while (indexOfZero >= 0){
            indexOfZero = Arrays.binarySearch(A, ans);
//            increment to check the next one
            ans++;
        }
//        decrement because we auto add even if we failed to find
        ans--;
        return ans;
    }

    public static void main(String[] args) {
        CodilityPractice newSol = new CodilityPractice();
        newSol.solution(new int[]{-1,-3});
        System.out.println("Expected answer is: 1\n---------------------------------");

        newSol.solution(new int[]{1, 2, 3});
        System.out.println("Expected answer is: 4\n---------------------------------");

        newSol.solution(new int[]{1, 3, 6, 4, 1, 2});
        System.out.println("Expected answer is: 5\n---------------------------------");

        newSol.solution(new int[]{});
        System.out.println("Expected answer is: 1\n---------------------------------");
    }
}
