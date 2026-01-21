import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();

        for(int t=1; t<=testCase; t++){
            int k = sc.nextInt();
            String input = sc.next();
            char[] charArr = input.toCharArray();
            int len = charArr.length;

            String[] strArr = new String[len];
            for(int idx=0; idx<len; idx++){
                char c = charArr[idx];
                String s = String.valueOf(c);
                strArr[idx]=s;
            }

            ArrayList<String> arr = new ArrayList<>();
            for(int times=0; times<len; times++){
                StringBuilder sb = new StringBuilder();

                for(int idx=times; idx<len; idx++){
                    sb.append(strArr[idx]);
                }
                arr.add(String.valueOf(sb));
            }

            //System.out.println(arr);
            Collections.sort(arr);
            // System.out.println(arr);

            String result = "";
            if(k>=len)
                result = "none";
            else
                result = arr.get(k-1);

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(result);

            System.out.println(sb);
        }
        

        /**
        ArrayList<String> arr = new ArrayList<>();
        String s1 = "en";
        String s2 = "een";

        arr.add(s1);
        arr.add(s2);

        System.out.println(arr);

        Collections.sort(arr);

        System.out.println(arr);
         */
    }
}

//문자열 최대 길이 : 400

//1
//3
//mybeen

//been
//een
//en
//mybeen
//n
//ybeen
