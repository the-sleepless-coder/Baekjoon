import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int width, int num) {
        // 총 택배 상자 개수 n
        // 가로로 놓는 상자 개수 w
        // 꺼내려는 상자 num
        
        // 풀려는 문제를 한번에 제대로 분석하고,
        // 그 뒤에 오류 없이 구현하는 편이 훨씬 더 구현 속도가 빠르다.
        
        // 요구사항 정확하게 파악
        // 오류 없이 구현
        // 시간 복잡도 최적화.
        
        // 처음에 한번 제대로 코드를 설계하고 한번에 제대로 구현하는 것이,
        // 훨씬 더 정확하게 빠르게 코드를 구현하는 데 도움이 된다.
        int W = width;
        int H = n/width+1;
        
        int[][] graph = new int[H][W];
        
        int count=1;
        outer:for(int h=0; h<H; h++){
            for(int w=0; w<W; w++){
                if(count==n+1) break outer;
                
                if(h%2==0){
                    graph[h][w]=count;
                    
                }else{
                    graph[h][W-1-w]= count;
                }
                count++;    
            }
        }
        
        // System.out.println(Arrays.deepToString(graph));
        
        
        // 택배와 동일한 열에 있는 숫자가 0이라면,
        // lastFilled false처리.
        int numH = -1;
        int numW = -1;
        boolean lastFilled = true;
        for(int h=0; h<H; h++){
            for(int w=0; w<W; w++){
                // 분기를 따로 구성 안해주면,
                // if-else처리하면서 걸려버리니 따로 구성해줘야 해.
                if(graph[h][w]==num){
                    numH = h+1;
                    numW = w+1;
                    System.out.printf("%d %d", numH, numW);
                }
                
               
            }
        }
         // Out of Bounds Error안 뜨게 해줘야 한다.  
        if(graph[H-1][numW-1]==0) lastFilled = false;
        
        
        int answer = lastFilled ? H-numH+1: H-numH; 
        //System.out.println(lastFilled);
        //System.out.printf("%d %d", H, numH);
        // int answer = 0;
        
        return answer;
    
    }
}