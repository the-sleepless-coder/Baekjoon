import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] valArr = new String[N];
        String[] leftArr = new String[N];
        String[] rightArr = new String[N];

        // 각 노드별 값, 왼쪽 노드, 오른쪽 노드를 3개의 배열을 통해 표현한다.
        // 각 배열의 idx에는 각 노드별 값, 왼쪽, 오른쪽 노드의 값을 넣는다.
        for(int idx=0; idx<N; idx++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String val = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            if(!val.equals(".")){
                valArr[idx] = val;
            }

            if(!left.equals(".")){
                leftArr[idx] = left;
            }

            if(!right.equals(".")) {
                rightArr[idx] = right;
            }

        }

        // 노드 형태로 값을 표현한다.
        // 주어진 알파벳을 이용해서, 해당 Node를 가져올 수 있게 HashMap에 넣어둔다.
        Map<String, Node> nodesMap = new HashMap<>();
        for(int idx=0; idx<N; idx++){
            Node node = new Node(valArr[idx]);
            nodesMap.put(valArr[idx], node);
        }

        for(int idx=0; idx<N; idx++) {
            String val = valArr[idx];
            Node node = nodesMap.get(val);

            if (leftArr[idx] != null) {
                node.left = nodesMap.get(leftArr[idx]);
            }

            if (rightArr[idx] != null) {
                node.right = nodesMap.get(rightArr[idx]);
            }

        }

        // 주어진 노드 관계로 전위, 중위, 후위 순회로 트리를 순회한다.
        // 루트를 시작으로 트리를 순회한다.
        String startingAlp = "A";
        Node root = nodesMap.get(startingAlp);

        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.append("\n");
        inorder(root, sb);
        sb.append("\n");
        postorder(root, sb);

        System.out.println(sb);


    }
    static class Node{
        String val;
        Node left;
        Node right;

        // 기본 생성자
        public Node(String val){
            this.val = val;
        }

        // 추가 생성자
        public Node(String val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 전위 순회
    // 값, 왼, 오 순으로 출력.
    // Leaf노드까지 도달하면 return 한다.
    // 재귀함수를 타고 들어가면서, 계속 sb를 들고 가면서 append를한다.
    static void preorder(Node node, StringBuilder sb){
        if(node==null)
            return;

        sb.append(node.val);
        preorder(node.left, sb);
        preorder(node.right, sb);

    }

    // 중위 순회
    // 왼, 값, 오 순으로 출력
    // Leaf 노드까지 도달하면 return 한다.
    static void inorder(Node node, StringBuilder sb){
        if(node == null)
            return;

        inorder(node.left, sb);
        sb.append(node.val);
        inorder(node.right, sb);

    }

    // 후위순회
    static void postorder(Node node, StringBuilder sb){
        if(node==null)
            return;

        postorder(node.left, sb);
        postorder(node.right, sb);
        sb.append(node.val);
    }

    // 그러니까 각 깊이에서 값, 왼, 오 를 어떤 순서대로 출력할 것인지를 결정하는 것이구나
    // 중위 순회라고 치면,
    // * D *
    // * B *
    // * A *
    // * E *
    // * C *
    // * F *
    // * G *
}
