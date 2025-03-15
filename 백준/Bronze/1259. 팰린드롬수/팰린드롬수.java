import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N= "";

        while( ! N.equals("0")){
            N = sc.nextLine();
            if(N.equals("0")){
                continue;
            }
            int len = N.length();

            boolean isPalind = true;
            for(int i = 0; i < len/2; i++){
                // i번째 숫자와 len - 1 - i 번째 숫자가 같은지 확인한다.
                if(N.charAt(i) != N.charAt(len - 1 - i)){
                    isPalind = false;
                    break;
                }
            }

            if(isPalind){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }

        }
    }
}
