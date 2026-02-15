import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        // 하나의 Trie에 넣어서
        // 차례대로 모든 단어의 시작에서부터 끝까지 넣는다.
        // a - p - p - l- e;
        //      \ -e

        Trie trie = new Trie();

        for(int idx=0; idx<N; idx++){
            String s = br.readLine();
            trie.makeTrie(s);
        }

        // 넣은 단어가 해당 Trie 구조에 들어 있는지 확인해준다.
        int count= 0;
        for(int idx=0; idx<R; idx++){
            String s= br.readLine();
            boolean bool = trie.checkPrefix(s);

            if(bool){
                count++;
            }
        }

        System.out.println(count);


    }

    // Trie를 구성하는 Node이다.
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;

    }

    // TrieNode를 이용해서 Trie를 만든다.
    static class Trie{
        TrieNode root = new TrieNode();

        public void makeTrie(String word){
            // root 주소에서부터 시작한다.
            TrieNode node = root;
            char[] charArr = word.toCharArray();

            // 각 char를 trieNode의 children 인덱스를 타고 들어가면서,
            // 모든 글자를 TrieNode에 넣어준다.

            // 이미 해당 단어가 들어 있다면 children으로 넣을 필요 없고,
            // 없다면 넣어주면서 새로운 단어를 생성해준다.

            // prefix를 공유하고 그 하위에 단어들을 붙여 넣으면서,
            // 새로운 단어를 붙여 넣는 방식이다.
            for(char c: charArr){
                int idx = c -'a';

                if(node.children[idx]==null){
                    node.children[idx] = new TrieNode();
                }

                node = node.children[idx];
            }

            // Word의 마지막임을 표시해준다.
            node.isEnd = true;
        }

        // 각 단어 안에 해당 prefix가 존재하는지 확인한다.
        public boolean checkPrefix(String givenWord){
            TrieNode node = root;

            // 단어를 타고 들어가면서, prefix에 없는 단어가 나오면 false처리를 한다.
            char[] charArr = givenWord.toCharArray();
            for(char c: charArr){
                int idx = c-'a';

                if(node.children[idx]==null){
                    return false;
                }

                node = node.children[idx];

            }

            return true;
        }

    }

}
