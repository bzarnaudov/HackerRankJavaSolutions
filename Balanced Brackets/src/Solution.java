import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        if (s.length() % 2 != 0){
            return "NO";
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String ch = "" + s.charAt(i);
            if ("{".equals(ch) || "[".equals(ch) || "(".equals(ch)) {
                stack.push(ch);
            }
            if ("}".equals(ch) || "]".equals(ch) || ")".equals(ch)) {
                if (stack.isEmpty()){
                    return "NO";
                }
                String peekCh = stack.peek();
                if ("{".equals(peekCh) && "}".equals(ch)) {
                    stack.pop();
                }
                if ("[".equals(peekCh) && "]".equals(ch)) {
                    stack.pop();
                }
                if ("(".equals(peekCh) && ")".equals(ch)) {
                    stack.pop();
                }
            }
            if (stack.size() > s.length()/2){
                return "NO";
            }
        }
        if (s.length() > 0 && stack.isEmpty()){
            return "YES";
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}