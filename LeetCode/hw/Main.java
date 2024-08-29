package hw;
import node.t203;

import java.util.*;

import java.util.regex.*;

/**
 *疫情安全距离
 * 在饭馆里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 * 当顾客进入饭馆后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果饭馆里没有人，那么顾客就坐在 0 号座位上。)
 * 返回 Room(int N) 类，它有两个公开的函数：其中，函数 Room.seat() 会返回一个 int （整型数据），代表顾客坐的位置；函数 Room.leave(int p) 代表坐在座位 p 上的顾客现在离开了饭馆。每次调用 Room.leave(p) 时都保证有顾客坐在座位 p 上。
 *
 * 示例：
 * 输入：
 * Room(10) -> null
 * seat() -> 0，没有人在饭馆里，那么顾客坐在 0 号座位上。
 * seat() -> 9，顾客最后坐在 9 号座位上。
 * seat() -> 4，顾客最后坐在 4 号座位上。
 * seat() -> 2，顾客最后坐在 2 号座位上。
 * leave(4) -> null
 * seat() -> 5，顾客最后坐在 5 号座位上。
 *
 * 输出：类似 [null,0,9,4,2,null,5]
 *
 * 提示：
 * 1. 1 <= N <= 10^9
 * 2. 在所有的测试样例中 Room.seat() 和 Room.leave() 最多被调用 10^4 次。
 * 3. 输入会保证在调用 Room.leave(p) 时有顾客正坐在座位 p 上。
 *
 * class Room {
 *     public Room(int n) {
 *
 *     }
 *
 *     public int seat() {
 *
 *     }
 *
 *     public void leave(int p) {
 *
 *     }
 * }
 */
public class Main {
    public List<Integer> res = new ArrayList<>();
    public List<Integer> ans = new ArrayList<>();
    public Main(int n){
        ans.add(null);
    }
    public int seat(){
        // 找到空座位
        int n = res.size();
        int[] pos = new int[n];
        for(int i = 0;i<n;i++){
            if(res.get(i)!=null){
                pos[i] = 1;
            }
        }
        // 找到位置
        int max = 0;
        int start=0, end=0;
        int i = 0;
        for(i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(pos[i]==1&&pos[j]==1){
                    if(j-i > max){
                        start = i;
                        end = j;
                        max = j-i;
                    }
                    i = j;
                }
            }
        }
        if(pos[(start-end)/2]!=1){
            res.set((start-end)/2,1);
            return (start-end)/2;
        }
        return 0;
    }

    public void leave(int p){
        res.set(p, null);
    }

}
