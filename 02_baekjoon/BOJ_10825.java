import java.util.Arrays;
import java.util.Scanner;

// 실버4 정렬

public class BOJ_10825 {
    public static int n; // 학생 수
    public static Elem[] a; // 정렬할 배열
    public static StringBuilder sb = new StringBuilder();

    public static class Elem implements Comparable<Elem> {
        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem other) {
            // 국어 점수가 감소하는 순서로
            if (korean != other.korean) return other.korean - korean;
            // 국어 점수가 같으면 영어 점수가 증가하는 순서로
            if (english != other.english) return english - other.english;
            // 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
            if (math != other.math) return other.math - math;
            // 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
            return name.compareTo(other.name);
        }
    }
    // 입력값
    public static void input(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = new Elem[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Elem();
            a[i].name = sc.next();
            a[i].korean = sc.nextInt();
            a[i].english = sc.nextInt();
            a[i].math = sc.nextInt();
        }
    }

    public static void printResult(){
        // 기준을 통해 정렬
        Arrays.sort(a);
        // 정답 출력
        for (Elem elem : a) {
            sb.append(elem.name).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        printResult();
    }


}
