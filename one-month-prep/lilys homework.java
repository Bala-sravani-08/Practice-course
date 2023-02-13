import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static int lilysHomework(int arr[], int arr2[]) 
        {        
        boolean isIdentical = true;
        Map<Integer, Integer> locations = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            locations.put(arr[i], i);
            if (arr[i]!=arr2[i])
            {
                isIdentical = false;
            }
        }
        int swapCount=0;
        if (isIdentical)
        {
            return swapCount;
        }
        for (int i=0; i<arr.length; i++)
        {
            if (arr[i]!=arr2[i])
            {
                int arrIndex = locations.get(arr2[i]);
                locations.put(arr[i], arrIndex);
                
                int temp = arr[i];
                arr[i]= arr2[arrIndex];
                arr[arrIndex] = temp;
                
                swapCount++;
            }
        }
        return swapCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int numberOfElements = scn.nextInt();

        int[] values = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            int value = scn.nextInt();
            values[i] = value;
        }
        int valuesCopy[] = values.clone();
        int sortedArray[] = values.clone();
        
        Arrays.sort(sortedArray);
        
        int[] reverseSortedArray = IntStream.range(0, sortedArray.length)
                          .map(i -> sortedArray[sortedArray.length-i-1])
                          .toArray();
        int regArraySwapCount = Result.lilysHomework(values, sortedArray);
        
        int reverseArraySwapCount = Result.lilysHomework(valuesCopy, reverseSortedArray);
        
        int result = Math.min(regArraySwapCount, reverseArraySwapCount);
        System.out.println(result);
       
    }
}
