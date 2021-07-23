import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 2021-06-10(목)
// 코딩테스트 연습 > 2021 KAKAO BLIND RECRUITMENT > 순위검색
public class kakao_SearchRank {

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(Arrays.toString(solution(info, query)));
    }

    private static int[] solution(String[] info, String[] query) {
        int[] answer = new int[info.length];
        int index = 0;
        List<HashMap<String, Object>> infoList = getList(info);
        List<HashMap<String, Object>> queryList = getList(query);

        for(HashMap<String, Object> queryMap : queryList){
            String[] keyArr = {"language", "job", "career", "food", "score"};
            int size = keyArr.length;
            int result = 0; // 점수

            for(HashMap<String, Object> infoMap : infoList){
                int roop = 0;
                int correct = 0;
                while(roop++ != size){
                    if(isCorrect(queryMap.get(keyArr[roop-1]).toString(), infoMap.get(keyArr[roop-1]).toString()) ){
                        correct++;
                    }else{
                        break;
                    }
                }
                // 조건에 모두 충족하였으면
                if(correct == size){
                    result++;
                }
            }
            answer[index++] = result;
        }
        return answer;
    }

    // 리스트 맵에 데이터를 담아줌
    private static List<HashMap<String, Object>> getList(String[] arr){
        List<HashMap<String, Object>> infoList = new ArrayList<HashMap<String, Object>>();
        // 언어 직군 경력 소울푸드 점수
        String[] words = {"language", "job", "career", "food", "score"};

        for(String data : arr){
            HashMap<String, Object> putMap = new HashMap<String, Object>();
            data = data.replaceAll(" and", "");
            String[] spData = data.split(" ");
            int size = spData.length;
            for(int i = 0; i<size; i++){
                putMap.put(words[i], spData[i]);
            }
            infoList.add(putMap);
        }
        return infoList;
    }

    // 데이터 판별
    private static boolean isCorrect(String query, String info){
        if(query.equals("-"))
            return true;
        // 숫자 문자 구분
        if(query.matches("^[0-9]*$")){
            // 숫자
            return Integer.parseInt(info) >= Integer.parseInt(query);
        }else{
            // 문자
            return query.equals(info);
        }
    }


}
