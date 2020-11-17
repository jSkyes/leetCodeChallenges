import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz {
    public static void fizzBuzz(int n) {
        // Write your code here
        boolean fizz, buzz;
        for (int i = 1; i<= n; i++){
            fizz = false;
            buzz = false;
            if (i% 3 ==0){
//            multiple of 3
                fizz = true;
            }
            if (i% 5 == 0){
                buzz = true;
            }
            if (fizz & buzz){
                System.out.println("FizzBuzz");
            }else if(fizz){
                System.out.println("Fizz");
            }else if(buzz){
                System.out.println("Buzz");
            }else {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FizzBuzz newSol = new FizzBuzz();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        newSol.fizzBuzz(n);

        bufferedReader.close();
    }
}
