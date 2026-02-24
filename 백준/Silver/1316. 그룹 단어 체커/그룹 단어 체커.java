import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int groupWordCount = 0;
        for(int test=0; test<N; test++){
            // 알파벳 그룹의 개수가 1개를 넘어가면,
            // isGroupWord = false이다.
            char[] charArr = br.readLine().toCharArray();
            int[] alphaGroup = new int[26];

            boolean isGroupWord = true;
            int len = charArr.length;
            for(int k=0; k <= len-2; k++){
                if(k<=len-2){
                    char curr = charArr[k];
                    char next = charArr[k+1];
                    int currIdx = curr-'a';
                    int nextIdx = next-'a';

                    if(curr!=next){
                        alphaGroup[currIdx]++;

                        // 항상 문자의 끝에서 그룹을 확인하기 때문에,
                        // 가장 마지막에 문자열이 하나 남아 있다면 그것은 따로 확인이 필요하다.
                        if(k==len-2){
                            alphaGroup[nextIdx]++;
                        }
                    }else{
                        // 서로 다른 알파벳 그룹은 같을 때만 더해지기 때문에,
                        // 같은데 마지막에 있는 그룹이 있다면 처리를 따로 해줘야 한다.
                        if(k==len-2){
                            alphaGroup[nextIdx]++;
                        }

                    }

                }
            }

            // 알파벳 그룹이 2개이상 나오면,
            // isGroupWord = false 처리를 해준다.
            for(int idx=0; idx<26; idx++){
                if(alphaGroup[idx]>=2){
                    isGroupWord = false;
                    break;
                }
            }

            // System.out.println(Arrays.toString(alphaGroup));
            if(isGroupWord){
                groupWordCount++;
            }

        }

        System.out.println(groupWordCount);

    }
}

//hhaappya
//babb
//aabba