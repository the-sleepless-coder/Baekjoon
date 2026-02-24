import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char[] charArr = input.toCharArray();

        int len = charArr.length;
        int count = 0;
        for(int idx=0; idx < len; idx++){
            // 그러니까 해당 문자가 나왔을 때,
            // 다음 문자를 검사해서 크로아티아 알파벳이 나오면 idx를 띄어넘는다.
            if(charArr[idx]=='c') {
                if(idx<=len-2){
                    if(charArr[idx+1]=='='||charArr[idx+1]=='-'){
                        idx++;
                    }
                }
            }else if(charArr[idx]=='d'){
                if(idx <= len-3){
                    // 인덱스 범위를 벗어날 수 있기 때문에,
                    // 인덱스 범위를 잘 잡아주는 것이 중요하다.
                    if(charArr[idx+1]=='z'&&charArr[idx+2]=='='){
                        idx+=2;
                    }
                }

                if(idx<=len-2){
                    if(charArr[idx+1]=='-'){
                        idx++;
                    }
                }

            }else if(charArr[idx]=='l'){
                if(idx<=len-2){
                    if(charArr[idx+1]=='j'){
                        idx++;
                    }
                }
            }else if(charArr[idx]=='n'){
                if(idx<=len-2){
                    if(charArr[idx+1]=='j'){
                        idx++;
                    }
                }
            }else if(charArr[idx]=='s'){
                if(idx<=len-2){
                    if(charArr[idx+1]=='='){
                        idx++;
                    }
                }
            }else if(charArr[idx]=='z'){
                if(idx<=len-2){
                    if(charArr[idx+1]=='='){
                        idx++;
                    }
                }
            }

            // 그 외 알파벳은 하나씩 인덱스를 띄어넘어가면서 검사.
            count++;
        }

        System.out.println(count);

    }
}
