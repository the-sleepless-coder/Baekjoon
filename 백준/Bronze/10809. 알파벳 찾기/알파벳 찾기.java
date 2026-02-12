import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] charArr = s.toCharArray();
        int len = charArr.length;

        int alphNum=26;
        int[] alphArr = new int[alphNum];
        for(int idx=0; idx<alphNum ;idx++){
            alphArr[idx]=-1;
        }

        for(int idx=0; idx<len; idx++){
            char c = charArr[idx];
            int charIdx = c-'a';

            //최초로 나온 시점에서만 해당 알파벳의 위치를 채워준다.
            if(alphArr[charIdx]==-1){
                alphArr[charIdx]=idx;
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int idx=0; idx<alphNum; idx++){
            sb.append(alphArr[idx]).append(" ");
        }

        System.out.println(sb);

    }

}

//각 알파벳이 처음 나오는 인덱스를 구해라.
//알파벳 없는 것은 -1로 초기화한다.
//alph의 위치를 찾으면 alphArr에 위치를 채워준다.

//그러니까 지금 투트랙으로 가져가면 된다.
// #1 알고리즘 - C 자료구조 구현 - C 문제 풀이
// #2 Java