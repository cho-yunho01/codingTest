import java.util.Scanner;

public class Num_1991 {
    static int tree[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tree = new int[26][2];
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i < n ; i++){
            String str = sc.nextLine();
            String[] temp = str.split(" ");
            int node = temp[0].charAt(0) - 'A';
            int left = temp[1].charAt(0);
            int right = temp[2].charAt(0);
            if(left == '.')
                left = -1;
            if(right == '.')
                right = -1;

            tree[node][0] = left;
            tree[node][1] = right;
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    public static void preOrder(int index){
        System.out.print((char)(index + 'A'));
        if(tree[index][0] != -1){
            preOrder(tree[index][0] - 'A');
        }
        // 돌아와서 오른쪽 자식
        if(tree[index][1] != -1){
            preOrder(tree[index][1] - 'A');
        }

    }

    public static void inOrder(int index){
        if(tree[index][0] != -1){
            inOrder(tree[index][0] - 'A');
        }
        System.out.print((char)(index + 'A'));

        if(tree[index][1] != -1){
            inOrder(tree[index][1] - 'A');
        }
    }

    public static void postOrder(int index){
        if(tree[index][0] != -1){
            postOrder(tree[index][0] - 'A');
        }
        if(tree[index][1] != -1){
            postOrder(tree[index][1] - 'A');
        }
        System.out.print((char)(index + 'A'));
    }
}
