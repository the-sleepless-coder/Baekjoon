import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // N개의 선물 상자
    // 각각 N1, N2, ... NP
    // 선물 받을 M명
    // 1 ~ M
    // 선물이 가장 많은 상자에서 가져가되 또 가져가도 된다.

    // 기초 구현문제부터 존나 빡세게 한번 풀자.
    // 트리, 그래프 풀어야 함.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int prsNum = -1;
        int cdNum = -1;
        prsNum= Integer.parseInt(st.nextToken());
        cdNum = Integer.parseInt(st.nextToken());

        int[] prsList = new int[prsNum];
        int[] childList = new int[cdNum];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<prsNum; i++){
           prsList[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cdNum; i++){
            childList[i] = Integer.parseInt(st.nextToken());
        }

        // Comparator 넣어서 정렬 기준 세움.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int i=0; i<prsNum; i++){
            pq.add(prsList[i]);
        }

        // System.out.println(pq);

        boolean ishappy = true;
        int childIdx = 0;
        for(int i=0 ; i<prsNum; i++){
            // 이미 모든 아이들에게 선물을 줬다면,
            // True 처리한다.
            if(childIdx >= cdNum){
                break;
            }

            // 상자에서 선물을 꺼낸다.
            int present = pq.poll();
            // System.out.printf("%d %s\n", i+1, present);

            // 선물의 개수가 더 많다면,
            // 선물을 감소 시키고 다시 넣어서 정렬시킨다.
            if(present >= childList[childIdx]){
                present -= childList[childIdx];
                childIdx++;
                pq.add(present);
            }
            // 선물의 개수가 더 적다면,
            // 실패 처리한다.
            else{
                ishappy = false;
                break;
            }

        }
        if(ishappy)
            System.out.println(1);
        else{
            System.out.println(0);
        }


        // 5,3,2,1
        // 2,3,2,1

        // 3,3,2,1
        // 3,2,1

        // 2,2,1

    }



}
