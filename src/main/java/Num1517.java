import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1517 {
    static int[] a;
    static int[] tmp;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        a = new int[n+1];
        tmp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;

        merget_sort(1,n);
        System.out.println(result);
    }

    public static void merget_sort(int s, int e){
        if(e-s < 1){
            return;
        }

        int m = s + (e-s)/2;
        merget_sort(s,m);
        merget_sort(m+1,e);
        for(int i = s; i <= e; i++){
            tmp[i] = a[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m+1;
        while(index1 <= m && index2 <= e){
            if(tmp[index1] > tmp[index2]){
                a[k] = tmp[index2];
                result = result + index2 - k;
                k++;
                index2++;
            }
            else{
                a[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while(index1 <= m){
            a[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= e){
            a[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
