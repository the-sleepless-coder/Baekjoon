import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        sc.nextLine();

        for(int test=1; test<=testCase; test++){
            int N = sc.nextInt();
            int T = sc.nextInt();

            // 0이 되면 초기화하고 arraylist에 넣어보자.
            int[][] arr = new int[N][N];
            for(int r=0; r<N; r++){
                for(int c=0; c<N;c++){
                    arr[r][c] = sc.nextInt();
                }
            }

            // 행 별 확인.
            ArrayList<ArrayList<Integer>> resultR = new ArrayList<>();
            for(int r=0; r<N; r++){
                int count = 0;
                ArrayList<Integer> row = new ArrayList<>();
                for(int c=0; c <= N-1;c++){
                    int currVal = arr[r][c];
                    int nextVal = -1;
                    if(c <= N-2){
                        nextVal = arr[r][c+1];
                    }

                    if(currVal == 1 && nextVal==0){
                        count++;
                        row.add(count);
                        count = 0;
                    }else if(currVal == 1){
                        count++;
                    }

                    if( c==N-1 && currVal == 1){
                        row.add(count);
                    }

                }
                resultR.add(row);
            }

            // 열 별 확인.
            ArrayList<ArrayList<Integer>> resultC = new ArrayList<>();
            for(int c=0; c<N; c++){
                int count = 0;
                ArrayList<Integer> col = new ArrayList<>();
                for(int r=0; r <= N-1;r++){
                    int currVal = arr[r][c];
                    int nextVal = -1;
                    if(r <= N-2){
                        nextVal = arr[r+1][c];
                    }

                    if(currVal == 1 && nextVal==0){
                        count++;
                        col.add(count);
                        count = 0;
                    }else if(currVal == 1){
                        count++;
                    }

                    if( r==N-1 && currVal == 1){
                        col.add(count);
                    }

                }
                resultC.add(col);
            }

            // System.out.println(resultR);
            // System.out.println(resultC);

            int resultCount = 0;
            int RR = resultR.size();
            for(int r=0; r<RR; r++){
                int CR =resultR.get(r).size();
                for(int c=0; c<CR; c++){
                    int totVal = resultR.get(r).get(c);
                    if(T==totVal)
                        resultCount++;
                }
            }

            int RC = resultC.size();
            for(int r=0; r<RC; r++){
                int CC= resultC.get(r).size();
                for(int c=0; c<CC; c++){
                    int totVal = resultC.get(r).get(c);
                    if(T==totVal)
                        resultCount++;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test).append(" ").append(resultCount);
            System.out.println(sb);

        }

    }
}

//1
//5 3
//1 0 0 1 0
//1 1 0 1 1
//1 0 1 1 1
//0 1 1 0 1
//0 1 1 1 0