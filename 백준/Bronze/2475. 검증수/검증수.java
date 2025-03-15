import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 5;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i < N; i++){
            int a= sc.nextInt();
            arr.add(a);
        }

        // System.out.println(arr);
        
        int sum = 0;
        for(int i=0; i<N; i++){
            int b = arr.get(i);
            sum+= (int)Math.pow(b,2);
        }

        int check = 0;
        check = sum % 10;

        System.out.println(check);

    }
}
