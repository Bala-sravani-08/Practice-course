import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
         Stack<String> stack = new Stack<>();
         int totalOp = Integer.parseInt(bufferedReader.readLine().trim());
         StringBuilder builder = new StringBuilder();
         
         while (totalOp-- > 0) {
            
             String s = bufferedReader.readLine().trim();
             int operation = Integer.parseInt(s.substring(0, 1));
             
             switch (operation) {
                case 1: {
                    String value = s.substring(2, s.length());
                    stack.push(builder.toString());
                    builder.append(value);
                    break;
                } 
                case 2: {
                    stack.push(builder.toString());
                    String value = s.substring(2, s.length());
                    int index = Integer.parseInt(value);
                    builder.delete(builder.length()-index, builder.length());
                    break;
                }
                case 3: {
                    String value = s.substring(2, s.length());
                    int index = Integer.parseInt(value);
                    System.out.println(builder.charAt(index-1));
                    break;
                } 
                case 4: {
                    StringBuilder b = new StringBuilder(stack.pop());
                    builder = b;
                    break;
                } 
            }
        }
        bufferedReader.close();
    }
}
