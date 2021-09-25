
// 2021-09-25(일)
// 코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT > [1차] 다트 게임

public class Dart {

    public static void main(String[] args) {
        String dartResult = "1D2S#10S";
        System.out.println(solution(dartResult));
    }

    public static int solution(String dartResult) {
        char[] darts = dartResult.toCharArray(); // 1글자씩 분리
        int[] score = new int[3]; // dartResult의 각 숫자의 점수 담을 배열
        int cnt = -1;
        int result = 0;

        for(int i = 0; i < darts.length; i++) {
            if(darts[i] >= '0' && darts[i] <= '9') {
                cnt++;
                if(darts[i] == '1' && darts[i+1] == '0') {
                    score[cnt] = 10;
                    i++;
                } else {
                    score[cnt] = darts[i] - '0';
                }
            } else if(darts[i] == 'D') { // 2제곱
                score[cnt] *= score[cnt];
            } else if(darts[i] == 'T') { // 3제곱
                score[cnt] *= score[cnt] * score[cnt];
            } else if(darts[i] == '*') { // 스타상 - 바로 이전 점수 2배 AND 현재 점수 2배
                if(cnt > 0) {
                    score[cnt-1] *= 2;
                }
                score[cnt] *= 2;
            } else if(darts[i] == '#') { // 아차상 - 해당 점수 마이너스
                score[cnt] *= -1;
            }
        }
        // 배열의 합계
        for(int s : score){
            result += s;
        }
        return result;
    }

}// end class
