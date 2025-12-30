import java.util.*;

public class Solution {
    static int N = 10;
    static int S = 100;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        for(int test = 0; test<N; test++){
            int testCase = sc.nextInt();
            sc.nextLine();

            char[][] graph = new char[S][S];
            for(int row = 0; row < S; row++){
                String rowString = sc.nextLine();
                char[] charArr = rowString.toCharArray();
                for(int col = 0; col<S; col++){
                    graph[row][col] = charArr[col];
                }
            }

            // 각 행에서 검사를 한다.
            // 몇 개의 칸에서 검사를 할 것인지 정하고,
            // 열을 기준으로 검사를 진행한다.

            // 전체적인 제어문 순서를 어떻게 설정할지를 생각한다.
            // 그래서 전체 논리에서 어떤 제어문을 열고 닫을지를 결정해서,
            // 전체 제어 흐름에서 어떻게 반복문과 조건문을 설정해서 제어 논리를 작성할지를 생각하면 된다.
            int max = 1;
            for(int row = 0; row < S; row++) {
                for(int len=1; len <= S; len++){

                        for(int start = 0; start <= S - len; start++){
                            boolean isPalindrome = true;
                            int count = 0;
                            for (int col = 0; col < len; col++) {
                                if(graph[row][start + col] != graph[row][ start + len - 1 - col]){
                                    isPalindrome = false;
                                    break;
                                }
                                count++;

                            }

                            if(isPalindrome){
                                max = Math.max(max, count);
                            }

                        }

                }

            }

            for(int col = 0; col < S; col++) {
                for(int len=1; len <= S; len++){

                    for(int start=0; start <= S - len; start++){
                        boolean isPalindrome = true;
                        int count = 0;
                        for (int row = 0; row < len; row++) {
                            if(graph[start + row][col] != graph[start + len-1-row][ col ]){
                                isPalindrome = false;
                                break;
                            }
                            count++;

                        }

                        if(isPalindrome){
                            max = Math.max(max, count);
                        }

                    }

                }
            }

            System.out.printf("#%d %d\n",testCase, max);


            // 일단 기본적으로 피드백 받은 사항에 대해서 마무리하자.

            // 알고리즘 풀이
            // 포트폴리오 피드백, Github 정리, Notion 정리
            // C로 마무리해야 하는 프로젝트들, 자료구조 && 네트워크

            // RAG로 영상 처리하는 것까지 해보자.
            // 내가 아이디어로만 생각하고 있던 것을 직접 코드로 구현.

            // System.out.println(Arrays.deepToString(graph));

        }

    }
//1
//CBCABBAC
//BBABCABA
//ABCBCACA
//BACCAABB
//BCBCACBC
//CABACCCB
//CAAACCAB
//CBABACAC

}
