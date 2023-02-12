import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
                Scanner scanner = new Scanner(System.in);
        final Integer numQueries = Integer.valueOf(scanner.nextLine());
        TreeSet<Integer> heap = new TreeSet<Integer>();
        while (scanner.hasNext()) {
            final Integer operation = scanner.nextInt();
            if (operation.equals(1)) {
                heap.add(scanner.nextInt());
            } else if (operation.equals(2)) {
                heap.remove(scanner.nextInt());
            } else if (operation.equals(3)) {
                System.out.println(heap.first());
            } else {
                throw new RuntimeException("operation: " + operation + " should be 1,2 or 3.");
            }
        }
    }
}
