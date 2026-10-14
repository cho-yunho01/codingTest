import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num_2751 {
    static int[] a,tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        a = new int[n+1];
        tmp = new int[n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
        }
        merget_sort(1,n);
        for(int i = 1 ; i <= n; i++){
            System.out.println(a[i]);
        }
    }

    private static void merget_sort(int s, int e){
        if(e-s < 1)
            return;

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
            if(tmp[index1] < tmp[index2]){
                a[k] = tmp[index1];
                index1++;
                k++;
            }
            else{
                a[k] = tmp[index2];
                index2++;
                k++;
            }
        }
        while(index1 <= m){
            a[k] = tmp[index1];
            index1++;
            k++;
        }
        while(index2 <= e){
            a[k] = tmp[index2];
            index2++;
            k++;
        }
    }
}
