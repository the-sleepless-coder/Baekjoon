class Solution {
    public int solution(int[] mats, String[][] park) {
        
        int R = park.length;
        int C = park[0].length;
        
        int MATS = mats.length;
        int biggestMat = -1;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                // 매트 놓을 수 있는 자리에서 확인.
                if(park[r][c].equals("-1")){
            
                    // 모든 매트에 대해서 확인.
                    for(int mts=0; mts<MATS; mts++){
                        int M = mats[mts];
                        boolean placeMat = true;
                        // 각 자리에서 매트 크기 확인.
                        for(int rm=0; rm<M; rm++){
                            for(int cm=0; cm<M; cm++){
                                // 매트가 공원을 벗어나면 false.
                                if(r+rm>=R||c+cm>=C){
                                    placeMat = false;
                                    break;
                                }
                                
                                // 이미 돗자리가 깔려 있으면 false.
                                if(!park[r+rm][c+cm].equals("-1")){
                                    placeMat=false;
                                    break;
                                }
                            }
                        }
                        
                        if(placeMat){
                            biggestMat = Math.max(biggestMat, M);
                        }
                        
                        
                    }
                    
                }
                
            }
        }
        
        
        
        return biggestMat;
        
        
        
    }
}