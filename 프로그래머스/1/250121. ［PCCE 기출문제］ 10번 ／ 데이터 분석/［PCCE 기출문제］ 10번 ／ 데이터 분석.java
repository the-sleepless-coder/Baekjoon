import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        // ext 값이 val_ext보다 작은 데이터만 뽑은 후.
        // sort_by에 해당하는 값을 기준으로 오름차순 정렬해서 return 한다.
        int len = data.length;
        
        PriorityQueue<Data> pq = new PriorityQueue<>(
            (a, b) -> {
                if(sort_by.equals("remain"))
                {
                    return Integer.compare(a.remain, b.remain);    
                }else if(sort_by.equals("code"))
                {
                    return Integer.compare(a.code, b.code);
                }else if(sort_by.equals("maximum"))
                {
                    return Integer.compare(a.maximum,b.maximum);
                }else if(sort_by.equals("date"))
                {
                    return Integer.compare(a.date, b.date);
                }
                
                return 0;
            }
        );
        
        for(int i=0; i<len; i++)
        {
            int[] temp = data[i];
            Data tdata = new Data(temp[0], temp[1], temp[2], temp[3]);
            
            int idx = -1;
            if(ext.equals("code"))
            {
                idx=0;
            }else if(ext.equals("date"))
            {
                idx=1;
            }else if(ext.equals("maximum"))
            {
                idx=2;
            }else if(ext.equals("remain"))
            {
                idx = 3;
            }
            
            int std = temp[idx];
            if(std < val_ext)
            {
                pq.add(tdata);
            }
        }
        
        // 답을 담기 위한 임시 변수.
        ArrayList<int[]> result = new ArrayList<>();
        int arrIdx = 0;
        while(!pq.isEmpty())
        {
            Data tdata = pq.poll();    
            int[] temp = new int[4];
            temp[0] = tdata.code;
            temp[1] = tdata.date;
            temp[2] = tdata.maximum;
            temp[3] = tdata.remain;
            
            result.add(temp);
        }
        
        // 실제 반환.
        int size= result.size();
        
        int[][] answer = new int[size][4];
        for(int i=0; i<size; i++)
        {
            answer[i] = result.get(i);
        }
        
        return answer;
    
    }
    
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