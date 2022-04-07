import java.util.Scanner;

// 실버3 백트래킹/완전탐색

public class BOJ_15649 {
    public static int n, m;
    public static int[] selected;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        selected = new int[m + 1];

        rec_func(1);
        System.out.println(sb.toString());
    }

    public static void rec_func(int k){
        if(k == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                selected[k] = i;
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }

}
