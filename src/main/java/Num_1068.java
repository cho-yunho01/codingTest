import java.util.ArrayList;
import java.util.Scanner;

public class Num_1068 {

    static ArrayList<Integer>[] tree;
    static boolean[] visitied;
    static int answer = 0;
    static int deleteNode = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        tree = new ArrayList[n];
        for(int i = 0 ; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        visitied = new boolean[n];

        int root = 0;

        for(int i = 0 ; i < n ; i++) {
            int p = sc.nextInt();
            if(p != -1) {
                tree[i].add(p);
                tree[p].add(i);
            }
            else
                root = i;
        }

        deleteNode = sc.nextInt();

        if(deleteNode == root) {
            System.out.println(0);
        }
        else {
            DFS(root);
            System.out.println(answer);
        }

    }

    public static void DFS(int i) {
        visitied[i] = true;
        int cNode = 0;

        for(int node : tree[i]) {
            if(visitied[node] == false && deleteNode != node) {
                cNode++;
                DFS(node);
            }
        }

        if(cNode == 0) {
            answer++;
        }

    }



}
