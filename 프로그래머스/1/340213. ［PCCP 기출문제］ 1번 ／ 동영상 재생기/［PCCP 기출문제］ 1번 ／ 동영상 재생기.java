class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // commands(<=100)
        int CMD = commands.length;
        String[] posSplit = pos.split(":");
        int currMin = Integer.parseInt(posSplit[0]);
        int currSec = Integer.parseInt(posSplit[1]);
        
        String[] opArr = op_start.split(":");
        int opMin = Integer.parseInt(opArr[0]);
        int opSec = Integer.parseInt(opArr[1]);
        
        String[] endArr = op_end.split(":");
        int closeMin = Integer.parseInt(endArr[0]);
        int closeSec = Integer.parseInt(endArr[1]);
        
        String[] videoLenArr = video_len.split(":");
        int endMin = Integer.parseInt(videoLenArr[0]);
        int endSec = Integer.parseInt(videoLenArr[1]);
        
        
        /**
        int closeMinBord = -1;
        int closeSecBord = -1;
        if(closeSec<10){
             if(closeMin>=1){
                    closeSecBord = 60-(10-closeSec);
                    closeMinBord -= 1;
                }else{
                    closeMin=0;
                    closeSec=0;
                }

        }else{
            closeSec-=10;
        }
        */
        
        boolean withinOpeningStart = false;
        if(opMin!=closeMin){
            if(currMin>=opMin && currMin<=closeMin){
                // currMin이 opMin과 같을 때, opSec까지 비교.
                if(currMin==opMin && currSec>=opSec){
                    withinOpeningStart = true;
                }
                // currMin이 closeMin과 같을 때, closeSec까지 비교.
                else if(currMin==closeMin && currSec<=closeSec){
                    withinOpeningStart = true;
                }else if(currMin>opMin && currMin<closeMin ){
                        withinOpeningStart = true;
                }
                
            }
        }else{
            if(opMin==currMin){
                if(currSec>=opSec && currSec<=closeSec){
                    withinOpeningStart = true;
                }    
            }
        }

        if(withinOpeningStart){
            currSec = closeSec;
            currMin = closeMin;
        }
        // System.out.printf("%d %d\n",currMin, currSec);
        
        for(int c=0; c<CMD; c++){
            String cmd = commands[c];
            
            if(cmd.equals("prev")){
                if(currSec<10){
                    if(currMin>=1){
                        currSec = 60-(10-currSec);
                        currMin -= 1;
                    }else{
                        currMin=0;
                        currSec=0;
                    }
                    
                }else{
                    currSec-=10;
                }
            }else if(cmd.equals("next")){
                
                if(currSec>50){
                    currSec = 10 - (60-currSec);
                    currMin+=1;
                }else{
                    currSec+=10;
                    //System.out.printf("%d %d\n",currMin, currSec);
                }
                
                // 끝을 넘어갈 경우, 
                // 영상의 끝을 가리키게 함.
                if(currMin>endMin){
                    currSec = endSec;
                    currMin = endMin;
                }else if(currMin==endMin){
                    if(currSec>=endSec){
                        currSec = endSec;
                        currMin = endMin;
                    }
                }
                
                //System.out.printf("%d %d\n",currMin, currSec);
                
            }
            
            
            // 시간 이동 후, 오프닝에 포함되는지 확인한다.
            // 모든 경우를 빠짐 없이 다 포함해야 된다.
            // I need to comprehensively include all cases,
            // otherwise I would fail to solve the problem
            // 1:50 -> 6:10
            // 1:55, 2:30, 5:55
            // 1:45  / 6:30
            boolean withinOpening = false;
            if(opMin!=closeMin){
                if(currMin>=opMin && currMin<=closeMin){
                    // currMin이 opMin과 같을 때, opSec까지 비교.
                    if(currMin==opMin && currSec>=opSec){
                        withinOpening = true;
                    }
                    // currMin이 closeMin과 같을 때, closeSec까지 비교.
                    else if(currMin==closeMin && currSec<=closeSec){
                        withinOpening = true;
                    }else if(currMin>opMin && currMin<closeMin ){
                        withinOpening = true;
                    }
                }
            }else{
                if(currMin==opMin){
                    if(currSec>=opSec && currSec<=closeSec){
                        withinOpening = true;
                    }
                }
            }
            
            if(withinOpening){
                currSec = closeSec;
                currMin = closeMin;
            }
            
            
           
        }
        
        // System.out.printf("%d %d\n",currMin, currSec);
        // video_len
        // 수행 직전 재생 위치
        // op_start, op_end
        
        // 동영상의 위치를 "mm:ss"로 반환한다.
        String answer = String.format("%02d:%02d", currMin, currSec);
        // String answer = currMin + ":"+ currSec;
        return answer;
    
    }
}