import java.util.*;

class Solution {
    static String CODE, DATE, MAXIMUM, REMAIN;
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        CODE = "code";
        DATE = "date";
        MAXIMUM = "maximum";
        REMAIN = "remain";
        
        // 코드번호, 제조일, 최대수량, 현재 수량
        // ext, val_ext 기준 조건, 기준 값.
        // sort_by 조건 정렬 조건.
        PriorityQueue<Data> pq = new PriorityQueue<>
        (
            // Comparator 조건을 내가 직접 작성.
            (d1, d2) ->
            {
                
                if(sort_by.equals(DATE))
                {
                    return d1.date - d2.date;    
                }
                else if(sort_by.equals(CODE))
                {
                    return d1.code - d2.code;
                }
                else if(sort_by.equals(MAXIMUM))
                {
                    return d1.maximum - d2.maximum;
                }else if(sort_by.equals(REMAIN))
                {
                    return d1.remain - d2.remain;
                }
                
                return 0;
            }
        );
            
        // data에 있는 데이터 중,
        // val_ext보다 작은 것을 pq에 더해준다.
        int len = data.length;
        
        for(int i=0; i<len ; i++)
        {
            int code = data[i][0];
            int date = data[i][1];
            int maximum = data[i][2];
            int remain = data[i][3];
            
            if(ext.equals(CODE))
            {
                if(val_ext<code) continue;
            }
            else if(ext.equals(DATE))
            {
                if(val_ext<date) continue;
            }
            else if(ext.equals(MAXIMUM))
            {
                if(val_ext<maximum) continue;
            }
            else if(ext.equals(REMAIN))
            {
                if(val_ext<remain) continue;
            }
                
            Data d = new Data(code, date, maximum, remain);
            pq.add(d);
        }
        
        int size = pq.size();
        int[][] result = new int[size][4];
        int resultIdx = 0;
        while(!pq.isEmpty())
        {
            Data d= pq.poll();
            int code = d.code;
            int date = d.date;
            int maximum = d.maximum;
            int remain = d.remain;
            
            result[resultIdx] = new int[]{code, date, maximum, remain};
            resultIdx++;
        }
        
        return result;
    }

    // Data를 담기 위한 객체를 생성.    
    static class Data
    {
        int code;
        int date;
        int maximum;
        int remain;

        public Data(int code, int date, int maximum, int remain)
        {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }

    }
}    