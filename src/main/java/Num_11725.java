import java.util.ArrayList;
import java.util.Scanner;

public class Num_11725 {
    static ArrayList<Integer>[] a;
    static boolean visited[];
    static int[] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new ArrayList[n+1];
        answer = new int[n+1];
        for(int i = 1 ; i <= n; i++){
            a[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];

        for(int i = 0 ; i < n-1 ; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            a[s].add(e);
            a[e].add(s);
        }
        for(int i = 1; i <= n ; i++){
            if(!visited[i]){
                DFS(i);
            }
        }

        for(int i = 2 ; i <= n ; i++){
            System.out.println(answer[i]);
        }
    }

    public static void DFS(int index){
        visited[index] = true;
        for(int i : a[index]){
            if(!visited[i]){
                answer[i] = index;
                DFS(i);
            }
        }
    }
}
