package Math;

import java.util.List;

class _119 {
    public List<Integer> getRow(int rowIndex) {
        _118 res=new _118();
        return res.generate(rowIndex).get(rowIndex);
    }
}
