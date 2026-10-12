package review;

import java.util.ArrayList;
import java.util.Scanner;

public class Review_1325 {
    static ArrayList<Integer>[] a;
    static boolean[] visited;
    static int[] answer;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        a = new ArrayList[n+1];
        answer = new int[n+1];
        for(int i = 1; i <= n; i++){
            a[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n ;i++){
            answer[i] = -1;
        }

        for(int i = 0 ; i < m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            a[e].add(s);
        }
        for(int i = 1; i <= n; i++){
            visited = new boolean[n+1];
            count = -1;
            DFS(i);
            answer[i] = count;
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(max,answer[i]);
        }

        for(int i = 1; i <= n ; i++){
            if(answer[i] == max)
                System.out.print(i + " ");
        }
    }

    public static void DFS(int index){
        count++;

        for(int i : a[index]){
            if(!visited[i]){
                visited[i] = true;
                DFS(i);
            }
        }
    }
}
