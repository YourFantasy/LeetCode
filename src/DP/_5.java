package DP;

import org.junit.Test;

public class _5 {
    @Test
    public void Test() {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        String result = "";
        if (s.length() == 0)
            return result;
        for (int len = 1; len <= s.length(); len++) {
            for (int j = 0; j <= s.length() - len; j++) {
                int k = j + len - 1;
                String temp = "";
                for (int t = j; t <= k; t++) {
                    temp += s.charAt(t);
                }
                if (Is_Palindrome(temp))
                    result = (result.length() < temp.length()) ? temp : result;

            }
        }
        return result;
    }

    boolean Is_Palindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }

}
