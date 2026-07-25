import java.util.*;

class Solution {
    static int totHours = 24;
    
    public int solution(int[] players, int unit, int lasting) {
        // m명 늘어날 때마다 서버가 1대 추가로 필요.
        // n*m ~ n*(m+1) -> 최소 n대의 증설된 서버가 운영 중이어야 함.
        // 한번 증설한 서버는 k시간 운영하고 반납됨.

        // 서버를 최소 몇번 증설해야 하나?
        // player 수에 대해서 server수를 관리하는 변수랑 비교해서
        // 더 필요하다면 증설한다.

        int totHotServers = 0;
        int addedServers = 0;

        // 서버가 줄어드는 시각과 대수를 HashMap에 담아준다.
        Map<Integer, Integer> serverDecr = new HashMap<>();
        int[] serverNum = new int[totHours];

        for(int hour = 0; hour < totHours; hour++)
        {
            int player = players[hour];
            int batch = player/unit;

            if(serverDecr.containsKey(hour))
            {
                totHotServers -= serverDecr.get(hour);
                totHotServers = Math.max(totHotServers,0);
            }

            // 현재 떠 있는 서버 수 보다 띄워야 하는 서버 수가 더 많다면,
            // 띄워야 하는 서버 - 현재 떠 있는 서버 수 만큼 더해준다.
            if(batch-totHotServers  > 0)
            {
                int increment = batch-totHotServers;
                addedServers += increment;
                
                totHotServers = batch;
                
                // lasting 시간 뒤 꺼져야하는 서버의 개수를 map에 기록한다.
                if(hour+lasting < totHours)
                {
                    serverDecr.put(hour+lasting, increment);
                }
            }

            serverNum[hour] = totHotServers;
        }
        
        return addedServers;
    }
    
    static class GameServer
    {
        
    }
    
}