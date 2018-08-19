import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        Map<Integer, Integer> numberToIndex = IntStream.range(0, arr.length).boxed()
                .collect(Collectors.toMap(i -> arr[i], Function.identity()));

        int swapNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                if (numberToIndex.get(i + 1) != null) {
                    int otherIndex = numberToIndex.get(i + 1);

                    numberToIndex.put(arr[i], otherIndex);
                    numberToIndex.put(i + 1, i);

                    swap(arr, i, otherIndex);

                    swapNum++;
                }
            }
        }
        return swapNum;

    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}