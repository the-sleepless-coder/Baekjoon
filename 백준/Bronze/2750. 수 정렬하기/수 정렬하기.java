import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        int[] intArray = new int[n];    
        
        for(int i=0; i<n; i++){
            intArray[i] = sc.nextInt();
        }
        
        for(int i=0; i<n-1; i++){
            int min = i;
            
            for(int j=i+1; j<n; j++){
                if(intArray[min]>intArray[j]){
                    min=j;    
                }
            }
            
            int temp = intArray[i];
            intArray[i] = intArray[min];
            intArray[min] = temp;
        }
        
        
        for(int Int: intArray){
            System.out.println(Int);
        }
        
        
        
    }    
}
