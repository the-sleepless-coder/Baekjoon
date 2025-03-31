import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Person 클래스를 만들어서, 나이 및 이름 입력값을 받는다.
        int N = Integer.parseInt(sc.nextLine());
        ArrayList<Person> arr = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int age = sc.nextInt();
            String name = sc.next();
            Person p = new Person(age, name);
            arr.add(p);
        }


        // 2개의 Person 객체에 대해서, 나이를 기준으로 오름차순으로 정렬한다.
        arr.sort((o1, o2)-> o1.age - o2.age);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.size(); i++){
            int age = arr.get(i).age;
            String name = arr.get(i).name;

            sb.append(age);
            sb.append(" ");
            sb.append(name);
            if(i!=arr.size()-1)
                sb.append("\n");
        }

        System.out.println(sb);

    }

    static class Person{
        int age;
        String name;

        public Person(){

        }

        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
