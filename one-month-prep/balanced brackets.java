import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static String isBalanced(String s) {

        // Convert string to character array
        char[] array = s.toCharArray();
        
        List<Character> list = new ArrayList<>();

        // Return "NO" if starting bracket is closing bracket
        if (array[0] == ')' || array[0] == '}' || array[0] == ']') {
            return "NO";
        }
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ')' && array[i] != '}' && array[i] != ']') {
                list.add(array[i]);
            } else if (list.size() == 0) {
                return "NO";
            } else {
                char lastBreacket = list.get(list.size()-1);
                if (lastBreacket == '(' && array[i] != ')') {
                    return "NO";
                } else if (lastBreacket == '{' && array[i] != '}') {
                     return "NO";
                } else if (lastBreacket == '[' && array[i] != ']') {
                     return "NO";
                } else {
                    list.remove(list.size()-1);
                }
            }
        }

        if (list.size() == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
