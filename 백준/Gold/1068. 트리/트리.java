import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // parArr, nodeArr처럼 변수명을 의미에 맞게 정확하게 설정해주면,
        // 헷갈리지 않고 문제를 깔끔하게 풀 수 있다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] parArr = new int[N];
        for(int idx=0; idx<N; idx++){
            parArr[idx] = Integer.parseInt(st.nextToken());
        }

        int del = Integer.parseInt(br.readLine());

        // parArr과 nodeArr의 상태를 일치시켜준다.
        for(int idx=0; idx<N; idx++){
            if(idx==del){
                parArr[idx]=-100;
            }
        }

        // 동일한 주소를 통해 동일한 노드를 쓸 수 있게 nodeArr를 만들어준다.
        Node[] nodeArr = new Node[N];
        for(int idx=0; idx<N; idx++){
            Node node = null;
            if(idx!=del){
                node = new Node(idx);
            }else{
                node = new Node(-100);

            }
            nodeArr[idx] = node;
        }

        // parArr에 맞게 노드를 서로 이어준다.
        // 즉 노드 관계를 서로 이어줌으로써 트리라는 자료구조를 만들어준다.
        Node root = null;
        for(int idx=0; idx<N ;idx++){
            // parArr == -1이라면, root로 지정해준다.
            if(parArr[idx]==-1){
                root = nodeArr[idx];
            }
            // 부모에 대한 자식을 넣어준다.
            // 부모가 삭제됐거나, 자식 노드가 삭제됐다면, 노드로 반영 안해준다.
            else if(parArr[idx] != -1 && parArr[idx] != -100){
                int parIdx = parArr[idx];

                if(nodeArr[idx].value != -100){
                    nodeArr[parIdx].children.add(nodeArr[idx]);
                }
            }
        }


        int result = Node.countLeaves(root);

        System.out.println(result);

    }

    // 중첩 클래스로 Main 객체를 안쓰고 Node객체를 쓰려면
    // 클래스 자체로 접근할 수 있게 static하게 만들어줘야 한다.

    // static을 붙여주지 않으면 Main 객체를 통해서 Node를 만들어야하기 때문에,
    // 중첩 클래스를 쓰는 것이 매우 번거로워짐.
    static class Node{
        // 노드 값과,
        // 자식을 담을 수 있는 ArrayList를 만들어준다.
        int value;
        ArrayList<Node> children = new ArrayList<Node>();

        public Node(int value){
            this.value = value;
        }

        // 루트에서 시작해서, 각 노드를 타고 들어가면서 자식 노드가 몇 개 있는지 확인한다.
        // 즉, DFS로 트리를 탐색해서 리프 노드가 몇개 존재하는지 확인해본다.
        // 리프 노드 판단은 children이 0개일 때로 판단한다.
        static int countLeaves(Node node){
            // root노드가 삭제되면,
            // 바로 0개를 되돌려준다.
            if(node == null)
                return 0;

            Stack<Node> stack = new Stack<>();
            stack.add(node);

            int sum = 0;
            while(!stack.isEmpty()){
                Node curr = stack.pop();

                ArrayList<Node> children = curr.children;
                boolean hasChild = false;

                for(Node ch:children){
                    // 삭제한 노드를 제외하고 탐색을 이어간다.
                    if(ch.value != -100){
                        stack.add(ch);
                        hasChild = true;
                    }
                }

                // curr에서부터 확인을 해야 한다
                // 그러니까 더해지는 자식 노드가 없다면,
                // 리프노드의 개수를 늘려준다.
                if(!hasChild){
                    sum++;
                }
            }


            return sum;
        }

    }


}

// 트리에서 노드를 줬을 때,
// 남은 트리에서 리프 노드의 개수를 구하시오.

//      0
//     /  \
//    1    2
//   / \
//  3   4