import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 유지 보수성 및 코드 확장성을 고려해서 Str은 따로 관리하기
        String str1 = "         ,r'\"7";
        String str2 = "r`-_   ,'  ,/";
        String str3 = " \\. \". L_r'";
        String str4 = "   `~\\/";
        String str5 = "      |";

        int N = 5;
        String[] strArr = {str1, str2, str3, str4, str5};
        for(int i=0; i < N; i++){
            System.out.println(strArr[i]);
            // 마지막 요소는 한번 더 출력하기
            if(i==N-1)
                System.out.println(strArr[i]);
        }
    }

}
