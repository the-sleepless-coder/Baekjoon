import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        // 노드의 앞 뒤 선후 관계 주소를 이어 붙일 수 있게 Node 배열을 만든다.
        Node[] head = new Node[N];
        Node[] tail = new Node[N];
        boolean[] headList = new boolean[N];
        for(int idx=0; idx<N; idx++){
            String s = sc.next();
            Node n = new Node(s);

            head[idx] = n;
            tail[idx] = n;
            headList[idx] = true;
        }

        int[][] nameChange = new int[N-1][2];
        for(int idx=0; idx<N-1; idx++){
            nameChange[idx][0] = sc.nextInt()-1;
            nameChange[idx][1] = sc.nextInt()-1;
        }

        // aIdx뒤로 bIdx가 있다는 사실을 Node를 통해 기록한다.
        // 각각의 head랑 tail의 주소값을 Node 배열에서 관리한다.
        // a tail - b head를 이어주고, a의 tail을 업데이트 한다.
        // a tail로 한번도 지정 안된 것이 최종 Head이다.
        Set<Node> tailSet = new HashSet<>();
        for(int idx=0; idx<N-1; idx++){

            int fIdx = nameChange[idx][0] ;
            int bIdx = nameChange[idx][1] ;

            tail[fIdx].next = head[bIdx];
            Node tailNode = head[bIdx];
            tailSet.add(tailNode);

            tail[fIdx] = tail[bIdx];
        }
        // 1 2 3 4 5
        // 3 3 3 5 5

        // StringBuilder가 어떻게 작동하는지도 좀 알아야 해.
        StringBuilder sb = new StringBuilder();

        for(int idx=0; idx<N; idx++){
            if(tailSet.contains(head[idx])){
                headList[idx] = false;
            }
        }

        int headIdx = -1;
        for(int idx=0; idx<N; idx++){
            if(headList[idx])
                headIdx=idx;
        }

        Node currNode = head[headIdx];
        for(int idx=1; idx<=N; idx++){
            sb.append(currNode.val);
            currNode = currNode.next;
        }

        System.out.println(sb);

        // 그러니까 curr(value, next)
        // curr -> next Node로 넘어가면서 다음 주소로 넘어가고 순회해야 조회든 검색이든 가능해.

        // 다른 primitive이 아니라 Collection에 해당하는 자료형들은 굳이 ToString이 없어도,
        // 알아서 print할 때 toString이 함수 override돼서 출력되는 것이었구나;
        // System.out.println(Arrays.deepToString(nameChange));

    }


}

class Node{
    String val;
    Node next;

    public Node(String val){
        this.val = val;
        this.next = null;
    }

    public Node(String val, Node next){
        this.val = val;
        this.next =  next;
    }

}