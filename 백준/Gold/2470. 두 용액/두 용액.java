import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<N; idx++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int leftIdx = 0;
        int rightIdx = N-1;

        // 배열을 정렬한다.
        arr.sort((i1, i2)->Integer.compare(i1,i2));

        int min = Integer.MAX_VALUE;
        int resLeftIdx = -1;
        int resRightIdx = -1;

        int target = 0;
        while(leftIdx<rightIdx){
            int left = arr.get(leftIdx);
            int right = arr.get(rightIdx);

            int sum = left+right;
            // 절대값의 양의 숫자가 너무 크다면 rightIdx를 줄여준다.
            // 양의 숫자를 줄여준다.
            if(sum >0 ){
                if(min>Math.abs(sum)){
                    min = sum;
                    resLeftIdx = leftIdx;
                    resRightIdx = rightIdx;
                }
                rightIdx--;
            }
            // 절대값의 음의 숫자가 너무 크다면 leftIdx를 늘려준다.
            // 음의 크기를 줄옂누다.
            else if(sum<0){
                if(min>Math.abs(sum)){
                    min = Math.abs(sum);
                    resLeftIdx = leftIdx;
                    resRightIdx = rightIdx;
                }
                leftIdx++;
            }else{
                resLeftIdx=leftIdx;
                resRightIdx=rightIdx;
                break;
            }


        }

        int resLeft = arr.get(resLeftIdx);
        int resRight= arr.get(resRightIdx);

        System.out.printf("%d %d", resLeft, resRight);

    }
}
// 주어진 배열을 정렬해준다.
// 합한 값이 +이고 rightIdx --
// 합한 값이 -이고  leftIdx ++
// 그러니까 양수와 음수의 합이 0에 가까워지도록 left, rightIdx를 조정한다.

// 그래서 합한 값의 절대값이 가장 작은 것의 인덱스를 메모해둔다.

// -5 -4 -3 -1 3 4 100 103
// -99 -5 -3 -2 -1
// 1 3 5 7 9