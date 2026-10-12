import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(a,0,n-1,k);
        System.out.println(a[k-1]);

    }
    public static void quickSort(int[] a, int s, int e, int k) {
        if(s < e){
            int pivot = partition(a,s,e);
            if(pivot == k){
                return;
            }
            else if(pivot < k){
                quickSort(a,pivot+1,e,k);
            }
            else{
                quickSort(a,s,pivot-1,k);
            }
        }
    }
    public static int partition(int[] a, int s, int e) {
        int m = (s+e) / 2;
        swap(a,s,m);
        int pivot = a[s];
        int i = s+1;
        int j = e;
        while(i < j){
            while(a[j] > pivot){
                j--;
            }
            while(i < j && a[i] < pivot){
                i++;
            }

            swap(a,i,j);
        }
        a[s] = a[i];
        a[i] = pivot;
        return i;
    }
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
