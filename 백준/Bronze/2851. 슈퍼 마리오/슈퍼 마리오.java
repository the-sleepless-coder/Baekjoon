import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numArray = new int[10];
        int sum = 0;
        int idx = 0;
        int target = 100;
        int diffPlus = 1000000;
        int diffMinus = -1000000;
        int result =-1;

        while(idx < 10){
            numArray[idx] = sc.nextInt();
            sc.nextLine();
            sum+=numArray[idx];
            idx+=1;
            if(sum-target >= 0 && sum-target < diffPlus){
                diffPlus = sum - target;
            }else if(sum-target<0 && sum - target > diffMinus){
                diffMinus = sum - target;
            }
        }
//        System.out.println(diffPlus);
//        System.out.println(diffMinus);

        if(diffPlus<=Math.abs(diffMinus)){
            result = target + diffPlus;
        }else if(diffPlus>Math.abs(diffMinus)){
            result = target + diffMinus;
        }

        System.out.println(result);



    }
}
