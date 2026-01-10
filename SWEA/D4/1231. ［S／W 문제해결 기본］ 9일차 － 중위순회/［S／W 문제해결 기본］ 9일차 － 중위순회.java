import java.util.*;

public class Solution {
    // 일단 배열 3개를 써서 입력 받는 형식을 써보자.
    static int testCase = 10;
    static int start = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test = 1; test<=testCase; test++){

            int N = sc.nextInt();
            sc.nextLine();

            // 1-index 기준으로 저장한다.
            // 3개의 배열을 이용해서, 각 index에 대해서 value, left, right을 저장한다.
            // 해당 index에 대한 단면을 잘라보면, value, left, right값이 나온다.
            String[] value = new String[N+1];
            int[] left = new int[N+1];
            int[] right = new int[N+1];

            for(int idx=1; idx <= N; idx++){
                String line = sc.nextLine();
                String[] strArr = line.split(" ");
                int len = strArr.length;

                value[idx] = strArr[1];

                // 자식이 존재하면, left, right 배열에 값을 추가해주기
                if(len>=3){
                    left[idx] = Integer.parseInt(strArr[2]);
                }
                if(len>=4){
                    right[idx] = Integer.parseInt(strArr[3]);
                }

            }


            // 각 배열에 인덱스별, value, left, right 값을 담았음.
            // System.out.println(Arrays.toString(value));
            // System.out.println(Arrays.toString(left));
            // System.out.println(Arrays.toString(right));

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test).append(" ");
            // 중위 순회 방식으로 트리를 순회한다.
            inorder(value, left, right, start, sb);

            System.out.println(sb);

        }
    }


    // 자기 자신을 언제 출력하는지에 따라
    // 전위, 중위 후쉬 순회를 돈다.
    // 왼쪽, 가운데, 오른쪽 출력

    // 재귀함수의 특징은 결과를 입력값으로 다시 쓴다는 것과
    // Base case를 통해서 재귀를 멈추는 조건을 설정한다는 것임을 잊지 말자.

    // leftNumber, rightNumber로 들어간 값이 0이라면 재귀를 멈춘다.
    // 그러니까 결국 해당 값이 0 즉 존재하지 않는다면,
    // 그때 재귀를 멈추고 가운데 값을 출력한다.
    private static void inorder(String[] value, int[] left, int[] right, int number, StringBuilder sb){
        int leftNumber = left[number];
        int rightNumber = right[number];

        if(number ==0)
            return ;

        inorder(value, left, right, leftNumber,sb);
        sb.append(value[number]);
        inorder(value, left, right, rightNumber,sb);
    }


}

//8
//1 W 2 3
//2 F 4 5
//3 R 6 7
//4 O 8
//5 T
//6 A
//7 E
//8 S