package review;

import java.util.*;

public class Review_18352 {
    static int visited[];
    static ArrayList<Integer> a[];
    static List<Integer> answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 도시 개수
        int m = sc.nextInt(); // 도로 개수
        int k = sc.nextInt(); // 거리 정보
        int x = sc.nextInt(); // 출발 도시 정보
        a = new ArrayList[n+1];
        visited = new int[n+1];
        answer = new ArrayList<>();

        for (int i = 1 ; i <= n ; i++){
            a[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= n ; i++){
            visited[i] = -1;
        }

        for(int i = 0; i < m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            a[s].add(e);
        }
        BFS(x);

        for(int i = 1 ; i <= n ; i++){
            if(visited[i] == k){
                answer.add(i);
            }
        }

        if(answer.isEmpty()){
            System.out.println("-1");
        }
        else{
            Collections.sort(answer);
            for(int i : answer){
                System.out.println(i);
            }
        }

    }
    public static void BFS(int index){
        Queue<Integer> q = new LinkedList<>();
        visited[index]++;
        q.add(index);
        while(!q.isEmpty()){
            int now_node = q.poll();
            for(int i : a[now_node]){
                if(visited[i] == -1){
                    visited[i] = visited[now_node]+1;
                    q.add(i);
                }
            }
        }
    }
}
