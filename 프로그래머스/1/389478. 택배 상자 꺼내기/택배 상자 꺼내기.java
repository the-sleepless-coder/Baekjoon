import java.util.*;

class Solution {
    public int solution(int n, int width, int num) {
        // 왼쪽 -> 오른쪽 
        // 오른쪽 -> 왼쪽
        
        // 꺼내려는 상자 번호가 주어질 때, 
        // 꺼내려는 상자를 포함해 몇개의 상자를 꺼내야하는지 확인한다. 
        
        int rows = 0;
        if(n%width != 0)
        {
            rows = n/width + 1;
        }
        else
        {
            rows = n/width;
        }
        
        int left = 0;
        if(n%width!=0)
        {
            left = rows*width - n;
        }
        
        
        // 찾는 택새 방자 위치 풀이가 너무 더럽다.
        int numR = num/width;
        int numC = num - numR * width;
        if(numC==0) {
            numR -= 1;
            numC = width - 1;
        }
        
        int findC = 0;
        // 찾는 택배 상자 위치 행이 홀수면, 오른쪽에서 부터 위치를 세어준다.
        if(numR%2!=0)
        {
            findC = width - 1 - numC;  
        }
        // 찾는 택배 상자 위치 행이 짝수면, 왼쪽에서부터 위치를 세어준다.
        else
        {
            findC = numC - 1;
        }
        
        Set<Integer> cols = new HashSet<>();
        // 행의 개수가 짝수면, 택배가 비는 왼쪽열부터 Set에 넣어준다.
        if(rows % 2 == 0)
        {
            for(int c=0; c<left; c++)
            {    
                cols.add(c);
            }
            
        }
        // 행의 개수가 홀수면, 택배가 비는 오른쪽 열부터 Set에 넣어준다.
        else
        {
            for(int c=0; c < left; c++)
            {
                cols.add(width - 1 - c);
            }   
        }
        
        // 택배 상자가 비는 위치 열에 있으면 하나를 더 빼주고, 
        // 그렇지 않으면 row - numR그대로 답을 확정한다.
        int result = rows - numR;
        
        if(cols.contains(findC))
        {
            result-=1;
        }
        
        System.out.printf("%d %d\n", rows, numR);
        System.out.println(cols);
        System.out.println(findC);
        
     // 24 23  22  21  20 19   
     // 13  14 15  16 17 18    
     // 12, 11, 10, 9, 8, 7
        // 1, 2, 3, 4, 5, 6
        
        return result;
    }
    
    static StringBuilder builder(int[][] boxes)
    {
        int R = boxes.length;
        int C = boxes[0].length;
        
        StringBuilder sb = new StringBuilder();
        for(int r= 0; r<R; r++)
        {
            for(int c=0; c<C; c++)
            {
                sb.append(boxes[r][c]).append(" ");
            }
            sb.append("\n");
        }
        
        return sb;
    }
    
    
}