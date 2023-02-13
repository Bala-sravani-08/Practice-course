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
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

   public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int sumOfBribes = 0;

        for (int i = q.size(); i > 0; i--) {
            Integer currentNumber = q.get(i - 1);

            // If stays on it's natural position
            if (i == currentNumber) {
                continue;
            }

            // If difference is only one number
            if (q.get(i - 2) == i) {
                Collections.swap(q, i - 2, i - 1);
                sumOfBribes++;
                continue;
            }

            // If difference is two numbers
            if (q.get(i - 3) == i) {
                Collections.swap(q, i - 3, i - 2);
                sumOfBribes++;
                Collections.swap(q, i - 2, i - 1);
                sumOfBribes++;
                continue;
            }

            System.out.println("Too chaotic");
            return;
        }

        System.out.println(sumOfBribes);
    }
}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
