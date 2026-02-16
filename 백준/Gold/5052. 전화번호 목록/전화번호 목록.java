import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=testCase; t++){

            int N = Integer.parseInt(br.readLine());
            Trie trie = new Trie();

            // 각 입력 받은 문자열을 trie에 넣는다.
            String[] words = new String[N];
            for(int idx=0; idx<N; idx++){
                String s  = br.readLine();
                words[idx] = s;
                trie.insertString(s);
            }

            boolean noPrefixes = true;
            // 각 문자열이 다른 문자열의 접두사인지 확인한다.
            for(int idx=0; idx<N; idx++){
                String prefix = words[idx];
                boolean checkPref = trie.checkPrefix(prefix);

                if(checkPref){
                    noPrefixes = false;
                    break;
                }
            }

            if(noPrefixes){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }

        }
        System.out.println(sb);


    }
    // 숫자를 타고 들어가면서 Trie를 구성할 수 있는 TrieNode를 만들어준다.
    static class TrieNode{
        TrieNode[] children = new TrieNode[10];
        boolean isEnd = false;
    }

    static class Trie{
        // 단어를 저장하는 주소 표시,
        // 그리고 어떠한 문자로도 시작하지 않는 시작점으로 사용.
        // 그러니까 결국 children부터 첫 문자가 들어가는 구조이다.
        TrieNode root = new TrieNode();

        // TrieNode를 이용해서 Trie를 만들어준다.
        public void insertString(String word){
            // root에서 시작해서 하나씩 노드를 타고 들어간다.
            TrieNode node = root;

            char[] charArr  = word.toCharArray();

            // 단어 끝까지 각 문자를 TrieNode에 기록해준다.
            for(char c: charArr){
                int idx = c - '0';

                // 노드를 타고 들어갔을 때 값이 없다면,
                // 해당 값의 인덱스를 TrieNode로 채워준다.
                if(node.children[idx] == null){
                    node.children[idx] = new TrieNode();
                }

                node = node.children[idx];
            }

            // 문자끝까지 도달했으면 해당 문자가 끝임을 기록한다.
            node.isEnd = true;
        }

        // Trie 구조 내에서 해당 단어가 접두사인지 확인한다.
        // 대신 자기 자신을 제외하고 체크를 해야 한다.
        public boolean checkPrefix( String prefix ) {
            TrieNode node = root;

            char[] charArr = prefix.toCharArray();

            for (char c : charArr) {
                int idx = c - '0';

                // 단어의 문자가 이어지지 않는 구간이 있다면
                // 접두사가 존재 안한다.
                if (node.children[idx] == null)
                    return false;

                node = node.children[idx];

            }

            // 마지막 인덱스의 숫자에서 하나의 문자열이라도 자식으로 존재한다면,
            // prefix 라고 판단한다.
            TrieNode[] children = node.children;
            for(TrieNode tn:children){
                if(tn != null){
                    return true;
                }
            }

            // 접두사 뒤에 어떠한 문자도 존재하지 않는다면,
            // prefix가 아니라고 판단한다.
            return false;

        }

    }


}
// Trie에 넣고 접두사로 들어가 있는지 검증하면,
// O(N)의 시간 복잡도가 나오니까 문제 해결 가능.

// 그러니까 구체적으로는 입력하면서 O(N),
// 접두사인지 검증하는 과정에서 O(N) 이라서 O(2*N)인데 어쨋든 시간 복잡도는 O(N)인 셈.