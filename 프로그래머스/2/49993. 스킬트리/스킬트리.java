import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int count=0;
        int S = skill_trees.length;
        for(int s=0; s<S; s++){
            // 배워야되는 스킬을 매번 스택에 넣는다.
            Queue<Character> q = new LinkedList<>();
            char[] charArr = skill.toCharArray();
            for(char c:charArr){
                q.add(c);
            }
            
            String skillSet = skill_trees[s];
            char[] skillChar = skillSet.toCharArray();
            // 각 스킬셋에 대한 isProper판단을 해준다.
            boolean isProper = true;
            for(int sk=0; sk<skillChar.length; sk++){
                // 각 스킬셋에 대해 Stack에 들어 있으면서, 
                // Queue의 가장 위가 아니라면 false를 반환한다. 
                if(q.contains(skillChar[sk]) && q.peek()!=skillChar[sk]){
                   isProper = false;        
                }
                else if(q.contains(skillChar[sk]) && q.peek()==skillChar[sk]){
                   q.poll();      
                }   
            }
            
            if(isProper) count++;
            
            
        }
        
        
        return count;
    }
}