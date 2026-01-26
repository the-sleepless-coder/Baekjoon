import java.util.*;

class Solution {
    // main은 진입함수로서 어떤 것이 변수로 들어가지?
    // 이거 C 언어 처럼 실행할 때 그 변수처럼 비슷한건가.

    // main 함수를 public으로 안 만들어 놓으면, class 실행이 안된다 ㅋ
    // 항상 public 하게 만들 것.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();

        for(int t=1; t<=testCase; t++){
            int node = sc.nextInt();
            int edge  = sc.nextInt() ;

            // 사람들 간의 친분을 1-index 기준으로 작성.
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for(int idx=0; idx<=node; idx++){
                arr.add(new ArrayList<Integer>());
            }

            // 친구 관계는 양방향 그래프 처리.
            for(int idx=0; idx<edge; idx++){
                int start = sc.nextInt();
                int end = sc.nextInt();

                arr.get(start).add(end);
                arr.get(end).add(start);

            }


            int count = 0;
            boolean[] visited = new boolean[node + 1];
            for(int num=1; num<=node; num++){
                if(!visited[num]){
                    bfs(arr, visited, num);
                    count++;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(count);

            System.out.println(sb);
        }

    }

    // 총 몇개의 무리가 있는지 bfs를 통해서 확인한다.
    // 각 시작점 노드에서 어디까지 연결 돼 있는지 확인한다.
    // 시작점의 개수로 무리의 개수를 파악한다.

    // 내가 작성한 코드에 대해 해석하는 능력이 개선될수록,
    // 알고리즘을 풀이하는 능력과 새로운 상황을 마주했을 때 그것을 알고리즘적인 코드로 풀어내는 능력이 향상 된다.
    static void bfs(ArrayList<ArrayList<Integer>> arr, boolean[] visited, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            ArrayList<Integer> neighbors = arr.get(curr);
            int len = neighbors.size();

            for(int idx=0; idx<len ; idx++){
                int neigh = neighbors.get(idx);
                if(!visited[neigh]){
                    q.add(neigh);
                    visited[neigh]= true;

                }

            }



        }
    }


}

// 서로 아는 사람들 무리의 개수를 구하여라.
// bfs로 그룹의 개수를 구한다.


//1
//6 5
//1 2
//2 5
//5 1
//3 4
//4 6

//      1       3
//    /  \      |
//   2  - 5     4
//              |
//              6
//