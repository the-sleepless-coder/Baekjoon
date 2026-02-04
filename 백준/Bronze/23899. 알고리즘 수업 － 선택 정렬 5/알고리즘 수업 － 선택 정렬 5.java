import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        // 원본 배열을 저장하기 위해,
        // 다른 참조값을 가진 배열 복사본을 만든다.
        int[] orgArr = new int[N];
        for(int idx=0; idx<N; idx++){
            orgArr[idx]=sc.nextInt();
        }
        int[] compArr = new int[N];
        for(int idx=0; idx<N; idx++){
            compArr[idx] = sc.nextInt();
        }

        boolean arrStat;
        arrStat=selectionSort(orgArr, compArr);


        StringBuilder sb = new StringBuilder();
        if(arrStat)
            sb.append(1);
        else
            sb.append(0);

        System.out.println(sb);


    }


    // K번째 교환되는 수를 출력해라.
    static boolean selectionSort(int[] orgArr, int[] compArr){
        int N = orgArr.length;
        // 한번이라도 resultIdt가 true라면,
        // 일치가 한번이라도 됐기 때문에 1을 반환.
        // 아니라면 0을 반환한다.
        boolean resultIdt=false;

        // Mutable한 배열로서 orgArr가 바뀔 수 있으므로,
        // 정렬하기 전에 비교를 해준다.
        boolean arrSame = true;
        // 2개의 배열이 일치하면 resultId를 true로 처리한다.
        for(int idx=0; idx<N; idx++){
            if(compArr[idx]!=orgArr[idx]){
                arrSame=false;
                break;
            }
        }
        resultIdt=resultIdt||arrSame;

        if(!resultIdt){
            // 교환할 i번째 인덱스 설정.
            for(int i=N-1; i >= 1 ; i--){
                int maxIdx = i;

                // 비교할 숫자를 탐색한다.
                for(int j = i-1; j>=0; j--){
                    if( orgArr[j] > orgArr[maxIdx]){
                        maxIdx=j;
                    }
                }

                // 더 큰 수를 발견하면 교환해주고,
                // 교환횟수를 올려준다.
                if(maxIdx!=i){
                    int temp;
                    temp=orgArr[maxIdx];
                    orgArr[maxIdx]=orgArr[i];
                    orgArr[i]=temp;

                    boolean arrIdt = true;
                    // 배열이 바뀌고 나서 주어진 배열 대로의 숫자가 일치하는지 확인한다.
                    for(int idx=0; idx<N; idx++){
                        if(compArr[idx] != orgArr[idx]){
                            arrIdt=false;
                        }
                    }

                    // 한번이라도 true가 나오면 1을 반환한다.
                    // 아니라면 0을 반환한다.
                    resultIdt = resultIdt||arrIdt;


                }
            }
        }

        return resultIdt;

    }
}

// 같은 배열이 발생하면 1 아니면 0을 출력하여라.
