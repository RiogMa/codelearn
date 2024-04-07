import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // while (in.hasNextInt()) { // 注意 while 处理多个 case
        //     int a = in.nextInt();
        //     int b = in.nextInt();
        //     System.out.println(a + b);
        // }
        int n = in.nextInt();
        String[] str = new String[n];
        int i=0;
        while(in.hasNextLine()){
            str[i] = in.nextLine();
        }
        int res = 0;
        // char m ='i';
        for(int j=0;j<n;j++){
            // char t1 = str[j].charAt(str[j].length()-1);
            // char t2 = str[j].charAt(str[j].length()-2);
            if(str[j].charAt(str[j].length()-1)!='i'){
                res++;
            }else if(str[j].charAt(str[j].length()-2)=='0'){
                res++;
            }
        }
        System.out.print(res);
    }
}