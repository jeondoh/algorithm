import java.text.ParseException;
import java.text.SimpleDateFormat;

// 2021-08-22(일)
// 코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT > [1차] 추석 트래픽

public class ThanksgivingTraffic_kakao {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public static void main(String[] args) throws ParseException {
        String[] lines1 = {
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"
        };
        String[] lines2 = {
                "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"
        };
        String[] lines3 = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };
        System.out.println(solution(lines1));
        System.out.println(solution(lines2));
        System.out.println(solution(lines3));
    }

    public static int solution(String[] lines) throws ParseException {
        int size = lines.length;
        long[] startTimeArr = new long[size];
        long[] endTimeArr = new long[size];

        // 배열내 시간 계산 > 시작시간 & 종료시간 나눠서 저장 (최대 2000번 돌림 ㅠㅠ)
        for(int i = 0; i<size; i++){
            String[] spData = lines[i].split(" ");
            String date = spData[0] + " " + spData[1];
            String seconds = spData[2].replace("s", "");
            float resultSeconds = Float.parseFloat(seconds) - 0.001f;

            long endTime = sdf.parse(date).getTime();
            long startTime = endTime - (long)(resultSeconds * 1000);

            startTimeArr[i] = startTime;
            endTimeArr[i] = endTime;
        }

        // 구간 최대 처리량
        int max = 0;

        for(int i=0; i<size; i++){
            int cnt = 0; // 최대 처리량
            long startTimeRange = startTimeArr[i]; // 매초 시작시간 (로그 시작시간 기준)
            long endTimeRange = startTimeRange + 999L; // 매초 종료시간
            long startTimeRange2 = endTimeArr[i]; // 매초 시작시간 (로그 종료시간 기준)
            long endTimeRange2 = startTimeRange2 + 999L; // 매초 종료시간

            for(int j=i; j<size; j++){
                long logStartTime = startTimeArr[j]; // 로그 시작시간
                long logEndTime = endTimeArr[j]; // 로그 종료시간
                // 겹처진 트래픽 구하기
                // 초당 최대 처리량의 '1초'
                // 1. 종료 시작시간을 기준으로 해서 + 1초로 범위를 잡음 ( 로그 종료시간 ~ 1초 )
                // 2. 예제3의 5번째 로그막대바 처럼 1초 사이에 포함되어 있는 경우
                if(
                        (startTimeRange <= logEndTime && endTimeRange >= logEndTime) ||
                        (startTimeRange2 <= logEndTime && endTimeRange2 >= logEndTime) ||
                        betweenTime(startTimeRange, endTimeRange, logStartTime, logEndTime) ||
                        betweenTime(startTimeRange2, endTimeRange2, logStartTime, logEndTime)
                )
                {
                    cnt ++;
                }
            }
            max = Math.max(cnt, max);
        }
        return max;
    }

    public static boolean betweenTime(long compStartTime, long compEndTime, long startTime, long endTime){
        boolean bStartTime;
        boolean bEndTime;

        // 시작시간 비교
        if(startTime >= compStartTime){
            bStartTime = compEndTime > startTime;
        }else{
            bStartTime = endTime > compStartTime;
        }
        // 종료시간 비교
        if(endTime >= compEndTime){
            bEndTime = startTime <= compEndTime && endTime > compEndTime;
        }else{
            bEndTime = compStartTime <= endTime;
        }
        return bStartTime || bEndTime;
    }

}// end class
