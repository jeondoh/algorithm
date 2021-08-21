import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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
//        System.out.println(solution(lines1));
        System.out.println(solution(lines2));
//        System.out.println(solution(lines3));
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
        // 배열 내 제일 작은 시간
        long minTime = Arrays.stream(startTimeArr).min().getAsLong();
        // 배열 내 제일 큰 시간
        long maxTime = Arrays.stream(endTimeArr).max().getAsLong();
        // 제일 큰시간 - 제일 작은시간 > 시차(초)를 구함
        int diffTime = (int)Math.ceil((maxTime - minTime) / 1000.000f) + 1;
        // 매 초를 비교하기 위해 시작시간
        long compStartTime = minTime;
        // 매 초를 비교하기 위해 종료시간(1초(1000밀리초)를 더한 값 저장 변수)
        long compEndTime = minTime + 999L;
        // 구간 최대 처리량
        int max = 0;

        // 매초 시간 비교
        for(int i=0; i<=diffTime; i++){
            // 처리량
            int cnt = 0;

            for(int j=0; j<size; j++){
                if (betweenTime(compStartTime, compEndTime, startTimeArr[j], endTimeArr[j])) {
                    System.out.println("포함");
                    cnt++;
                }
            }
            System.out.println("END FOR DIFFTIME");
            // 비교를 위해 1초(1000밀리초)씩 증가
            compStartTime += 1000L;
            compEndTime += 999L;
            // 구간 최대 처리량 비교
            max = Math.max(max, cnt);
        }
        return max;
    }

    public static boolean betweenTime(long compStartTime, long compEndTime, long startTime, long endTime){
        boolean bStartTime;
        boolean bEndTime;

        System.out.println("=============================================================");
        System.out.println("비교 시작시간 :: " + sdf.format(compStartTime));
        System.out.println("비교 종료시간 :: " + sdf.format(compEndTime));
        System.out.println("시작시간 :: " + sdf.format(startTime));
        System.out.println("종료시간 :: " + sdf.format(endTime));
        System.out.println("=============================================================");

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
