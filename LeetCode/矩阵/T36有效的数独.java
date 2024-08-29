package 矩阵;

import java.util.HashMap;
import java.util.HashSet;

public class T36有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Integer>> col = new HashMap<>(), row = new HashMap<>(), area = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            col.put(i, new HashSet<>());
            row.put(i, new HashSet<>());
            area.put(i, new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int idx = board[i][j] - '0';
                int area_idx = i / 3 * 3 + j / 3;
                if (col.get(j).contains(idx) || row.get(i).contains(idx) || area.get(area_idx).contains(idx)) {
                    return false;
                } else {
                    col.get(j).add(idx);
                    row.get(i).add(idx);
                    area.get(area_idx).add(idx);
                }

            }
        }
        return true;
    }
}
