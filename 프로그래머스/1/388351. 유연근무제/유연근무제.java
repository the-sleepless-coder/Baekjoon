import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startDay) {
        // (startDay + j) % 7 == 6,0
        int Days = 7;
        int Workers = schedules.length;
        
        // 복잡한 문제라면 차라리 전체를 다 풀고 돌리지 말고,
        // 일부를 풀고 하나씩 확인하는 편이 나을 것 같다.
        // i번째 직원의, j번째 출근 시간
        int[] limitTime = new int[Workers];
        for(int w=0; w<Workers;w++){
            int time = schedules[w];
            int timeLimit = time+10;
            
            
            if(timeLimit%100>=60){
                timeLimit =  (time/100 + 1) * 100 + (10 - (60- time%100));
            }
            
            limitTime[w] = timeLimit;
            System.out.println(timeLimit);
        }
        
        // 0-idx기준.
        // 반복되는 변수는 정리해서 쓰는 것이 낫다.
        // 각 직원별 일주일간 정상 출석 판정
        // 5일간 일했다면 모두 출석한 직원으로 판정.
        int[][] workAllDays = new int[Workers][Days];
        for(int w=0; w<Workers; w++){
            int timeLimitW = limitTime[w];
            
            for(int d=0; d<Days; d++){
                int adjustedIndex = (startDay-1 + d)%7;
                
                //토,일은 제외
                if((adjustedIndex)%7==5 || (adjustedIndex)%7==6 )  continue;                 
                // 지각 포함 이전이면, 주어진 요일에 정상 출석 판정.
                // System.out.printf("%d %d | ", timeLimitW, timelogs[w][d]);
                if(timeLimitW>=timelogs[w][d]){
                    workAllDays[w][adjustedIndex]+=1;
                }
            }
            System.out.println("\n");
        }
        
        int totalCount=0; 
        for(int w=0; w<Workers; w++){
            
            //각 직원별 workdayCount세기.
            int workDaysCount = 0;
            for(int d=0; d<Days; d++){
                if(workAllDays[w][d]==1){
                    workDaysCount++;
                }
            }
            
            if(workDaysCount==5) totalCount++;
        }
        
        // System.out.println(Arrays.deepToString(workAllDays));
        // 복잡한 것은 아닌데, 확실히 문제 조건 확실하게 확인하고 꼼꼼하게 풀어야 안 틀린다.
        
        return totalCount;
    }
}