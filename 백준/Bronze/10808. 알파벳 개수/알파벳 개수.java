import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // 아스키 코드를 기준으로 alphabaet을 0~25로 만들었을 때,
        // 각각 몇 개씩 들어가는지 세 본다.
        int N=26;
        int[] alphCount = new int[N];

        char[] charArr=input.toCharArray();
        int len = charArr.length;
        for(int idx=0; idx<len;idx++){
            int alph = charArr[idx]-'a';

            alphCount[alph]+=1;
        }

        StringBuilder sb = new StringBuilder();
        for(int idx=0; idx<N; idx++){
            sb.append(alphCount[idx]).append(" ");
        }
        System.out.println(sb);

    }
}
