import java.util.*;

public class Solution {
    static int testCase = 10;
    static int startIdx = 1;

    // 중위 순회 기준으로 출력을 하고
    // 정수와 문자열이 번갈아가면서 있으면 사칙연산이 유효하다고 볼 수 있다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int test=1; test <= testCase; test++){
            int N = sc.nextInt();
            sc.nextLine();

            String[] value = new String[N+1];
            int[] left = new int[N+1];
            int[] right = new int[N+1];

            for(int idx=1; idx<=N; idx++){
                String line = sc.nextLine();
                String[] strArr = line.split(" ");
                int len = strArr.length;

                value[idx] = strArr[1];
                if(len>=3){
                    left[idx] = Integer.parseInt(strArr[2]);
                }
                if(len>=4){
                    right[idx] = Integer.parseInt(strArr[3]);
                }
            }

            StringBuilder sb = new StringBuilder();
            inorder(value, left, right, startIdx, sb);

            String strSb = String.valueOf(sb);
            char[] charArr = strSb.toCharArray();
            int len = strSb.length();

            boolean isLegit = true;
            for(int idx=0; idx<len; idx++){
                String strValue="";
                boolean isDigit = true;
                char c = charArr[idx];

                if(idx%2==0){
                    isDigit = Character.isDigit(c);
                    if(!isDigit){
                        isLegit=false;
                        break;
                    }
                }
                else{
                    if(c=='+' || c=='-' || c=='/'|| c=='*')
                        continue;
                    else{
                        isLegit = false;
                        break;
                    }

                }

            }
            // System.out.println(sb);
            //System.out.println(isLegit);

            StringBuilder result = new StringBuilder();
            int resultNum=-1;
            if(isLegit)
                resultNum=1;
            else
                resultNum=0;

            result.append("#").append(test).append(" ").append(resultNum);
            System.out.println(result);
        }



    }

    // 왼쪽, 오른쪽 노드가 존재하지 않을 시에 재귀함수를 끝낸다.
    // 함수의 결과값으로 나오는 것이 입력값으로 다시 들어간다는 것이 재귀함수의 핵심임을 잊지 말자.
    public static void inorder(String[] value, int[] left, int[] right, int nodeIdx, StringBuilder sb){
        if(nodeIdx==0)
            return;

        int leftIdx = left[nodeIdx];
        int rightIdx = right[nodeIdx];

        String nodeValue = value[nodeIdx];

        inorder(value, left, right, leftIdx, sb);
        sb.append(nodeValue);
        inorder(value, left, right, rightIdx, sb);

    }

}

//9
//1 * 2 3
//2 + 4 5
//3 - 6 7
//4 / 8 9
//5 2
//6 6
//7 *
//8 8
//9 7