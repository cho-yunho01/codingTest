import java.util.Scanner;

public class Num_14425 {
    public static void main(String[] args) {
        int count = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        tNode root = new tNode();

        for(int i = 0 ; i < n; i++){
            tNode node = root;

            String str = sc.next();
            for(int t = 0 ; t < str.length(); t++){
                char c = str.charAt(t);
                int index = c - 'a';

                if(node.next[index] == null){
                    node.next[index] = new tNode();
                }
                node = node.next[index];

                if(t == str.length()-1){
                    node.isEnd = true;
                }

            }
        }

        for(int i = 0; i < m; i++){
            tNode node = root;

            String str = sc.next();
            for(int t = 0; t < str.length(); t++){
                char c = str.charAt(t);
                int index = c - 'a';

                if(node.next[index] == null){
                    break;
                }
                node = node.next[index];

                if(t == str.length()-1 && node.isEnd){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

class tNode{
    tNode[] next = new tNode[26];
    boolean isEnd;
}
