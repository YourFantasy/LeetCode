package DFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _216 {
    @Test
    public void test() {
        combinationSum3(3, 12);

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < 1 || n < k)
            return result;
        List<Integer> temp = new ArrayList<>();
        dfs(k, n, 1, result, temp, 0);
        for(int i=0;i<result.size();i++)
            System.out.println(result.get(i)+",");
        return result;
    }

    public void dfs(int k, int n, int start, List<List<Integer>> result, List<Integer> temp, int size) {
        if (size == k) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += temp.get(i);

            }
            if (sum == n) {
                result.add(new ArrayList<>(temp));
                for (int i = 0; i < k; i++)
                    System.out.print(temp.get(i) + ",");
                System.out.println();
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            dfs(k, n, i + 1, result, temp, size + 1);
            temp.remove(size);
        }
    }
}
