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
     * Complete the 'textFormatting' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY starting
     *  2. INTEGER_ARRAY ending
     *  3. CHARACTER_ARRAY style
     */

    public static int textFormatting(List<Integer> starting, List<Integer> ending, List<Character> style) {
    // Write your code here
        HashMap<Character, List<int[]>> map = new HashMap<>();
        // put all info in the map
        int n = starting.size();
        for (int i = 0; i < n; ++i) {
            char c = style.get(i);
            map.computeIfAbsent(c, x -> new ArrayList<>()).add(new int[] {starting.get(i), ending.get(i)});
        }
        for (char c : map.keySet()) {
            List<int[]> cur = map.get(c);
            // merge all posiible 
            map.put(c, merge(cur));
        }

        HashSet<String> set = new HashSet<>();

        int ans = 0;
        int[] select = new int[] {-1, -1};
        // iterate by the sequence
        for (int i = 0; i < n; ++i) {
            char c = style.get(i);
            List<int[]> cur = map.get(c);

            // find the interval which could cover the start and end
            int start = starting.get(i);
            int end = ending.get(i);

            int index = findIndex(cur, end);
            String check = String.valueOf(index) + '.' + String.valueOf(c);

            // if we add this operation before
            if (set.contains(check)) {
                continue;
            }
            // mark visited , add operation
            set.add(check);

            int x = cur.get(index)[0];
            int y = cur.get(index)[1];
            if (x != select[0] || y != select[1]) {
                ++ans;
            }
            select[0] = x;
            select[1] = y;

            ++ans;
        }
        return ans;
    }

    public static int findIndex(List<int[]> list, int target) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid)[1] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static List<int[]> merge(List<int[]> list) {
        List<int[]> ans = new ArrayList<>();
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        int[] cur = list.get(0);
        ans.add(cur);
        int n = list.size();
        for (int i = 1; i < n; ++i) {
            if (list.get(i)[0] <= cur[1] + 1) {
                // merge
                cur[1] = Math.max(cur[1], list.get(i)[1]);
            } else {
                // add a new interval
                cur = list.get(i);
                ans.add(cur);
            }
        }
        return ans;
    }

}
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int startingCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> starting = IntStream.range(0, startingCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int endingCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ending = IntStream.range(0, endingCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int styleCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Character> style = IntStream.range(0, styleCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(e -> e.charAt(0))
            .collect(toList());

        int result = Result.textFormatting(starting, ending, style);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}