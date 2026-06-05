class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 명령어
        int size = commands.length;
        
        // pos -> 초로 변환
        // 영상 시작 위치: pos
        int posSecs = secChanger(pos);
        
        int endSecs = secChanger(video_len);
        
        int opStartSecs = secChanger(op_start);
        int opEndSecs = secChanger(op_end);
        
        // pos위치가 오프닝인지 확인
        if(posSecs >= opStartSecs && posSecs <= opEndSecs)
        {
            posSecs = opEndSecs;
        }
        
        // command를 실행하고 최종 pos위치를 출력한다.
        for(int i=0; i<size; i++)
        {
            String cmd = commands[i];
            
            // prev
            // 영상 10초전으로 이동 
            if(cmd.equals("next"))
            {
                posSecs+=10;
            }
            // next
            // 영상 10초 후로 이동 
            else if(cmd.equals("prev"))
            {
                posSecs-=10;
            }
            
            // 넘어가면 영상 마지막으로 설정.
            if(posSecs > endSecs)
            {
                posSecs = endSecs;
            }
            // 0보다 작으면 영상의 시작으로 설정.
            else if(posSecs<0)
            {
                posSecs = 0;
            }
            
            // 보정 후 구간 자체가 오프닝이 될 수 있기 때문에, 
            // if를 따로 빼야된다.
            
            // 오프닝 구간에 걸치면
            // 오프닝 끝나는 위치로 이동
            if(posSecs >= opStartSecs && posSecs <= opEndSecs)
            {
                posSecs = opEndSecs;
            }   
        }
       
    
       return convToString(posSecs);

    }
    
    // "mm:ss" 형태의 String으로 바꾼다.
    static String convToString(int posSecs)
    {
        int resMin = posSecs/60;
        int resSec = posSecs-60*resMin;
        
        String strMin = "";
        String strSec = "";
        if(resMin < 10)
        {
           strMin = "0"+resMin;
        }
        else{
            strMin = String.valueOf(resMin);
        }
        
        if(resSec<10)
        {
            strSec="0"+resSec;
        }
        else{
            strSec = String.valueOf(resSec);
        }
        
        String res = strMin+":"+strSec;
        
        return res;
    }
    
    static int secChanger(String stringMinSec)
    {
        String[] str = stringMinSec.split(":");
        
        int min = Integer.parseInt(str[0]);
        int sec = Integer.parseInt(str[1]);
        
        return min*60+sec;
    }
}