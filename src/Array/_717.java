package Array;

class _717 {
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
        return i == len - 1 && bits[i] == 0;

    }
}
