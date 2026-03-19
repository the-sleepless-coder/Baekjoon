import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        // 테스트 케이스별
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            String cmd = null;
            int num = -1;

            // 각 key를 기준으로 맵을 정렬하고,
            // Map을 각 트리마다 갖고 있는 형태.

            // 그러니까 쉽게 말해서 그냥 트리를 Map의 Key기준으로 정렬하고,
            // 트리 각 노드에는 맵을 들고 있음.
            TreeMap<Integer, Integer> treemap = new TreeMap<>();
            for (int n = 0; n < N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                cmd = st.nextToken();
                num = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    if (!treemap.keySet().contains(num)) {
                        treemap.put(num, 1);
                    }else {
                        treemap.put(num, treemap.get(num) + 1);
                    }

                } else {
                    if (!treemap.isEmpty()) {
                        if (num == -1) {
                            // 값이 2이상이면 줄여준다.
                            // 값이 1이하라면 삭제한다.
                            int min = treemap.firstKey();
                            int val = treemap.get(min);
                            if(val>=2){
                                val--;
                                treemap.put(min, val);
                            }else{
                                val--;
                                treemap.remove(min);
                            }
                        } else {
                            int max = treemap.lastKey();
                            int val = treemap.get(max);
                            if(val>=2){
                                val--;
                                treemap.put(max, val);
                            }else{
                                val--;
                                treemap.remove(max);
                            }

                        }
                    } else continue;
                }

            }


            if(treemap.isEmpty()) sb.append("EMPTY").append("\n");
            else{
                sb.append(treemap.lastKey()).append(" ").append(treemap.firstKey()).append("\n");
            }

        }

        System.out.println(sb);
    }
}

//1
//4
//I 3
//I 3
//D 1
//D 1