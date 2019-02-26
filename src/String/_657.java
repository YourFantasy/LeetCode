package String;

public class _657 {
    public boolean judgeCircle(String moves) {
        int row = 0, column = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R')
                column++;
            if (moves.charAt(i) == 'L')
                column--;
            if (moves.charAt(i) == 'U')
                row--;
            if (moves.charAt(i) == 'D')
                row++;
        }
        return column == 0 && row == 0;
    }
}
