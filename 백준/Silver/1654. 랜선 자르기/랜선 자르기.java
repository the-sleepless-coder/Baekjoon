import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] lanArr = new int[k];
        for(int idx=0; idx<k ; idx++){
            int lan = Integer.parseInt(br.readLine());
            lanArr[idx] = lan;
        }

        long lanLength = binarySearch(m, lanArr);

        System.out.println(lanLength);

    }

    // 랜선의 길이 중 가장 긴 것을 구한다.
    static long binarySearch(int m, int[] lanArr){
        int maxLan = -1;
        int len = lanArr.length;
        for(int idx=0; idx<len; idx++){
            maxLan = Math.max(lanArr[idx], maxLan);
        }

        long min = 1;
        long max = maxLan;

        while(min<=max){
            int count = 0;
            long mid = (min+max)/2;
            for(int idx=0; idx<len; idx++){
                count += lanArr[idx]/mid;
            }

            // 랜선 길이가 너무 길면 앞쪽 반을 탐색
            if( count < m ){
                max = mid-1;
            }
            // 랜선 길이가 너무 짧으면 뒷쪽 반을 탐색
            // count==m일 때
            else if( count>=m ) {
                min = mid + 1;
            }

        }


        return max;

    }

}

// N개의 랜선을 만들 수 있는 랜선의 최대 길이를 출력한다.
