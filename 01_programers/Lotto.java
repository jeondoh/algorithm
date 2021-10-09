
// 2021-10-10(일)
// 코딩테스트 연습 > 2021 Dev-Matching: 웹 백엔드 개발자(상반기) > 로또의 최고 순위와 최저 순위

import java.util.Arrays;
import java.util.HashSet;

public class Lotto {

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        HashSet<Integer> lottoSet = new HashSet<Integer>(); // 민우가 구매한 로또번호 목록
        int lottoArrSize = lottos.length;
        // 알아볼수 없는 번호(0) 은 제외하고 Set
        for (int lotto : lottos) {
            if (lotto == 0) continue;
            lottoSet.add(lotto);
        }

        int setSize = lottoSet.size();
        // 전부 알아볼수 없는 번호일 경우 ex) 0, 0, 0, 0, 0, 0
        if(setSize == 0){
            answer[0] = 1;
            answer[1] = 6;
            return answer;
        }
        // 맞는 번호 개수
        int correct = 0;
        for(int win : win_nums){
            if(lottoSet.contains(win)){
                correct++;
            }
        }

        answer[0] = Rank(correct + (6 - setSize));
        answer[1] = Rank(correct);
        return answer;
    }

    public static int Rank(int correctNum){
        // 등수 리턴
        switch (correctNum){
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2:
                return 5;
        }
        return 6;
    }

}// end class
