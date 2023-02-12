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
     * Complete the 'hackerlandRadioTransmitters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY x
     *  2. INTEGER k
     */

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
    // Write your code here
     x.sort(null); // O(nlogn)?
        int sz = x.size();
        
        int tot = 0;
        int i = 0;
        
        while (i < sz) {  // + O(n)
            int fh = x.get(i); // gets a first house
            ++i; // goes to the next house
            while ((i < sz) && ((fh + k) >= (int) x.get(i))) {
                ++i;
            } // we keep going until fh out of range
            --i; // we back up into range
            ++tot;
            int loc = x.get(i); // we place the tower
            ++i; // we go to the next place
            while (i < sz && ((loc + k) >= (int) x.get(i))) {
                ++i;
            } // we keep going until out of range
        } // after which we're either done, or get a new first house.
        return tot;
    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> x = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.hackerlandRadioTransmitters(x, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
