import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();

        // crd 객체로 숫자를 저장한다.
        ArrayList<CRD> crdList = new ArrayList<>();

        for(int idx=0; idx<N; idx++){
            int x= sc.nextInt();
            int y= sc.nextInt();

            CRD crd = new CRD(x, y);
            crdList.add(crd);
        }

        // ArrayList에서 주어진 lambda식을 이용해서 기준대로 정렬하기.

        // Comparator 및 Lambda식을 이용한 정렬
        // c1<c2 = 음수, c1>c2 = 양수.
        // 그냥 숫자를 빼는 것보다 Integer.compare함수를 쓰는 것이 IntegerOverflow가 안 나게 하는 데 있어서 도움 된다.
        crdList.sort((c1, c2)->{
            // 기본적으로 X오름차순.
            if(c1.getX()!=c2.getX()){
                return Integer.compare(c1.getX(), c2.getX());
           }else{
            // X가 같다면 Y 오름차순.

            return Integer.compare(c1.getY(), c2.getY());
           }
        });

        // 가변 객체로서 sb활용.
        StringBuilder sb = new StringBuilder();
        for(int idx=0; idx<N; idx++){
            CRD temp = crdList.get(idx);

            int X = temp.getX();
            int Y = temp.getY();
            sb.append(X).append(" ").append(Y);
            if(idx!=N-1)
                sb.append("\n");
        }

        System.out.println(sb);

    }


    static class CRD{
        int x;
        int y;

        public CRD(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }
    }

}
// x좌표가 증가하는 순으로,
// x좌표가 같으면 y좌표가 증가하는 순으로 정렬한다.