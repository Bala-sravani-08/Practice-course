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
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int k, List<String> grid) {
        int n = grid.size();
        int m = grid.get(0).length();
        if (k == 1) {
            return grid;
        }
        if (k % 2 == 0) {
            return gridToList(createAllBombGrid(n, m));
        } else {
            char[][] result = blast(listToGrid(grid), n, m);
            if ((k / 2) % 2 == 0) {
                result = blast(result, n, m);
            }
            return gridToList(result);
        }
    }

    private static char[][] blast(char[][] grid, int n, int m) {
        char[][] result = createAllBombGrid(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O') {
                    result[i][j] = '.';
                    if (j + 1 < m) {
                        result[i][j + 1] = '.';
                    }
                    if (j - 1 >= 0) {
                        result[i][j - 1] = '.';
                    }
                    if (i + 1 < n) {
                        result[i + 1][j] = '.';
                    }
                    if (i - 1 >= 0) {
                        result[i - 1][j] = '.';
                    }
                }
            }
        }
        return result;
    }

    private static char[][] createAllBombGrid(int n, int m) {
        char[][] result = new char[n][m];
        for (int i = 0; i < n; i++) {
            result[i] = new char[m];
            Arrays.fill(result[i], 'O');
        }
        return result;
    }

    private static char[][] listToGrid(List<String> list) {
        char[][] arr = new char[list.size()][list.get(0).length()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i).toCharArray();
        }
        return arr;
    }

    private static List<String> gridToList(char[][] grid) {
        List<String> result = new ArrayList<>();
        for (char[] arr : grid) {
            result.add(new String(arr));
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
