import java.util.HashMap;

public class SocialSolution {
    boolean checkIfValid(int[] arToCheck){
        if (arToCheck.length==0)return false;
        return true;
    }
    public int solution(int[] A) {
        if(!checkIfValid(A))return 0;
        int ans = 0;
        HashMap<Integer, Integer> occurrencesOfIntInAr = new HashMap<>();
        for (int i = 0; i < A.length; i++){
            if (occurrencesOfIntInAr.containsKey(A[i])){
                occurrencesOfIntInAr.replace(A[i],(occurrencesOfIntInAr.get(A[i])+1));
            }else{
                occurrencesOfIntInAr.put(A[i],1);
            }
        }
        for (Integer key : occurrencesOfIntInAr.keySet()) {
            Integer val = occurrencesOfIntInAr.get(key);
            if (val>=2){
//                we're trying to find the combination!
                int numerator = 1;
                int demoninator = 1;
                for (int i = 1; i<= val; i++){
                    numerator = numerator * i;
                }
                System.out.println("This is num: " + numerator);

                for (int i = val-2; i>=1; i--){
                    demoninator = demoninator *i;
                }
                demoninator = demoninator*2;
                System.out.println("This is demoni: " + demoninator);
                System.out.println("Num/dom = " + (numerator/demoninator));

                ans = ans + (numerator/demoninator);
            }
            if (ans == 1000000000){
//                we've reached the max, we don't care anymore
                break;
            }
        }
        System.out.println("Ans is: " + ans);
        return ans;
    }

    public static void main(String[] args) {
        SocialSolution newSol = new SocialSolution();

        newSol.solution(new int[]{3,5,6,3,3,5});
        System.out.println("Expected answer is: 4\n---------------------------------");

        newSol.solution(new int[]{3,3,4,4});
        System.out.println("Expected answer is: 2\n---------------------------------");

        newSol.solution(new int[]{3,3,1,4,4,1,1});
        System.out.println("Expected answer is: 5\n---------------------------------");

        newSol.solution(new int[]{3,3,3,3,1,4,4,1,1});
        System.out.println("Expected answer is: 10\n---------------------------------");

        newSol.solution(new int[]{});
        System.out.println("Expected answer is: 0\n---------------------------------");
    }
}
