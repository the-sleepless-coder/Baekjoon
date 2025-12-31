import java.util.*;

public class Solution {
    static int N = 10;
    static int S = 8;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        for(int test = 1; test <= N; test++){
            int findLen = sc.nextInt();
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
            int total = 0;

            for(int row = 0; row < S; row++) {
                for(int start = 0; start <= S - findLen; start++){
                    boolean isPalindrome = true;
                    int count = 0;
                    for (int col = 0; col < findLen; col++) {
                        if(graph[row][start + col] != graph[row][ start + findLen - 1 - col]){
                            isPalindrome = false;
                            break;
                        }
                        count++;

                    }

                    if(isPalindrome && count==findLen){
                        total++;
                    }
                }
            }

            for(int col = 0; col < S; col++) {
                for(int start=0; start <= S - findLen; start++){
                    boolean isPalindrome = true;
                    int count = 0;
                    for (int row = 0; row < findLen; row++) {
                        if(graph[start + row][col] != graph[start + findLen-1-row][ col ]){
                            isPalindrome = false;
                            break;
                        }
                        count++;

                    }

                    if(isPalindrome && count == findLen){
                        total++;
                    }
                }
            }

            System.out.printf("#%d %d\n",test, total);


        }

    }
//4
//CBBCBAAB
//CCCBABCB
//CAAAACAB
//BACCCCAC
//AABCBBAC
//ACAACABC
//BCCBAABC
//ABBBCCAA

}
