import java.util.*;

public class Main {
    // 상근이는 N개의 카드
    // 정수 M 개가 주어졌을 때 해당 카드를 상근이가 몇 개 들고 있었을까?

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 카드의 집합을 기록한다.
        int M = Integer.parseInt(sc.nextLine());
        int[] KArr = new int[M];
        for(int i=0; i < M; i++){
            KArr[i] = sc.nextInt();
        }
        sc.nextLine();

        // 상근이가 갖고 있는 카드를 기록한다.
        int N = Integer.parseInt(sc.nextLine());
        int[] SArr = new int[N];
        for(int i=0; i < N; i++){
            SArr[i] = sc.nextInt();
        }
        sc.nextLine();

        // 상근이가 갖고 있는 카드를 set에 기록한다.
        Set s = new HashSet<>();
        for(int i=0; i<N; i++){
            s.add(SArr[i]);
        }

        // System.out.println(s);

        HashMap<Integer,Integer> r = new HashMap<>();
        for(int i=0; i<M; i++){
            // 해당 카드가 상근이의 카드 조합에 들어있다면, HashMap에 넣는다.
            if(s.contains(KArr[i])){
                // HashMap에 해당 Key값이 들어 있지 않다면, HashMap에 넣는다.
                if(!r.containsKey(KArr[i])){
                    r.put(KArr[i], 1);
                }
                // HashMap에 해당 Key값이 들어 있다면, 해당되는 key의 value+1을 해준다.
                else{
                    r.replace(KArr[i], r.get(KArr[i]) + 1);
                }

            }
        }

        // System.out.println(r);

        // 배열의 값과 HashMap에 해당 Key의 값이 일치한다면, 배열에 해당하는 값을 value 값으로 채운다.
        int[] result = SArr.clone();
        for(int i=0; i<N; i++){
            if(r.containsKey(SArr[i])){
                result[i] = r.get(SArr[i]);
            }else{
                result[i] = 0;
            }
        }

        // System.out.println(Arrays.toString(result));

        StringBuilder sb = new StringBuilder();
        for(int i: result){
            sb.append(i);
            sb.append(" ");
        }

        System.out.println(sb);

    }
}
