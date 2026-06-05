import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        // 공격한 시간초, 피해량 
        int attNums = attacks.length;
        
        int lastAttSec = -1;
        // HashMap에 몬스터가 공격한 시간을 키값,
        // 데미지를 값으로 넣는다.
        Map<Integer, Integer> attTimes = new HashMap<>();
        
        for(int i=0; i<attNums; i++)
        {
            attTimes.put(attacks[i][0], attacks[i][1]);
            lastAttSec = Math.max(lastAttSec, attacks[i][0]);
        }
        
        // 각 초별로 캐릭터의 체력을 확인한다. 
        // 기본적으로 최대 체력 이상이면 최대 체력,
        // 0 밑으로 떨어지면 -1 처리하고 마무리.
        
        int totBonTime = bandage[0];
        int healAmount = bandage[1];
        int totBonHeal = bandage[2];
        
        int consHealTime = 0;
        int charHealth = health;
        for(int t=1; t<=lastAttSec; t++)
        {
            // 공격 타이밍을 포함하고 있으면, 
            // 캐릭터의 HP를 깎는다.
            if(attTimes.containsKey(t))
            {
                int damage = attTimes.get(t);
                
                charHealth -= damage;
                consHealTime = 0;
                
                if(charHealth <= 0) break;
                
                System.out.printf("-: %s %s\n", t, charHealth);
                // 쳐 맞으면 회복을 안하니까,
                // continue를 해준다.
                continue;
            }
            
            // 공격을 쳐맞지 않았으면, 
            // HP를 채워주고
            
            // consHealTime을 늘려주고
            // 연속 힐 시간을 다 채웠으면 보너스까지 주고 연속 힐을 0으로 초기화한다.
            charHealth += healAmount;
            
            consHealTime++;
            if(consHealTime == totBonTime)
            {
                consHealTime = 0;
                charHealth += totBonHeal;
            }
            
            if(charHealth >= health) charHealth = health;
            
            System.out.printf("+: %s %s\n", t, charHealth);
        }
        
        //System.out.println(health);
        
        if(charHealth <= 0) return -1;
        
        return charHealth;
        
        // t초 동안 붕대를 감으면서,
        // 1초마다 x만큼의 체력을 회복한다. 
        
        // t초 연속으로 붕대를 감는 데 성공하면, 
        // y만큼 체력을 추가로 회복한다. 
        
        // 기술을 쓰는 도중 몬스터에게 공격 당하면, 
        // 기술이 취소
        
        // 기술이 취소/기술 끝나면,
        // 연속 성공 시간 = 0
        
        // 몬스터 공격을 받으면,
        // 정해진 피해량만큼 체력이 줄어든다.
        // 0 이하가 되면 캐릭타 사망,
        // 체력 회복 불가.
        
        // 공격 패턴, 캐릭터 최대 체력이 주어질 때, 
        // 캐릭터가 끝까지 살아남을 수 있나?
        
        // bandage
        // 기술 시간, 1초 회복량, 추가 회복량
        
        // health
        // 최대 체력
        
        // 몬스터의 공격한 시간 초, 피해량
        
    }
}