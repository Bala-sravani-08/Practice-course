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
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */

    public static void noPrefix(List<String> words) {
    // Write your code here
     TreeSet<String> treeSet = new TreeSet<String>();
    for (String word : words) {

        if (treeSet.add(word)) {

            String nextElement = treeSet.higher(word);
            String prevElement = treeSet.lower(word);

            if (prevElement != null && word.startsWith(prevElement)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }

            if (nextElement != null && nextElement.startsWith(word)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }



        } else {
            System.out.println("BAD SET");
            System.out.println(word);
            return;
        }
    }
    System.out.println("GOOD SET");

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        Result.noPrefix(words);

        bufferedReader.close();
    }
}
