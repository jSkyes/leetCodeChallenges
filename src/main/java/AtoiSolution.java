import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AtoiSolution {
    boolean checkValidFirst(char[] inputStrToCharAr){
        boolean ans = true;
        if (inputStrToCharAr.length == 0){
            ans = false;
        }else if(inputStrToCharAr.length == 1){
//            only way this works is if digit
            if(!Character.isDigit(inputStrToCharAr[0])){
                ans = false;
            }
        }else{
//            everything is on the table, gotta check em all
            ans = checkIfValid(inputStrToCharAr[0]);
        }
        return ans;
    }

    char[] cropStartingZeros(char[] inputStrToCharAr){
        StringBuilder ans = new StringBuilder();
        int index = 0;
        if (checkPlusMinusNeither(inputStrToCharAr[0]) != 0){
//            its a +/-
            index = 1;
            ans.append(inputStrToCharAr[0]);
        }
//        increment through till we reach another num != 0
        while (index < inputStrToCharAr.length && isDigit(inputStrToCharAr[index]) && Character.getNumericValue(inputStrToCharAr[index]) == 0){
            index = index +1;
        }
//        append the rest IF THERE IS ANY
        for (int i = index; i<inputStrToCharAr.length; i++){
            if(isDigit(inputStrToCharAr[i])) ans.append(inputStrToCharAr[i]);
            else {
//                we have a problem houston
                return ans.toString().toCharArray();
            }
        }
        return ans.toString().toCharArray();
    }

    boolean checkIfValid(char charToCheck){
        boolean ans = true;
        if (!Character.isDigit(charToCheck)){
//            might be a plus/minus
            if(checkPlusMinusNeither(charToCheck) == 0){
                ans = false;
            }
        }
        return ans;
    }

    boolean isDigit(char charToCheck){
        boolean ans = true;
        if (!Character.isDigit(charToCheck)){
//            might be a plus/minus
            ans =false;
        }
        return ans;
    }

    //    0 if neither, 1 if +, -1 if -
    int checkPlusMinusNeither(char charToCheck){
        if (charToCheck == '-') return -1;
        else if (charToCheck == '+') return 1;
        else return 0;
    }

    int ifOverMinMax(long valueOfString){
        if (valueOfString >= 2147483647){
            return 2147483647;
        }else if(valueOfString < -2147483647){
            return -2147483648;
        }else{
            return (int) valueOfString;
        }
    }

    public int[] discoverHowLongNumIs(char[] inputStr){
        int size[] = new int[]{0,0};
        if (checkPlusMinusNeither(inputStr[size[0]]) == 1){
            size[0] = size[0]+1;
            size[1]= 1;
        }else if (checkPlusMinusNeither(inputStr[size[0]]) == -1){
            size[0] = size[0]+1;
            size[1]= -1;
        }
        while (size[0] < inputStr.length-1 && isDigit(inputStr[size[0]])){
            size[0] = size[0] + 1;
            if (size[0] > 12)break;
        }
        return size;
    }

    public long convert(char[] inputStr){
        int[] detailsOfLengthAndMore = discoverHowLongNumIs(inputStr);
        int size = detailsOfLengthAndMore[0];
        int endpoint = 0;
        if (!checkIfValid(inputStr[size])){
            size = size-1;
        }
        if (detailsOfLengthAndMore[1] == 1 || detailsOfLengthAndMore[1] == -1) {
            endpoint = 1;
        }
        long ans = 0;
        long valueAtPoint = 0;
        long valueSpot = 1;
        for (int i = size; i>= endpoint; i= i-1){
            if (!isDigit(inputStr[i])) return 0;
            valueAtPoint = Character.getNumericValue(inputStr[i]) * valueSpot;
            valueSpot = valueSpot*10;
            ans = valueAtPoint + ans;
        }
        if (endpoint ==1){
            if (detailsOfLengthAndMore[1] == -1){
                ans = ans * -1;
            }
        }
        ans = ifOverMinMax(ans);
        return ans;
    }

    public int myAtoi(String s) {
        long ans = 0;
        char[] inputStr = s.trim().toCharArray();
        boolean isValid = checkValidFirst(inputStr);
        if (checkValidFirst(inputStr)){
//            we know we're cooking with gas, let's start getting sizes and converting
            inputStr = cropStartingZeros(inputStr);
            if (!checkValidFirst(inputStr)) return 0;
            ans = convert(inputStr);
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        AtoiSolution newSol = new AtoiSolution();
        assertEquals(2147483647, newSol.myAtoi("9223372036854775808"));
        assertEquals(0, newSol.myAtoi("-"));
        assertEquals(0, newSol.myAtoi("         bab "));
        assertEquals(0, newSol.myAtoi("ba     "));
        assertEquals(75808, newSol.myAtoi("75808dad6"));
        assertEquals(0, newSol.myAtoi("- 543543543"));
        assertEquals(0, newSol.myAtoi("- 54354 +3543"));
        assertEquals(0, newSol.myAtoi("word"));
        assertEquals(-2147483648, newSol.myAtoi("-9223372036854775808"));
        assertEquals(4, newSol.myAtoi("4"));
        assertEquals(0, newSol.myAtoi("+-12"));
        assertEquals(12345678, newSol.myAtoi("  0000000000012345678"));
        assertEquals(2147483647, newSol.myAtoi("21474836460"));
        assertEquals(0, newSol.myAtoi("00000-42a1234"));
    }
}
