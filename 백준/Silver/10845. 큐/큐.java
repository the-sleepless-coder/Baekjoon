import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0; i < N; i++){
            String str = sc.nextLine();
            String[] strArr = str.split(" ");
            String cmd = strArr[0];
            if(cmd.equals("push")){
                int t = Integer.parseInt(strArr[1]);
                q.add(t);
            }
            else if(cmd.equals("front")){
                if(!q.isEmpty()){
                    int t = q.getFirst();
                    System.out.println(t);
                }else{
                    System.out.println(-1);
                }
            }
            else if(cmd.equals("back")){
                if(!q.isEmpty()){
                    int t = q.getLast();
                    System.out.println(t);
                }else{
                    System.out.println(-1);
                }
                
            }
            else if(cmd.equals("empty")){
                if(q.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
            else if(cmd.equals("size")){
                System.out.println(q.size());
            }
            else if(cmd.equals("pop")){
                if(!q.isEmpty()){
                    int t = q.poll();
                    System.out.println(t);
                }else{
                    System.out.println(-1);
                }

            }

        }

    }
}
