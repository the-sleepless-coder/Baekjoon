import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // S를 21개의 비트로 1~20까지의 숫자를 표현한다.
        // 시프트를 한 개수만큼 숫자의 존재 여부를 표시한다.
        int S = 0;

        StringBuilder sb = new StringBuilder();
        for(int idx=0; idx<N; idx++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                // S와 num의 OR처리를 통해 숫자의 존재 여부를 저장한다.
                S = S | (1 << num);

            }else if(cmd.equals("check")){
                // 결과값이 0이라면 없다
                // 0이 아니라면 1 존재한다.
                int num = Integer.parseInt(st.nextToken());
                int result = (S &(1<<num))== 0 ? 0:1;

                sb.append(result).append("\n");

            }else if(cmd.equals("remove")){
                // 존재하는 값과 0을 AND 처리
                // 존재하는 값을 0으로 만든다.
                int num = Integer.parseInt(st.nextToken());
                S= (S & ~(1<<num));

            }else if(cmd.equals("toggle")){
                // 1로 동일하면 0,
                // 0으로 다르면 1
                int num = Integer.parseInt(st.nextToken());
                S = S^(1<<num);

            }else if(cmd.equals("all")){
                S=(1<<21)-1;

            }else if(cmd.equals("empty")){
                S=0;
            }

        }

        System.out.println(sb);

    }
}

// add: S에 x를 추가한다.
// remove: S에 x를 제거한다.
// check: S에 x가 있는지 확인한다.
// toggle: S에 x가 있으면 제거하고, 없으면 x를 추가한다.
// all : S를 전체 집합으로 바꾼다.
// empty: S를 공집합으로 바꿔준다.

// S를 int 32비트로 잡으면, 시프트 연산은 알아서 된다.
// 전체 비트에 대한 연산을 한 것을 S에 저장하면 값이 존재하는지 여부를 확인할 수 있다.

// << : 왼쪽 시프트
// | : OR
// & : AND
// ^ : XOR -> 다르면 1, 같으면 0
// ~ : NOT -> 전체 비트를 뒤집는다.