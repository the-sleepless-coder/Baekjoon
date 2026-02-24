import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();

        int len = charArr.length;
        int[] intArr = new int[len];
        for(int idx=0; idx<len; idx++){
            intArr[idx] = Integer.parseInt(String.valueOf(charArr[idx]));
        }

        // 가장 뒤에 있는 친구는 정렬을 안해도 된다.
        for(int i=0; i<len-1; i++){

            // 정렬의 범위를 하나씩 앞으로 당기면서 진행한다.
            // 숫자가 더 작으면 뒤로 보낸다.
            for(int j=0; j<len-1-i;j++){
                if(intArr[j]<intArr[j+1]){
                    int temp = intArr[j+1];

                    intArr[j+1]= intArr[j];
                    intArr[j]=temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int idx=0; idx<len; idx++){
            sb.append(intArr[idx]);
        }

        System.out.println(sb);

    }
}
// 작은 숫자를 뒤로 보내는 방식으로 정렬한다.
// 총 10자리니까 N^2=100이다.