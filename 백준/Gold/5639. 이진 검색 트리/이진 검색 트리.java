import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root=null;
        String line;
        while((line = br.readLine()) != null ){
            int num = Integer.parseInt(line);

            root = Node.insertNode(root, num);
        }

        StringBuilder sb = new StringBuilder();
        postorder(root, sb);

        System.out.println(sb);

    }

    // 숫자를 담을 노드를 만든다.
    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }

        static Node insertNode(Node node, int value){
            // 노드가 없으면 노드를 생성하고 돌려준다.
            if(node==null){
                Node newNode = new Node(value);

                return newNode;

            }
            // 값이 더 작다면 왼쪽으로 노드를 형성한 후 되돌려준다.
            // 반대도 마찬가지.
            else if( node.value > value ){
                node.left = insertNode(node.left, value);
            }else if(node.value < value){
                node.right = insertNode(node.right, value);
            }

            // 최초 node시작점을 반환해준다.
            return node;
        }

    }

    static void postorder(Node node, StringBuilder sb){
        if(node == null)
            return;

        postorder(node.left, sb);
        postorder(node.right, sb);
        sb.append(node.value).append("\n");
    }


}



// 전위 순회한 결과를 줬을 때,
// 후위 순회한 결과를 내놓아라.