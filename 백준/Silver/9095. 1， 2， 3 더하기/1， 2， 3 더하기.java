import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<testCase; t++){

            int N = Integer.parseInt(br.readLine());
            
            int result = -1;
            if(N==1){result =1;}
            else if(N==2){result = 2;}
            else if(N==3){result = 4;}
            else if(N==4){result = 7;}
            else if(N==5){result = 13;}
            else if(N==6){result = 24;}
            else if(N==7){result = 44;}
            else if(N==8){result = 81;}
            else if(N==9){result = 149;}
            else if(N==10){result = 274;}
            else if(N==11){result = 504;}
                
            sb.append(result);

            if(t!=testCase-1)
                sb.append("\n");
            //System.out.println(result);
        }

        System.out.println(sb);

    }
}    