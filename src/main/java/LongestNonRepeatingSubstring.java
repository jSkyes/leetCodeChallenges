import org.junit.jupiter.api.Test;

import java.util.Dictionary;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class LongestNonRepeatingSubstring {

    boolean checkIfValid(String stringToCheck){
        if (stringToCheck.length()==0) return false;
        else return true;
    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        if (!checkIfValid(s)) return ans;
        if(s.length() == 1) return 1;
        char[] inputtedStringAsCharAr = s.toCharArray();
//        used to store the chars and the position the char is at
        HashMap<Character, Integer> dictOfCharsInSubString = new HashMap<>();
        int len = 0;

        for (int i = 0 ; i < s.length(); i++){
//            check if in map
            if (!dictOfCharsInSubString.containsKey(inputtedStringAsCharAr[i])){
//                good, lets add it and the index
                dictOfCharsInSubString.put(inputtedStringAsCharAr[i],i);
                len = len+1;
            }else{
//            if it is ruh roh raggy- it's a duplicate
//                 reset i to it's location last location +1, compare lens, wipe, cont
                i = dictOfCharsInSubString.get(inputtedStringAsCharAr[i]);
                len = 0;
                dictOfCharsInSubString.clear();
            }
            if (len > ans){
                ans = len;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestNonRepeatingSubstring newSol = new LongestNonRepeatingSubstring();
        assertEquals(3,newSol.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1,newSol.lengthOfLongestSubstring("bbbbbbbbbbbb"));
        assertEquals(3,newSol.lengthOfLongestSubstring("pwwkew"));
        assertEquals(0,newSol.lengthOfLongestSubstring(""));
        assertEquals(4,newSol.lengthOfLongestSubstring("12ghg44"));
        assertEquals(5,newSol.lengthOfLongestSubstring("h g44 12g "));
        assertEquals(1,newSol.lengthOfLongestSubstring(" "));
        assertEquals(2,newSol.lengthOfLongestSubstring("au"));

//        newSol.lengthOfLongestSubstring("au");
//        System.out.println("Expected answer is: 2\n---------------------------------");
    }
}
