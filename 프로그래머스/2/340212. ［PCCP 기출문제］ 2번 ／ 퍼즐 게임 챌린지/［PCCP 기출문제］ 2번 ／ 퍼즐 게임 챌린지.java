import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        // n개의 퍼즐 게임 
        // 퍼즐 난이도, 시간 : diff, time_cur, time_prev
        // 나의 숙련도: level
        
        // level>= diff (time_cur)
        // level < diff (diff-level) * (time_cur + prev) + time_cur
        
        // 제한 시간 내 모두 해결하기 위한 숙련도의 최대값.
        // Parametric Search
        // level이 너무 높으면 줄이고, level이 너무 낮으면 높이다.
        
        // N개의 테스트 케이스에 대한 logN = N*logN
        int len = diffs.length;
        
        Puzzle[] puzArr = new Puzzle[len];
        int maxLevel = Integer.MIN_VALUE;
        
        for(int i=0; i<len; i++)
        {
            int diff = diffs[i];
            int time = times[i];
            
            Puzzle puz = new Puzzle(diff, time);
            puzArr[i] = puz;
            maxLevel = Math.max(maxLevel, diff);
            
        }
        
        
        int minLevel = 1;
        // min~max Level 사이에서 limit보다 작은 totTime을 가지게 하는,
        // 가장 작은 level 값을 구하여라.
        
        // mid를 기준으로 해당 조건을 만족하는 가장 작은 level을 결정.
        
        // 사실상 mid가 변수를 이용하여, 
        // 이분탐색을 진행한다고 보면 됨.
        while(minLevel <= maxLevel)
        {
            // mid를 이용해 totTime을 계산한다.
            int mid = (minLevel+maxLevel)/2;
            
            long totTime = 0;
            for(int i=0; i<len; i++)
            {
                Puzzle puz = puzArr[i];
                int difficulty = puz.diff;
                int time = puz.time;

                // 어차피 첫번째는 항상 difficulty=1이기 때문에, 
                // 재시도 조건에 안 걸린다.
                if(mid >= difficulty) totTime+=time;
                else
                {
                    int prev_time = puzArr[i-1].time;
                    totTime += (difficulty-mid)*(prev_time + time) + time;
                }
            }
            
            // totTime이 너무 작으면,
            // mid(=level) 을 낮춰준다.
            if(totTime <= limit)
            {
                maxLevel = mid-1;
            }
            // totTime이 너무 오래 걸리면, 
            // mid(=level)를 올려서 totTime을 줄여준다.
            else
            {
                minLevel = mid+1;
            }
        }
        
        // 제한 시간 내 풀 수 있는 숙련도 중 최소값을 반환한다.
        return minLevel;
    }
    
    // 퍼즐의 난이도와 풀이 시간.
    static class Puzzle
        {
            int diff;
            int time;
            
            public Puzzle(int diff, int time)
            {
                this.diff = diff;
                this.time = time;
            }
        }
}    
    