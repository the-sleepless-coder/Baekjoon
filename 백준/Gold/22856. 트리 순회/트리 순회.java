import java.util.*;
import java.io.*;

public class Main {
    static int depthCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());

        Map<Integer, Node> map = new HashMap<>();
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            Node getNode = null;
            if(map.containsKey(num)){
                getNode = map.get(num);
            }else{
                map.put(num, new Node(num));
                getNode = map.get(num);
            }

            // 왼쪽 노드 지정.
            if(left!=-1){
                if(map.containsKey(left)){
                    getNode.left = map.get(left);
                }else{
                    map.put(left, new Node(left));

                    getNode.left = map.get(left);
                }

            }

            // 오른쪽 노드 지정.
            if(right!=-1){
                if(map.containsKey(right)){
                    getNode.right = map.get(right);

                }else{
                    map.put(right, new Node(right));

                    getNode.right = map.get(right);
                }
            }


        }

        Node root = map.get(1);
        findLastDepth(root);
        // System.out.println(depthCount);

        // 총 왕복 횟수 - 마지막 노드까지의 깊이
        int resultNum = 2*(N-1) - (depthCount-1);
        System.out.println(resultNum);

        /**
        // 중위 순회를 통해서 마지막에 탐색한 노드에 도달할 때까지,
        // 유사 중위 순회를 이어간다.
        StringBuilder sb1 = new StringBuilder();
        inorder(root, sb1);
        // System.out.println(sb1);

        int last = Integer.parseInt(String.valueOf(sb1).split(" ")[N-1]);

        StringBuilder sb2 = new StringBuilder();
        inorderCustomized(root, sb2);
        String[] result = String.valueOf(sb2).split(" ");
        // System.out.println(sb2);

        int resultCount = 0;
        for(String str: result){
            int t = Integer.parseInt(str);

            resultCount++;
            // System.out.printf(t+" ");
            if(t==last) break;

        }

        // 이동횟수를 구해야하기 때문에,
        // 전체 노드 - 1을 출력한다.
        // System.out.println(resultCount-1);
         */
    }

    // 가장 오른쪽 노드까지의 깊이가,
    // 마지막 노드까지의 깊이를 의미한다.
    // 항사 중위 순회에서 가장 오른쪽 노드가 마지막에 탐색되니까.
    static void findLastDepth(Node node){
        if(node==null) return;

        depthCount+=1;
        findLastDepth(node.right);
    }

    static void inorder(Node node, StringBuilder sb){
        if(node == null) return;

        inorder(node.left , sb);
        sb.append(node.val+" ");
        inorder(node.right, sb);
    }


    // 중위 순회를 하는 이동 횟수를 구해라.
    // 트리를 타고 내려갈 때는 전위 순회로, 자신을 출력한다.
    // 리프 노드가 아니라면 중위 순회를 통해 다시 트리를 타고 올라간 값을 기록한다.
    static void inorderCustomized(Node node, StringBuilder sb){
        if(node==null) return;

        sb.append(node.val+" ");
        inorderCustomized(node.left, sb);
        if(node.left!=null || node.right!=null) sb.append(node.val+" ");
        inorderCustomized(node.right, sb);
        if(node.left!=null || node.right!=null) sb.append(node.val+" ");
    }


    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }

    }



}
