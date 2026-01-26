import java.util.*;

class Solution {
    static int N = 1000000;
    static int target = 500000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();
        for(int idx=1; idx<=N; idx++){
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);

        System.out.println(arr.get(target));

    }
}
//퀵 정렬, 병합 정렬 연습?

