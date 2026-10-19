package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    static int [] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];

        for(int i = 0 ; i < n ; i++){
            a[i] = sc.nextInt();
        }

        quickSort(a,0,n-1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a, int s, int e){
        int part2 = partition(a,s,e);
        if(s < part2-1)
            quickSort(a,s,part2-1);
        if(part2 < e)
            quickSort(a,part2,e);

    }

    public static int partition(int[] a, int s, int e){
        int m = (s+e) / 2;
        int pivot = a[m];
        while(s <= e){
            while(a[s] < pivot){
                s++;
            }
            while(a[e] > pivot){
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

    public static void swap(int[] a,int s, int e){
        int temp = a[s];
        a[s] = a[e];
        a[e] = temp;
    }
}
/*
참고 https://innovation123.tistory.com/84
 */