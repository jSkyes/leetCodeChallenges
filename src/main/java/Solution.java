import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the function below.
     */
     static int parseOperation(String command){
//        returns a 0 if push, 1 if pop, and 2 if inc
        if (command.contains("push")){
            return 0;
        }else if (command.equals("pop")){
            return 1;
        }else{
            return 2;
        }
    }

    static void stackSwap(Stack<Integer> stack, int spotsToInc, int valToInc){
//         two stacks to increment
        Stack<Integer> secStack = new Stack<>();
        int counter = 0;
        while(!stack.empty()){
            secStack.push(stack.pop());
        }
        while(!secStack.empty()){
            if(counter != spotsToInc){
                int temp = valToInc+ secStack.pop();
                stack.push(temp);
                System.out.println("im temp "+ temp);
                counter++;
            }else{
                int temp = secStack.pop();
                System.out.println("im temp "+ temp);
                stack.push(temp);
            }
        }
    }


    static void superStack(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String command: operations){
            int commandType = parseOperation(command);
            if (commandType == 0){
                int toAdd = Integer.parseInt(command.split(" ")[1]);
                stack.push(toAdd);
                System.out.println(stack.peek());
            }else if(commandType ==1){
//                its a pop
                stack.pop();
                try{
                    System.out.println(stack.peek());
                }catch (EmptyStackException e){
                    System.out.println("EMPTY");
                }
            }else{
//                its increment
//                    break down the vals
                if(stack.empty()){
                    System.out.println("EMPTY");
                    break;
                }
                String[] commandBreakdown = command.split(" ");
                int spotsToInc = Integer.parseInt(commandBreakdown[1]);
                int valToInc = Integer.parseInt(commandBreakdown[2]);
                stackSwap(stack, spotsToInc, valToInc);
                System.out.println(stack.peek());
            }
        }
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
    public static void main(String[] args)  {
//        Scanner in = new Scanner(System.in);
//        int operations_size = 0;
//        operations_size = Integer.parseInt(in.nextLine().trim());
//
//        String[] operations = new String[operations_size];
//        for(int i = 0; i < operations_size; i++) {
//            String operations_item;
//            try {
//                operations_item = in.nextLine();
//            } catch (Exception e) {
//                operations_item = null;
//            }
//            operations[i] = operations_item;
//        }
//
//        superStack(operations);
        Solution newSol = new Solution();
//        superStack(new String[]{""});
    }
}