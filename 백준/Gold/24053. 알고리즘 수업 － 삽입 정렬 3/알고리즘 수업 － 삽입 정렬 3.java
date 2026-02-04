import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] orgArr = new int[N];
        for(int idx=0; idx<N; idx++){
            orgArr[idx] = sc.nextInt();
        }
        int[] chgArr= new int[N];
        for(int idx=0; idx<N; idx++){
            chgArr[idx] = sc.nextInt();
        }

        boolean result;

        result=insertionSort(orgArr, chgArr);
        if(result){
            System.out.println(1);
        }else{
            System.out.println(0);    
        }

    }
    // 정렬된 배열과 한번이라도 동일한 배열이 나오면,
    // 1을 출력
    // 아니라면 0을 출력한다.

    // 삽입 정렬 구현.
    static boolean insertionSort(int[] orgArr, int[] chgArr){
        int N = orgArr.length;

        StringBuilder chgSb = new StringBuilder();
        boolean resultIdt = false;

        for(int idx=0; idx<N; idx++){
            chgSb.append(chgArr[idx]).append(" ");
        }
        StringBuilder initOrgSb = new StringBuilder();
        for(int idx=0; idx<N; idx++){
            initOrgSb.append(orgArr[idx]).append(" ");
        }

        if(chgSb.toString().equals(initOrgSb.toString())){
            resultIdt=true;
        }

        if(!resultIdt){
            for(int i=1; i<N; i++){
                // 각 인덱스에서 자신보다 앞에 있는 숫자를 순서에 맞게 하나씩 정렬한다.
                // 카드를 하나씩 추가하면서 정렬하는 방식 정도라고 볼 수 있다.
                int key = orgArr[i];
                int j = i-1;

                // 순서 교체가 일어날 때마다,
                // chgArr이랑 동일한지 확인한다.
                // 한번이라도 동일하면 resultIdt = true가 된다.

                // 순서에 맞는 key를 정렬하기 위해서 맞는 위치를 찾는다.
                while(j>=0 && orgArr[j]>key){
                    orgArr[j+1]=orgArr[j];
                    j=j-1;

                    StringBuilder orgSb = new StringBuilder();
                    boolean arrIdt = false;

                    for(int idx=0; idx<N; idx++){
                        orgSb.append(orgArr[idx]).append(" ");
                    }

                    if(orgSb.toString().equals(chgSb.toString())){
                        arrIdt=true;
                        resultIdt=resultIdt||arrIdt;
                    }

                }

                // key에 맞는 위치를 찾았으면,
                // key를 맞는 위치에 넣어준다.
                if(j+1 != i){
                    orgArr[j+1]=key;

                    StringBuilder orgSb = new StringBuilder();
                    boolean arrIdt = false;

                    for(int idx=0; idx<N; idx++){
                        orgSb.append(orgArr[idx]).append(" ");
                    }

                    if(orgSb.toString().equals(chgSb.toString())){
                        arrIdt=true;
                        resultIdt=resultIdt||arrIdt;
                    }

                }

            }
        }


        return resultIdt;


    }

}
// 삽입 정렬
// 배열에 있는 숫자를 하나씩 추가하면서 정렬하는 방식
// 계속 정렬되지 않은 숫자를 하나씩 정렬하는 방식으로,
// 전체 배열을 정렬한다.