import java.util.ArrayList;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        sc.nextLine();

        for(int t=1; t<=testCase; t++) {
            int tot = sc.nextInt();
            int edge = sc.nextInt();

            // 1-idx 기준으로 각 노드 간 연결관계를 표현.
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for (int idx = 0; idx <= tot; idx++) {
                arr.add(new ArrayList<Integer>());
            }

            for (int idx = 1; idx <= edge; idx++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                arr.get(start).add(end);
                arr.get(end).add(start);

            }

            int start = 1;
            int[] dist = new int[tot+1];
            for(int idx=0; idx<=tot; idx++){
                dist[idx] = -1;
            }

            int result = bfs(arr, start, dist);
            // System.out.println(arr);
            // System.out.println(Arrays.toString(dist));
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(result);

            System.out.println(sb);

        }

    }

    // 관계의 깊이가 2 이내인 친구들의 수를 세서 반환한다.
    // DFS에서는 Stack을 사용해 해당 노드와 연결된 노드를 끝까지 순회하면서 Stack에 반복적으로 넣으면서, 깊이 우선으로 탐색한다.
    // BFS에서는 Queue를 사용해 해당 노드와 가까운 노드를 먼저 Queue에 반복적으로 넣으면서, 너비 우선으로 탐색한다.

    // visited 배열을 통해 한번 방문한 곳을 다시 방문 안하게 하는 역할도 있다.
    // 하지만 동일한 경로를 통해 최소/최대 값을 구하거나, dist 배열을 사용하는 경우,
    // visited배열이 필요 없는 경우도 있다.
    static int bfs(ArrayList<ArrayList<Integer>> arr, int start, int[] dist ){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        // 계산이 안된 도착지 && 시작점 거리가 2 미만일 떄만 거리를 업데이트
        // 그래야 가장 짧은 거리를 기준으로 계산이 되고, 관계의 거리가 2 이하의 친구를 구할 수 있어.
        while(!q.isEmpty()) {
            int curr = q.poll();

            ArrayList<Integer> neighbors = arr.get(curr);
            int len = neighbors.size();
            for (int idx = 0; idx < len; idx++) {
                int neigh = neighbors.get(idx);

                if (dist[neigh] == -1 && dist[curr] < 2) {
                    q.add(neigh);
                    if (dist[curr] == -1) {
                        dist[curr] = 0;
                    }
                    dist[neigh] = dist[curr] + 1;
                }
            }

        }

        int result = 0;
        int len = arr.size();
        // dist 배열에서 거리가 1,2인 친구들의 수를 반환한다.
        for(int idx=0; idx<len; idx++){
            if(dist[idx]>=1 && dist[idx]<=2){
                result++;
            }
        }

        return result;
    }


}

// 관계의 깊이가 2 이내인 친구들의 수를 구하여라.
// dist 배열에서 아직 계산 안된 도착지 && 거리가 < 2일 때만 업데이트
// 가장 거리가 짧은 거리를 기준으로 거리가 계산.

//1
//6 5
//1 2
//1 3
//3 4
//2 3
//4 5

//       1
//      /  \
//     2  - 3
//           \
//            4
//             \
//              5