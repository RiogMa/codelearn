package 并查集;

import java.io.*;
import java.util.*;

public class hw240410相似度计算 {

    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws Exception {
        // Scanner in = new Scanner(System.in);
        int n = read();
        int[][] M = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = read();
            }
        }

        UnionFind uf = new UnionFind(M);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 0) continue;
                uf.merge(i, j);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> m : uf.map.entrySet()) {
            list.add(m.getValue());
        }
        Collections.sort(list, (a, b) -> b - a);

        for (Integer l : list) {
            System.out.print(l);
            System.out.print(" ");
        }
    }

    public static int read() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }
}

class UnionFind {
    int[] parent;
    int[][] M;
    int findRoot;

    Map<Integer, Integer> map = new HashMap<>();

    UnionFind(int[][] M) {
        int n = M.length;
        int h = (int) Math.ceil(Math.log10(n) / Math.log10(2) + 1);
        int len = (int) Math.pow(2, h);
        this.parent = new int[len];
        this.M = M;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        findRoot = find(parent[x]);
        return findRoot;
    }

    public void merge(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx == fy) {
            map.put(fx, map.getOrDefault(fx, 0) + M[x][y]);
            return;
        }
        parent[fx] = fy;
        // 因为当前是让fx合到fy，因此也要将之前fx作为根的和获取到，跟当前M[x][y]合到一起
        int origin = 0;
        if (map.containsKey(fx)) {
            origin = map.get(fx);
            map.remove(fx);
        }
        map.put(fy, map.getOrDefault(fy, 0) + M[x][y] + origin);
    }


}
