import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseIntegerSolution {

    boolean isNeg(int numToCheck){
        if (numToCheck < 0){
            return true;
        }
        return false;
    }

    boolean isEligible(char[] inputedNumber){
        if (inputedNumber.length != 0) return true;
        else if(inputedNumber.length > 12) return false;
        else return false;
    }

    int ifOverMinMax(long valueToCheck){
        if (valueToCheck >= 2147483647 || valueToCheck < -2147483647){
            return 0;
        }else{
            return (int) valueToCheck;
        }
    }

    public int reverse(int x) {
        long ans = 0;
        boolean isNeg = isNeg(x);
        char[] inputedNumber = ((Integer) x).toString().toCharArray();

        if (!isEligible(inputedNumber)) return 0;

        long tensPlace = (long) Math.pow(10.00, inputedNumber.length-1);
        int endpoint = 0;
        if (isNeg){
            endpoint = 1;
            tensPlace = tensPlace/10;
        }
        for(int i = inputedNumber.length-1; i>=endpoint; i--){
            ans = ans + (Character.getNumericValue(inputedNumber[i]) * tensPlace);
//            increment the tens place
            tensPlace = tensPlace/10;
        }
        if (isNeg){
            ans = ans *-1;
        }
        ans = ifOverMinMax(ans);
        return (int) ans;
    }

    public static void main(String[] args) {
        ReverseIntegerSolution newSol = new ReverseIntegerSolution();
        assertEquals(321, newSol.reverse(123));
        assertEquals(-321, newSol.reverse(-123));
        assertEquals(21, newSol.reverse(120));
        assertEquals(0, newSol.reverse(0));
        assertEquals(0, newSol.reverse(1534236469));
        assertEquals(0, newSol.reverse(-1534236469));
    }
}
