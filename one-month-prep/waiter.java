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
    public static List<Integer> waiter(List<Integer> numbers, int q) {
        boolean[] primes = new boolean[10000];
        
        Arrays.fill(primes, true); 

        int count = 0; 
        for(int i = 2;count < q; ++i){
            if(primes[i]){
                count++; 
                for(int j = i*i; j < 10000; j += i){
                    primes[j] = false; 
                }
            }
        }
        
        int p = 2; 
        List<Integer> ans = new LinkedList<>();
        boolean flag = true; 
        
        for(int i = 0;i < q; ++i){
            if(flag){
                for(int j = 0;j < numbers.size(); ++j){
                    if(numbers.get(j) % p == 0){
                        ans.add(numbers.get(j));
                        numbers.set(j, 1);                      
                    }       
                }
                flag = false; 
            }    
            
            else{
                for(int j = numbers.size()-1; j >= 0; --j){
                    if(numbers.get(j) % p == 0){
                        ans.add(numbers.get(j)); 
                        numbers.set(j, 1); 
                    }
                }
                flag = true; 
            }
            p++;
            while(primes[p] == false) p++; 
        }
        
        if(!flag){
            for(Integer i : numbers){
                if(i != 1){
                    ans.add(i);
                }
            }
        }
        
        else{
            for(int i = numbers.size()-1; i>= 0; --i){
                if(numbers.get(i) != 1) ans.add(numbers.get(i));
            }
        }
        
        return ans; 
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.waiter(number, q);

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
