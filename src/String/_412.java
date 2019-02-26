package String;

import java.util.ArrayList;
import java.util.List;

public class _412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0)
                res.add("Fizz");
            if (i % 5 == 0 && i % 3 != 0)
                res.add("Buzz");
            if (i % 5 != 0 && i % 3 != 0)
                res.add(i + "");
            if (i % 5 == 0 && i % 3 == 0)
                res.add("FizzBuzz");
        }
        return res;
    }
}
