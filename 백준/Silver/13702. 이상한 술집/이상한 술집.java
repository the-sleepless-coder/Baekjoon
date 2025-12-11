import java.io.BufferedReader;
import java.io.InputStream;
import java.io.*;
import java.util.*;

public class Main {
    // 최대한 많은 막거리를 분배할 수 있는 용량은 몇 ml인지 구해라.

    public static void main(String[] args) throws IOException {
        // 막걸리 주전자의 개수 N (<=10,000)
        // 은상이 포함 친구들의 수 K ( <=1,000,000)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int jars = Integer.parseInt(st.nextToken());
        int friends = Integer.parseInt(st.nextToken());

        // 어떤 형태로든 코드를 짜다보면 자료구조랑 논리에 대한 이해가 하나씩 되기 시작한다.
        // 그렇게 자료구조에 대한 논리에 대한 이해를 기반으로,
        // 조금씩 감이 잡히기 시작하면 알고리즘 문제를 풀면 실력이 확 오른다.

        // 왜냐하면 알고리즘의 가장 기초가 요구사항을 있는 그대로 구현하기
        // 그리고 자료구조를 이해하고 문제 상황에 맞게 논리를 코드로 작성하기이기 때문이다.

        // 그래서 어떤 형태로든 코드를 짜는 연습을 하고,
        // 요구 사항을 있는 그대로 코드로 구현하고
        // 그 뒤에 자료구조랑 논리에 대한 이해를 하게 되면 어떤 알고리즘 문제든 푸는 것이 훨씬 더 수월해져.
        Integer[] jarsArr = new Integer[jars];
        long min = 1;
        long max = -1;
        for(int j=0; j<jars; j++){
            jarsArr[j] = Integer.parseInt(br.readLine());

            max = Math.max(max, jarsArr[j]);
        }

        // 간단한 Pseudo Code를 항상 짜두고 시작하자.
        // 그렇게 시작하면 많은 문제들을 풀기가 훨씬 쉬워질 것이다.

        // low, high는 주전자 용량을 찾기 위한 값으로 사용된다.
        // low, high
        // mid = low + 1
        // mid = mid - 1;
        // 각 jar / mid = x

        // sum += x;
        // sum > friends
        // jar를 늘린다.

        // sum < friends
        // jar를 줄인다.

        // mid의 최대값을 찾을 때 그 값을 찾는다.
        long result = 0;

        while( min <= max){
            long mid = (min + max)/2;

            long sum = 0;
            for(int jar: jarsArr){
                sum += jar/mid;
            }

            // 용량의 최대값일 때 result를 출력한다.
            // 잔 수가 너무 많으니까 용량을 늘려준다.
            if(sum >= friends){
                min = mid + 1;
                result = mid;
            }

            // 잔 수가 너무 적으니까 용량을 줄여준다.
            if(sum < friends){
                max = mid - 1;
            }


        }

        // 그냥 일단 너무 많은 생각을 하지는 말자
        // 최대한 무지성으로 해당 유형을 따라서 풀고
        // 우선 유형에 익숙해지는 방법을 택하자.

        // 그렇게 무지성으로 좀 따라하다보면 나만의 알고리즘 푸는 스타일이 생길 것이고,
        // 기본적인 유형을 기준으로 자료구조와 논리를 익히게 되면
        // 새로운 유형에 대해서도 나만의 방식으로 알고리즘을 푸는 방식을 이해하게 될테니까 말이야.

        System.out.println(result);


    }
}
