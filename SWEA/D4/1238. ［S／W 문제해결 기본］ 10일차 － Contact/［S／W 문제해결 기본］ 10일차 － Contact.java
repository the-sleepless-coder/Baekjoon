import java.util.*;

public class Solution {
    static int testCases = 10;
    static int maxNum = 100;
    // 연락 최대 인원은 100명
    // 가장 마지막에 연락을 받는 사람 중 번호가 가장 큰 사람을 구해라

    // 그러니까 BFS를 조지고 나서 가장 마지막에 도달한 사람 중 번호가 가장 큰 사람을 구하면 된다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int t=1; t<=testCases; t++){
            int tot = sc.nextInt();
            int first = sc.nextInt();
            sc.nextLine();


            // 1-index기준으로 그래프에서 누가 누구랑 연결되는지 확인한다.
            // 유향 그래프라서 주어진 방향으로만, 값을 더해준다.
            // 그래프 인덱스 별로 어떤 곳과 연결이 돼 있는지 표시한다.
            int N = tot/2;
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int idx=0; idx <= maxNum ; idx++){
                graph.add(new ArrayList<Integer>());
            }

            for(int idx=0; idx < N; idx++){
                int start = sc.nextInt();
                int arrival = sc.nextInt();

                graph.get(start).add(arrival);
            }

            // System.out.println(graph);

            // BFS로 탐색을 해야 한다.
            // 시작점에서 자신의 인접한 곳을 탐색해서,
            // 최종 목적지 중에서 가장 큰 수를 구한다.
            boolean[] visited = new boolean[maxNum+1];
            int[] dist = new int[maxNum+1];
            int[] hops = new int[maxNum+1];
            for(int idx=0; idx<=maxNum; idx++){
                hops[idx] = -1;
            }
            hops = bfs(first, visited,graph, dist);

            //System.out.println(Arrays.toString(hops));

            int max = -1;
            for(int num:hops){
                max = Math.max(max,num);
            }

            //System.out.println(max);

            List<Integer> arr = new ArrayList<>();
            for(int idx=0; idx <= maxNum; idx++){
                if(hops[idx]==max){
                    arr.add(idx);
                }
            }

            int resultMax = -1;
            for(int num:arr){
                resultMax = Math.max(num, resultMax);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(resultMax);
            System.out.println(sb);

        }


    }

//24 2
//2 7 11 6 6 2 2 15 15 4 4 2 4 10 7 1 1 7 1 8 1 17 3 22

    // 다시 방문 안하기 위한 visited && 그래프 순회 위한 Queue 형성
    public static int[] bfs(int start, boolean[] visited, ArrayList<ArrayList<Integer>> graph, int[] dist){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start]=true;
        dist[start] = 0;

        // 시작점에서부터 시작해서 주변을 다 탐색할 때까지,
        // Queue에 있는 것을 꺼내서 연쇄적으로 주변을 탐색한다.
        // 배열이라면 내가 탐색할 수 있는 곳 주변을 델타 탐색(변화량)을 통해서
        // 탐색할 곳을 Queue에 지속적으로 추가한다.

        // 어떻게 마지막 탐색할 곳을 탐지할까?
        // 마지막 neighbor를 저장하면 되겠다.

        // 작은 sub problem으로 문제를 나눠서 푼다.
        // 일단 가장 기초적인 유형부터 이해해서 풀되,
        // 그 뒤에 생기는 문제를 더 작은 하위 문제로 나눠서 순차적으로 풀어나간다.
        int hops = 0;

        Map<Integer, ArrayList<Integer>> result = new HashMap<>();
        while(!q.isEmpty()){
            int current = q.poll();

            // 탐색할 주변 노드.
            // ㅋㅋ 그냥 dist배열에서 그 숫자 꺼내썼으면 됐구나.
            ArrayList<Integer> lastNeighbors = new ArrayList<>();
            ArrayList<Integer> neigh = graph.get(current);
            for(int num: neigh){
                if(!visited[num]){
                    q.add(num);
                    visited[num] = true;

                    dist[num] = dist[current] + 1;
                }
                lastNeighbors.add(num);
            }
            hops++;
            result.put(hops, lastNeighbors);
        }

        return dist;
    }

}
