import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 덩치 등수를 구해서 순서대로 출력한다.
        ArrayList<Person> personList = new ArrayList<Person>();
        for(int idx=0; idx<N; idx++){
            int weight = sc.nextInt();
            int height = sc.nextInt();

            Person p = new Person(weight, height);
            personList.add(p);
        }

        // 내림차순으로 정렬한다.
        // 둘다 크다면 1을 반환하여 덩치가 큰 사람을 앞으로,
        // 둘다 작다면 -1을 반환하여 순서를 유지해서 작은 사람을 뒤로 보낸다.
        /**personList.sort((p1, p2)->{
            if(p1.getW()<p2.getW() && p1.getH()<p2.getH()){
                return 1;
            }else if(p1.getW() > p2.getW() && p1.getH() > p2.getH()){
                return -1;
            }else{
                return 0;
            }
        });
         */

        // 정렬을 다 해 놓고, 이미 정렬된 상태에서 등수만 내면 되지 않을까?
        // 정렬 안된 것을 세는 것이 어려움.

        // 자기 자신을 제외한 다른 모든 사람과의 비교
        // 자신 보다 큰 것이 있으면 +1을 해준다.

        // 물론 3개의 배열에 넣어서 관리해줄 수 있지만,
        // 어차피 하나의 객체에 모든 데이터를 다 넣을 수 있으니 이렇게 관리하는 편이 더 편하다.
        for(int i=0; i<N; i++){
            Person curr = personList.get(i);
            for(int j=0; j<N; j++){
                Person comp = personList.get(j);
                if(i!=j){
                    // 나보다 둘다 클 경우 pos +1을 해준다.(순위를 뒤로 미뤄준다.)
                    if( curr.weight < comp.weight && curr.height < comp.height ){
                        curr.pos+=1;
                    }
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for(int idx=0; idx<N; idx++){
            Person temp = personList.get(idx);
            sb.append(temp.pos).append(" ");
        }

        System.out.println(sb);
    }


    // ㅋ 그걸 객체에 담았어야지 그러면 읽기도 훨씬 더 편해을텐데 말이야.
    // 복잡한 형태의 데이터는 객체에 한꺼번에 담아서 저장하는 것이 효과적이다.
    static class Person{
        int weight;
        int height;
        int pos;

        public Person(int weight, int height){
            this.weight = weight;
            this.height= height;
            this.pos = 1;
        }

        public int getW(){
            return this.weight;
        }

        public int getH(){
            return this.height;
        }

    }
}
// 덩치가 더 큰 사람의 순서대로 출력한다.
// 몸무게와 키 모두 큰 사람을 덩치가 큰 사람이라고 정의한다.
