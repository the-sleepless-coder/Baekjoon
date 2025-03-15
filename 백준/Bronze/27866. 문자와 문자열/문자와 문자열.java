import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int N = sc.nextInt();

        char[] charArr = str.toCharArray();

        System.out.println(charArr[N-1]);


    }
}
