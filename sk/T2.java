import java.util.*;
public class T2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        int n = in.nextInt();
        int[][] num = new int[n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++) num[i][j] = in.nextInt();
//            System.out.println(getint(s,t,num));
        }
        List<String> res = getint(s,t,num,n);
        for(String str:res){
            System.out.println(str);
        }


    }
    public static List<String> getint(String s, String t, int[][] num,int n ){

        List<String> res = new ArrayList<>();
        for(int j = 0;j<n;j++){
            int s1 = 0;
            int t1 = 0;
            String s11=s;
            String t11=t;
//            int h1 = 0;
//            int x1 = 0;
//            int h2 = 0;
//            int x2 = 0;
            s1 = s11.substring(num[j][0]-1,num[j][1]).replace("H","XX").length();
            t1 = t11.substring(num[j][2]-1,num[j][3]).replace("H","XX").length();
//            for(int i=num[j][0]-1;i<=num[j][1]-1;i++){
//                if(s.charAt(i)=='H') h1++;
//                else x1++;
//            }
//            s1 = h1*2+x1;
//            for(int i=num[j][2]-1;i<=num[j][3]-1;i++){
//                if(t.charAt(i)=='H') h2++;
//                else x2++;
//            }
//            t1 = h2*2+x2;
////            String res = new String();
            if(s1>=t1){
                if((s1-t1)%3==0) res.add("YES");
                else res.add("NO");
            }else {
                if((t1-s1)%3==0) res.add("YES");
                else res.add("NO");
            }
        }

        return res;
    }
}
