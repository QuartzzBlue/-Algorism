package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        process(Integer.parseInt(br.readLine()));
    }

    private static void process(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int x = i, y = j;
                while(x > 0) {
                    if(x % 3 == 1 && y % 3 == 1) {
                        break;
                    }

                    x /= 3;
                    y /= 3;
                }
                sb.append(x == 0 ? '*' : ' ');
//                1,4,7 즉 나머지가 1인 것들만 자기숫자가 나오고 아닌 것들은 0이 된다.
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}