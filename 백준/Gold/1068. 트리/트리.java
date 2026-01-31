import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] parents = new int[N];
        for(int idx=0; idx<N; idx++){
            parents[idx] = Integer.parseInt(st.nextToken());
        }

        // System.out.println(Arrays.toString(parents));

        int delNodeNum = Integer.parseInt(br.readLine());

        // Node 배열을 형성해준다.
        Node[] nodes = new Node[N];
        for(int idx=0; idx<N; idx++){
            Node node = new Node(idx);
            nodes[idx]= node;
        }

        // rootNodeIdx를 찾는다.
        int rootNodeIdx = -999;
        for(int idx=0; idx<N; idx++){
            if(parents[idx]==-1){
                rootNodeIdx = idx;
            }
        }

        // 각 노드별로 부모를 찾으면 아이로 넣는다.
        for(int idx=0; idx<N; idx++){
            for(int i=0; i<N; i++){
                if( idx == parents[i] ){
                    nodes[idx].children.add(nodes[i]);
                }
            }
        }

        // 루트가 없어지면, children의 숫자는 0이다.
        int parent = parents[delNodeNum];
        boolean isGone = false;
        if(parent == -1){
            isGone = true;
        }

        // 삭제할 노드의 부모를 찾고,
        // 그 부모에서 children자체를 없애준다.
        int result = -1;
        if(!isGone){
            ArrayList<Node> parentChild = nodes[parent].children;
            int len = parentChild.size();
            for(int idx=0; idx<len; idx++){
                if(parentChild.get(idx).val == delNodeNum){
                    parentChild.remove(idx);
                    break;
                }
            }
            //nodes[delNodeNum].val = -100;
            //nodes[delNodeNum].children.clear();

            // System.out.println(Arrays.toString(nodes));

            boolean[] visited = new boolean[N];
            result = dfs(nodes[rootNodeIdx], visited);
        }else{
            result = 0;
        }

        System.out.println(result);

    }

    // children이라는 arrayList를 생성자에서 초기화해줘야,
    // 값을 넣을 수 있다.
    static class Node{
        int val;
        ArrayList<Node> children;

        public Node(int val){
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    //dfs탐색을 해서 뭐 어떻게 해야하지?
    // 삭제된 노드가 아닐 때만 dfs탐색을 한다.
    // children의 size가 0일 때만 값을 더한다. 즉, 자식 노드의 개수를 구한다.
    static int dfs(Node node, boolean[] visited){
        int childCount = 0;

        // root가 삭제될 때를 처리해준다.
        Stack<Node> stack = new Stack<>();
        if(node.val != -100){
            stack.add(node);
        }

        // 현재 노드가 아이가 있는지 확인한다.
        // 아이가 없으면 count++;
        // 아이가 있다면 dfs를 이어간다.
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            ArrayList<Node> children = curr.children;
            if(children.size()==0){
                // System.out.printf("childNum: %d \n", curr.val);
                childCount++;
            }else{
                int len = children.size();
                for(int idx=0; idx < len; idx++){
                    // 삭제된 노드가 아닐 때만,
                    // Stack에 더해준다.
                    Node givNode = children.get(idx);
                    if(givNode.val != -100) {
                        if (!visited[givNode.val]) {
                            stack.add(givNode);
                            visited[givNode.val] = true;
                        }

                    }
                }
            }



        }

        return childCount;

    }

}

//7
//-1 0 0 0 1 1 1
//1
// 답 = 2

//       0
//      /|\
//     1 2 3
//    /|\
//   4 5 6


// -1 0 0 2 2 4 4 6 6
//        0
//       / \
//      1   2
//         / \
//        3   4
//            /\
//           5  6
//          /\
//         7  8