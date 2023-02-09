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

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
    // Write your code here
     Map<Character, Integer> charFreqMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int freq = charFreqMap.getOrDefault(c, 0);
      charFreqMap.put(c, ++freq);
    }

    int[] arr = new int[charFreqMap.size()];
    int idx = 0;
    for (Map.Entry<Character, Integer> characterIntegerEntry : charFreqMap.entrySet()) {
      arr[idx++] = characterIntegerEntry.getValue();
    }
    Arrays.sort(arr);

    if (charFreqMap.size() == 1) return "YES";

    int first = arr[0];
    int second = arr[1];
    int secondLast = arr[arr.length - 2];
    int last = arr[arr.length - 1];

    if (first == last) return "YES";

    if (first == 1 && second == last) return "YES";

    if (first == second && second == secondLast && secondLast == (last - 1)) return "YES";

    return "NO";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
