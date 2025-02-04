import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        String[] stringInput = input.split("");

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < stringInput.length){
            if(stringInput[idx].equals("S")){
                sb.append("*");
                sb.append(stringInput[idx]);
                idx+=1;
            }else{
                sb.append("*");
                sb.append("LL");
                idx+=2;
            }

            if(idx == stringInput.length ){
                sb.append("*");
            }
        }

        String result = sb.toString();
        String[] stringResult = result.split("");
        int cupCount=0;
        for(String str: stringResult){
            if(str.equals("*")){
                cupCount+=1;
            }
        }

        if(cupCount>=num){
            cupCount = num;
        }
        System.out.println(cupCount);


    }
}
