import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        String parent;
        Node left;
        Node right;

        public Node(String parent){
            this.parent = parent;
        }

        public String getParent(){
            return parent;
        }

        public void setParent(String parent){
            this.parent = parent;
        }

        public Node getLeft(){
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight(){
            return right;
        }

        public void setRight(Node right){
            this.right = right;
        }

    }

    // String으로 받은 값을 이용해서, Node를 찾기 위해 만든 Hashmap
    static Map<String, Node> nodeMap = new HashMap<>();

    static Node createOrGetNode(String key){
        if(nodeMap.containsKey(key)){
            return nodeMap.get(key);
        }else{
            Node newNode = new Node(key);
            nodeMap.put(key, newNode);
            return newNode;
        }

    }

    static void preorder(Node cur, StringBuilder sb){
        if(cur==null) return;

        sb.append(cur.parent);
        preorder(cur.left, sb);
        preorder(cur.right, sb);
    }

    static void inorder(Node cur, StringBuilder sb){
        if (cur == null) return;

        inorder(cur.left, sb);
        sb.append(cur.parent);
        inorder(cur.right, sb);

    }

    static void postorder(Node cur, StringBuilder sb){
        if(cur == null) return;

        postorder(cur.left, sb);
        postorder(cur.right, sb);
        sb.append(cur.parent);

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 초기 root = null로 설정해준다.
        Node root = null;

        for(int i=0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // parent, left, right String을 받고 -> Node로 만들어준다.
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            // HashMap에 존재한다면 . 이 아닌 경우,
            // parent를 기준으로 left/right String으로 만든 Node를 넣어준다.
            Node p = createOrGetNode(parent);
            if(root == null) root = p;

            if(!left.equals(".")) p.left = createOrGetNode(left);
            if(!right.equals(".")) p.right = createOrGetNode(right);


        }

        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        System.out.println(sb);

        sb.setLength(0);
        inorder(root, sb);
        System.out.println(sb);

        sb.setLength(0);
        postorder(root, sb);
        System.out.println(sb);



    }




}
