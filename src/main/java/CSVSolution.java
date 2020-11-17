import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVSolution {
        boolean isValid(String strToCheck){
            if (strToCheck.isEmpty())return false;
            return true;
        }

        String iterateThroughCSV(String[] rowsFromInString){
            StringBuilder ans = new StringBuilder();
//        append the header cuz no matter what it's good
            ans.append(rowsFromInString[0]+"\n");
            for (int i = 1; i<rowsFromInString.length;i++){
//            splice it again to get the columns from the row
                String[] rowSplitByColumns = rowsFromInString[i].split(",");
                if(!rowContainsNULL(rowSplitByColumns)){
                    ans.append(rowsFromInString[i]+ "\n");
                }
            }
//        remove the new line character
            ans.delete(ans.length()-1,ans.length());
            return ans.toString();
        }

        boolean rowContainsNULL(String[] row){
            for (String value: row){
                if (value.equals("NULL")){
                    return true; //let's us skip the rest since we only need one NULL to remove a row
                }
            }
            return false;
        }

        public String solution(String S) {
//        check if S is longer than 0 first off, if not return it automatically
            if (!isValid(S)) return "";
//        split the CSV to an array of rows (represented by Strings) via \n
            String[] rowsFromS = S.split("\n");
//        iterate through and append only if row doesn't include NULL
            return iterateThroughCSV(rowsFromS);
        }

        @Test
        void testNullRemoval(){
            assertEquals("header,header\nANNUL,ANNULLED\nnull,NILL", this.solution("header,header\nANNUL,ANNULLED\nnull,NILL\nNULL,NULL"));
            assertEquals("id,name,age,score\n17,Betty,28,11", this.solution("id,name,age,score\n1,Jack,NULL,12\n17,Betty,28,11"));
            assertEquals("id,name,age,score\n17,Betty,28,11", this.solution("id,name,age,score\n1,Jack,NULL,12\nNULL,Suzie,28,11\n17,Betty,28,11"));
            assertEquals("header,header\nANNUL,ANNULLED\nnull,NILL", this.solution("header,header\nANNUL,ANNULLED\nnull,NILL\nNULL,NULL"));
            assertEquals("", this.solution(""));
            assertEquals("header\nnull\nbob", this.solution("header\nNULL\nnull\nbob"));
            assertEquals("header,header\nnull,NIL\nbob,ROB", this.solution("header,header\nnull,NIL\nbob,ROB"));
            assertEquals("header,header", this.solution("header,header\nNULL,NULL\nNULL,NULL"));
        }

        public static void main(String[] args) {
            CSVSolution newSol = new CSVSolution();
//        I After analyzing the code that I submitted to problem 2 I realized, in trying to simplify the process I made it more complicated.
//        So instead of regex like I had originally done, I decided to split the CSV twice- first by \n and then by comma.
//        Other changes include: cleaning the code into four bite sized functions and including new test cases.
//        In total my edits have made it easier to comprehend, increases performance, and improves the accurateness of the solution.
            newSol.testNullRemoval();
        }
}
