import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[N];
        for(int idx=0; idx < N; idx++){
            arr[idx]= sc.nextInt();
        }
        sc.nextLine();

        int findNum = sc.nextInt();

        int count = 0;
        for(int idx = 0; idx<N; idx++){
            if(arr[idx] == findNum)
                count++;
        }

        System.out.println(count);

    }
}
