package codefun2000;

import java.util.Scanner;

public class P1897 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();

        while(k-- >0){
            int number = input.nextInt();
            boolean isPrime = true;
            for(int div = 2; div*div <= number; div++){
                if(number % div ==0){
                    System.out.println(div);
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.println(number);
            }
        }
    }
}
