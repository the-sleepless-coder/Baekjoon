/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine().trim());

        // char 배열을 이용한 swap 구문을, 2개의 포인터를 이용해서 회문인지를 확인해보자
        // str -> char 배열로 바꿔도 되긴한데, 이미 쓸 수 있는 함수가 있다면 굳이?
        for(int i=0; i<testCase; i++){
            String str = sc.nextLine().trim();

            int len = str.length();
            boolean isPalindrome = false;
            // 총 길이가 홀수라면 가운데 숫자 제외하고 절반씩 확인하고,
            // 총 길이가 짝수라면 절반의 인덱스까지 확인한다.
            // j의 for문 인덱스를 str의 끝까지 잘못 걸면, 무조건 참이 나오니 주의하자.
            int cnt = 0;
           for(int j=0; j<len/2 ; j++){
//                System.out.println(str.charAt(j));
//                System.out.println(str.charAt(len-1-j));

                while(cnt < len/2 && (str.charAt(j) == str.charAt(len-1-j))){
                    cnt++;
//                    System.out.println("실행");
//                    System.out.println(str.charAt(j));
//                    System.out.println(j);
//                    System.out.println(str.charAt(len-1-j));
//                    System.out.println(len-1-j);
                }
                if(cnt == len/2){
                    isPalindrome = true;
                }
            }

            if(isPalindrome){
                System.out.printf("#%d %d%n", i+1, 1);
            }else{
                System.out.printf("#%d %d%n", i+1, 0);
            }


        }

    }
}