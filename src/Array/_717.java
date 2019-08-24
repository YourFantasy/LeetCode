package Array;

public class _717 {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        int i = 0;
        while (i < len - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        if (i == len - 1 && bits[i] == 0) {
            return true;
        }
        return false;

    }
}
