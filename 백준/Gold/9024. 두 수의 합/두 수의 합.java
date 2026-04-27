import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int targetSum = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++){
                arr[n] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int startIdx = 0;
            int endIdx = N-1;
            int absMin = Integer.MAX_VALUE;
            int count = 0;
            while(startIdx<endIdx){
                int sum = arr[startIdx]+arr[endIdx];
                int diff = Math.abs(targetSum-sum);

                // absMin보다 diff가 더 작을 경우에는,
                // count를 새로 선언해준다.
                if(diff<absMin){
                    absMin = Math.min(absMin, diff);
                    count=1;
                }
                // absMin 값과 같다면 count+=1을 해준다.
                else if(diff==absMin){
                    count+=1;
                }


                if(sum<targetSum){
                    startIdx++;
                }else if(sum>targetSum){
                    endIdx--;
                }else{
                    startIdx++;
                    endIdx--;
                }

            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);


    }




    static void saveAll(){
        // 기존에 모든 합을 맵에 저장하는 방식.
        /**
         for(int t=0; t<T; t++){
         // HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
         HashMap<Integer, Integer> map = new HashMap<>();

         StringTokenizer st = new StringTokenizer(br.readLine());

         int N = Integer.parseInt(st.nextToken());
         int target = Integer.parseInt(st.nextToken());

         int[] arr = new int[N];
         st = new StringTokenizer(br.readLine());
         for(int n=0; n<N; n++){
         arr[n] = Integer.parseInt(st.nextToken());
         }
         Arrays.sort(arr);

         int startIdx = 0;
         int endIdx = N-1;
         int absMin = Integer.MAX_VALUE;
         while(startIdx<endIdx){
         int val = arr[startIdx] + arr[endIdx];

         if(arr[startIdx]+arr[endIdx] > target){
         endIdx--;
         }else if(arr[startIdx]+arr[endIdx] < target){
         startIdx++;
         }else{
         startIdx++;
         endIdx--;
         }

         // target, int[] 형태로 값과 인덱스를 저장한다.
         if(!map.containsKey(val)){
         //ArrayList<int[]> temp = new ArrayList<>();
         //temp.add(new int[]{startIdx, endIdx});

         map.put(val, 1);
         }else{
         int value = map.get(val);
         value+=1;
         map.put(val, value);
         }

         absMin = Math.min( Math.abs(val - target), absMin);

         }

         // target값과 일치할 때는 해당 키 값의 원소 개수를 가져온다.
         if(absMin==0){
         for(int key:map.keySet()){
         if(key==target){
         sb.append(map.get(key)).append("\n");
         }
         }
         }
         // target값과 일치하지 않으면, 절대값 만큼 차이 나는 원소의 값을 더한다.
         else{
         int result = 0;
         for(int key: map.keySet()){
         if(key==target + absMin || key== target-absMin ){
         result += map.get(key);
         }
         }

         sb.append(result).append("\n");
         }


         }

         System.out.print(sb);
         */
    }
    // K=5
    // -7 -4 -3 -2 0 1 2 5 9 12

}
