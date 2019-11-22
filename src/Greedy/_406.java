package Greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _406 {
    @Test
    public void test() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return people;
        }
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] nums : people) {
            list.add(nums[1], nums);
        }
        return list.toArray(new int[list.size()][]);
    }

}
