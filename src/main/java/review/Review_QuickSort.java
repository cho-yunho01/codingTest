package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Review_QuickSort {
    static int [] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        merget_sort(a , 0, n-1);

        System.out.println(Arrays.toString(a));
    }

    public static void merget_sort(int a[], int s, int e){
        int part2 = partition(a,s,e);

        if(s < part2 -1){
            merget_sort(a,s,part2-1);
        }
        if(part2 < e){
            merget_sort(a,part2,e);
        }
    }

    public static int partition(int a[], int s, int e){
        int m = (s+e) / 2;
        int pivot = a[m];
        while(s<=e){
            while(pivot > a[s]){
                s++;
            }
            while(pivot < a[e]){
                e--;
            }
            if(s <= e){
                swap(a,s,e);
                s++;
                e--;
            }
        }
        return s;
    }

    public static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
