package Math;

import java.util.HashSet;
import java.util.Set;

public class _202 {
    public boolean isHappy(int n) {
        if(n==1)
            return true;
        Set<Integer> list=new HashSet<>();
        while(list.add(n)){
            int m=0;
            while(n>0){
                int temp=n%10;
                m+=temp*temp;
                n/=10;
            }
            if(m==1)
                return true;
            else
                n=m;
        }
        return false;
    }
}
