package Greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _763 {
    @Test
    public void test() {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    /**
     * 用一个index数组存储每个小写字母最后出现的位置
     * begin:代表一段序列中的初始位置
     * last：代表这段序列中最后的位置
     * 当i==last时，表示之后的序列中不含有这段序列的元素，此时len=i-begin+1；
     * 然后从i+1继续开始上述过程
     *
     * @param S
     * @return
     */
    private List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] index = new int[26];
        for (int i = 0; i < S.length(); i++) {
            int k = S.charAt(i) - 'a';
            index[k] = i;
        }
        int last = -1;
        int begin = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, index[S.charAt(i) - 'a']);
            if (i == last) {
                res.add(i - begin + 1);
                begin = i + 1;
                last = -1;
            }
        }
        return res;
    }
}
