import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            String givNum = sc.next();
            int givLen=givNum.length();
            Integer N = Integer.parseInt(givNum);

            if(N==0&&givLen<2)
                break;

            // palindrome이 되면 while문을 멈춘다.
            // 숫자를 얼마나 더해야 palindrome이 되는지 확인한다.
            boolean isPalindrome = false;
            int palCounter=0;

            // StringBuilder를 하면 padding을 하는 과정에서 계속 객체를 복사하기 떄문에,
            // 메모리가 터지지 않게 아예 buff를 이용하자.
            // 일의 자리 수부터 뒤에서 buff를 채운다.
            char[] buff = new char[givLen];
            while(!isPalindrome){

                int tmp = N;
                for(int idx = givLen-1; idx>=0; idx--){
                    buff[idx]= (char)('0'+ tmp%10);
                    tmp=tmp/10;
                }

                // 주어진 인덱스와 대칭되는 자리에 숫자가 다르면,
                // 바로 break를 하고 N과 palCounter를 1씩 올려준다.
                // 같으면 while문을 break해준다.
                boolean sym = true;
                for(int idx=0; idx<givLen/2; idx++){
                    if( buff[idx] != buff[givLen-1 - idx]){
                        N++;
                        palCounter++;
                        sym=false;
                        break;
                    }
                }

                // 변수 이름을 잘 짓자.
                // broken ->sym으로 바꾸니까 실수도 덜한다.
                if(sym){
                    isPalindrome =true;
                }

            }

            System.out.println(palCounter);

        }
    }
}
// 그냥 아이디어 자체는 단순한다
// 숫자를 하나씩 더해가면서 펠린드롬인지 확인해보면 된다.

// 절반의 인덱스까지
// 12345

