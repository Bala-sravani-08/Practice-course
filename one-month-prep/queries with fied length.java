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
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY queries
     */

    public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
    // Write your code here
     List<Integer> result = new ArrayList<Integer>();
    
        int l = arr.size();
        for(Integer d :queries){
            Queue<Integer> qu = new LinkedList<>();
            int myMin=Integer.MAX_VALUE;
            
            for(int i = 0; i < l; i++){
                if(qu.size() == d) {
                    qu.remove();
                    if (qu.size() > 0) {
                        int cMax = qu.peek();
                        for (int e : qu) {
                            if (e >= cMax) {
                                cMax = e;
                            }
                        }
                        while (qu.peek() < cMax) {
                            qu.remove();
                        }
                    }
                }
                while(qu.size() > 0 && arr.get(i) >= qu.peek()){
                    qu.remove();
                }
                qu.add(arr.get(i));
                int m = qu.peek();
                if(m < myMin && i >= d - 1){
                    myMin=m;
                }
            }
            result.add(myMin);
        }
        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.solve(arr, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
