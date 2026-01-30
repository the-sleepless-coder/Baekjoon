import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int maxRoom = 300;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        String[][] players = new String[N][2];

        for(int idx=0; idx<N; idx++){
            st = new StringTokenizer(br.readLine());

            String[] player = new String[2];
            player[0] = st.nextToken();
            player[1] = st.nextToken();
            players[idx] = player;
        }

        // 사람이 들어온 순서대로 방이 생성될 것이라서,
        // rooms를 Array로 관리.
        ArrayList<ArrayList<Map<String, Integer>>> rooms = new ArrayList<>();
        for(int idx=0; idx<N; idx++){
            int level = Integer.parseInt(players[idx][0]);
            String id = players[idx][1];
            // 방이 없다면 생성한다.
            if(rooms.size() == 0){
                ArrayList<Map<String, Integer>> room = new ArrayList<>();
                Map<String, Integer> map = new HashMap<>();
                map.put(id, level);
                room.add(map);

                rooms.add(room);
            }
            // 방이 있다면 방이 생성된 순서대로,
            // refLev기준 +,- 10내로 해당 방에 들어간다.
            else{
                int len = rooms.size();
                // 방에 입장할 플레이어.
                HashMap<String, Integer> player = new HashMap<>();
                player.put(id, level);
                boolean sat = false;
                for(int i=0; i<len; i++){
                    ArrayList<Map<String, Integer>> givRoom = rooms.get(i);
                    Map<String, Integer> ref = givRoom.get(0);

                    Set<String> refIdSet = ref.keySet();
                    Iterator<String> it = refIdSet.iterator();
                    String refId = it.next();
                    int refLev = ref.get(refId);

                    // 기존 방에서 refLev 기준으로 플레이어의 레벨이 포함된다면, 가장 먼저 생성된 방에 플레이어를 넣는다.
                    if((level <= refLev+10 && level >= refLev-10) && givRoom.size()<R){
                        sat = true;
                        givRoom.add(player);
                        break;
                    }
                }
                // 기존 방을 다 확인했는데 조건을 만족하지 않으면 새로운 방에 넣는다.
                if(!sat){
                    ArrayList<Map<String, Integer>> newRoom = new ArrayList<>();
                    newRoom.add(player);
                    rooms.add(newRoom);
                }
            }


        }

        int len =rooms.size();
        // System.out.println(len);
        StringBuilder sb = new StringBuilder();

        for(int idx=0; idx<len; idx++){
            // 방 찾기.
            ArrayList<Map<String,Integer>> room = rooms.get(idx);
            int roomSize = room.size();
            if(roomSize==R){
                sb.append("Started!\n");
            }else{
                sb.append("Waiting!\n");
            }

            // 방 내 아이디 알파벳 오름차순으로 정렬.
            ArrayList<String> idList = new ArrayList<>();
            for(int i=0; i<roomSize; i++){
                Map<String, Integer> map = room.get(i);
                Set<String> keySet = map.keySet();

                Iterator<String> key = keySet.iterator();
                String id = key.next();
                idList.add(id);
            }
            Collections.sort(idList);

            // 정렬된 순서대로 level, id 출력하기.
            for(int i=0; i<roomSize; i++){
                String id = idList.get(i);
                int level = -1;
                for(int r=0; r<roomSize; r++) {
                    Map<String, Integer> playerInfo = room.get(r);
                    Set<String> keySet = playerInfo.keySet();

                    Iterator<String> key = keySet.iterator();
                    String matchingId = key.next();
                    if(id.equals(matchingId)){
                        level = playerInfo.get(matchingId);
                        break;
                    }
                }
                sb.append(level).append(" ").append(id).append("\n");
            }

        }

        System.out.println(sb);

    }
}

// 방은 최대 300개

// 매칭 가능한 방이 없으면 새로운 방 입장시킨다.
// x +- 10

// 입장 가능한 방이 있다면 정원이 찰 때까지 대기 시킨다.
// 입장 가능한 방이 있다면 먼저 생성된 방에 입장 시킨다.

// 방의 정원 모두 차면 시작한다.
// 플레이어 수, 정원
// 레벨 닉네임
// 입력된 순서대로 시작한다.

// 방 상태
// 레벨 아이디
// 닉네임이 사전순으로 배열.

//10 5
//10 f
//15 b
//25 a
//30 z
//40 d
//51 o
//42 c
//55 h
//60 y
//50 i