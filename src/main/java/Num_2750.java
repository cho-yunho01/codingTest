import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n-1 ; i > 0; i--){
            for(int t = 0; t < i; t++){
                if(a[t] > a[t+1]){
                    int temp = a[t];
                    a[t] = a[t+1];
                    a[t+1] = temp;
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            System.out.println(a[i]);
        }
    }
}
