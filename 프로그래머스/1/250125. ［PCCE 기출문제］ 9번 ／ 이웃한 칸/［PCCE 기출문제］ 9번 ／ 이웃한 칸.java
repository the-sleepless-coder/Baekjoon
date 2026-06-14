class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String col = board[h][w];
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};    
        
        int R = board.length;
        int C = board[0].length;
        
        for(int i=0; i<4; i++)
        {
            int nr = h+dr[i];
            int nc = w+dc[i];
            
            if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
            
            String nextCol = board[nr][nc];
            if(col.equals(nextCol)) answer++;
            
        }
        
        return answer;
    }
}