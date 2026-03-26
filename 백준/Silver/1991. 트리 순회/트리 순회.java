import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //동일한 노드를 갖고 오기 위한 Map형성.
        Map<String, Node> nodes = new HashMap<>();
        for(int n=0; n<N; n++){
            char c = (char)('A'+ n);
            String key = String.valueOf(c);
            nodes.put(key, new Node(key));
        }

        for(int n=0; n<N; n++){
            String input = br.readLine();

            String[] nodeArr = input.split(" ");

            String val = nodeArr[0];
            String leftVal = nodeArr[1];
            String rightVal = nodeArr[2];

            Node node = nodes.get(val);
            if(!leftVal.equals(".")){
                node.left = nodes.get(leftVal);
            }

            if(!rightVal.equals(".")){
                node.right = nodes.get(rightVal);
            }
        }

        // 시작하는 노드를 기준으로,
        // 전, 중, 후위순회 방식으로 트리를 순회한다.
        // 어차피 시작점에서 연결 돼 있는 노드들의 주소만 알면,
        // 모든 노드를 순회할 수 있다.
        Node startingNode = nodes.get("A");
        StringBuilder sb = new StringBuilder();

        preorder(startingNode, sb);sb.append("\n");
        inorder(startingNode, sb);sb.append("\n");
        postorder(startingNode, sb); sb.append("\n");

        System.out.println(sb);

    }

    // 전위 순회
    // 부모노드를 언제 순회하는지에 따라,
    // 전,중,후위순회 방식으로 나뉜다.
    // 부모 - 왼쪽 - 오른쪽
    // 왼쪽, 오른쪽 노드가 null일 경우에는 재귀함수를 종료해준다.
    static void preorder(Node node, StringBuilder sb){
        if(node==null) return;

        sb.append(node.val);
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    // 부모노드를 중간에 출력한다.
    // 왼쪽, 부모, 오른쪽
    static void inorder(Node node, StringBuilder sb){
        if(node==null) return;

        inorder(node.left, sb);
        sb.append(node.val);
        inorder(node.right, sb);
    }

    static void postorder(Node node, StringBuilder sb){
        if(node==null) return;

        postorder(node.left, sb);
        postorder(node.right, sb);
        sb.append(node.val);

    }

    static class Node{
        String val;
        Node left;
        Node right;

        public Node(String val){
            this.val = val;
        }

        public Node(String val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }


}
