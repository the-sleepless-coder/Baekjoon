import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int idx=0; idx<count; idx++){
            sb.append("I");
            sb.append("O");
        }
        sb.append("I");

        // 불변객체인 String보다 차라리 char로 검색하는 편이 더 빠르다.
        // 매번 객체를 새롭게 만들 필요가 없으니까 말이야.
        char[] checkArr = String.valueOf(sb).toCharArray();
        int len = Integer.parseInt(br.readLine());
        char[] charArr = br.readLine().toCharArray();

        int countChecks = 0;
        for(int idx=0; idx<=len-2; idx++){
            boolean checkChars = true;
            char curr = charArr[idx];
            char next = charArr[idx+1];

            // 다음 문자가 같으면 검사할 필요가 없다.
            if(curr==next){
                continue;
            }

            // 해당 글자가 O라면 검사할 필요가 없다.
            if(curr=='O') continue;

            // 시작점이후부터 끝지점까지 O, I가 count번 나오면 된다.
            // 홀 짝수 번째 인덱스 일 때를 기준을로,
            // 적절한 위치에 값이 있는지 확인한다.
            if(idx <= len-1 - 2*count){
                if(curr=='I'){

                    for(int i=idx+1; i<= idx + 2 * count; i++){
                        if((idx+1)%2==0){
                            if(i%2==1){
                                if(charArr[i]=='O'){
                                    checkChars=false;
                                }
                            }else{
                                if(charArr[i]=='I'){
                                    checkChars=false;
                                }
                            }
                        }else{
                            if(i%2==1){
                                if(charArr[i]=='I'){
                                    checkChars=false;
                                }
                            }else{
                                if(charArr[i]=='O'){
                                    checkChars=false;
                                }
                            }
                        }

                    }

                    // checkChars가 맞다면,
                    // I가 있을 수 있는 곳에서 다시 시작한다.
                    if(checkChars) idx++;

                }

            }else{
                checkChars = false;
            }

            if(checkChars){
                countChecks++;
                //System.out.println(idx);
            }

        }

        System.out.println(countChecks);


    }
}

// 알고리즘을 특출나게 잘할 필요는 없지만 못해서는 안된다.
// 결국 코드를 읽고 이해하고 판단하기 위한 논리적인 기본이 없다면,
// 그리고 자료구조를 통해서 시간 복잡도와 코드의 성능을 판단하는 기본적인 능력이 안된다면,
// 그게 프로그램을 짜는 사람이라고 볼 수 있을까?

// 그러니까 특출나게 잘할 필요는 없지만, 못하지 않는 수준으로는 끌어 올려야 한다.