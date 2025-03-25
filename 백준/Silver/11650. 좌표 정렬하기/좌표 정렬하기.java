import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        List<crdns> coordinates = new ArrayList<>();
        for(int i=0; i < N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            coordinates.add(new crdns(x, y));
        }



        // Comparator 및 Lambda식을 이용한 정렬
        coordinates.sort((c1, c2) -> {
            // x가 동일하다면 y 기준 오름차순
            if(c1.getX() == c2.getX()){
               return c1.getY() - c2.getY();
           }

           // 기본적으로는 x 오름차순으로 정렬한다.
           return c1.getX() - c2.getX();
        });

        // System.out.println(coordinates);

        for(int i=0; i<N; i++){
            System.out.println(coordinates.get(i));
        }
    }


    public static class crdns{
        int x;
        int y;

        public crdns(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }





}
