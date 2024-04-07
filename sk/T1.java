import java.util.*;
public class T1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(getint(s));
    }
    public static String getint(String s){
//        char[] charArray = s.toCharArray();
//        char tmp = charArray[0];
        String s1 = s.substring(0,3);
        String s2 = s.substring(3,7);
        String news = s2+s1;
        String res = new String();
        for(int i=0;i<7;i++){
            res += 97+(news.charAt(i)-'a');
        }
//        int res = Integer.parseInt(news);
        return res;
    }
}
