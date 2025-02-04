import java.util.*;

public class Main {
    public static void main(String[] args) {
           //7 8 10 13 15 19 20 23 25
           //140
           Scanner sc = new Scanner(System.in);
           int[] dwarves = new int[9];

           int sum =0;
           for(int i=0; i<9; i++){
               dwarves[i] = sc.nextInt();
               sc.nextLine();
               sum+=dwarves[i];
           }

           int remain = sum - 100;
           int idx1 = -1;
           int idx2 = -1;

           for(int i=0; i<dwarves.length; i++){
               for(int j=i+1; j<dwarves.length; j++){
                   if (dwarves[i]+dwarves[j] == remain){
                       idx1 = i;
                       idx2 = j;
                   }
               }
           }

           List<Integer> sevenDwarves = new ArrayList<>();
           for (int i=0; i<dwarves.length; i++){
               if ((i == idx1)||(i == idx2)) {
                   continue;
               }
               sevenDwarves.add(dwarves[i]);
           }

           for(int i=0; i<sevenDwarves.size()- 1; i++){
               for(int j=0; j<sevenDwarves.size() -1 - i; j++){
                   if (sevenDwarves.get(j)>sevenDwarves.get(j+1)){
                       int temp = sevenDwarves.get(j);
                       sevenDwarves.set(j, sevenDwarves.get(j+1));
                       sevenDwarves.set(j+1, temp);
                   }
               }
           }

            for(int num:sevenDwarves){
                System.out.println(num);
            }




    }
}

//while (checkSum!=remain){
//checkSum += dwarves[count];
//        if(count==2){
//
//        }
//}
// System.out.println(sevenDwarves);
