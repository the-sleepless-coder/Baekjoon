import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tot = Integer.parseInt(br.readLine());

        ArrayList<Person> personList = new ArrayList<>();
        for(int idx=0; idx<tot; idx++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age=Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            
            Person p = new Person(age, name, idx+1);
            personList.add(p);

        }

        //나이 다르면 나이 순서대로,
        // 나이가 같다면 가입 순서대로 정려한다.
        personList.sort((p1, p2)->{
            if(p1.age != p2.age){
                return Integer.compare(p1.age,p2.age);
            }else{
                return Integer.compare(p1.pos, p2.pos);
            }

        });

        StringBuilder sb = new StringBuilder();
        int N = personList.size();
        for(int idx=0; idx<N; idx++){
           Person temp = personList.get(idx);
           sb.append(temp.age).append(" ").append(temp.name);
           if(idx!=N-1)
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static class Person{
        int age;
        String name;
        int pos;

        public Person(int age, String name, int pos){
            this.age = age;
            this.name = name;
            this.pos = pos;
        }

        public int getAge(){
            return this.age;
        }

        public String getName(){
            return this.name;
        }

    }

}

// 나이가 증가하는 순으로,
// 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬한다.