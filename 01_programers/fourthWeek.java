import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 2021-08-29(일)
// 코딩테스트 연습 > 위클리 챌린지 > 4주차

public class fourthWeek {

    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"PYTHON", "C++", "SQL"};
        int[] preference = {7, 5, 5};

        String[] table2 = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages2 = {"JAVA", "JAVASCRIPT"};
        int[] preference2 = {7, 5};

        System.out.println(solution(table, languages, preference));
        System.out.println(solution(table2, languages2, preference2));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        List<HashMap<String, Object>> tableDataList = new ArrayList<HashMap<String, Object>>();
        setListHashMapData(tableDataList, table); // 데이터 정제
        return getResult(tableDataList, languages, preference);
    }

    public static void setListHashMapData(List<HashMap<String, Object>> tableDataList, String[] table){
        int score = 6; // 언어 선호도 점수
        int tableSize = table.length;

        for (String s : table) {
            HashMap<String, Object> dataMap = new HashMap<String, Object>();
            String[] data = s.split("\\s");
            int dataSize = data.length;

            for (int j = 0; j < dataSize; j++) {
                // 직업군
                if (j == 0) {
                    dataMap.put("job", data[j]);
                } else {
                    dataMap.put(data[j], score - j);
                } // end if (j==0)
            } // end for j
            tableDataList.add(dataMap);
        }// end for i
    }

    public static String getResult(List<HashMap<String, Object>> tableDataList, String[] languages, int[] preference){
        String result = "";
        int maxScore = 0; // 가장 큰 선호도 점수

        for(HashMap<String, Object> dataMap : tableDataList){
            String job = dataMap.get("job").toString();
            int jobScore = 0;

            // 직업별 선호도 점수 계산
            int langSize = languages.length;
            for(int i=0; i<langSize; i++){
                int score = ((int) dataMap.getOrDefault(languages[i], 0)) * preference[i]; // 직업군 언어 점수 * 언어 선호도
                jobScore += score;
            }
            if(maxScore == jobScore){
                // 같은 값 비교(총합이 같은 직업군이 여러 개일 경우, 이름이 사전 순으로 가장 빠른 직업군 RETURN)
                // 아스키 코드를 이용해 비교
                int maxJobAsciiCode = result.charAt(0);
                int jobAsciiCode = job.charAt(0);
                // 아스키 코드값(job)이 같으면 compareTo로 문자 정렬
                if(jobAsciiCode == maxJobAsciiCode){
                    result = (result.compareTo(job) > 0) ? job : result;
                }else if(maxJobAsciiCode > jobAsciiCode) {
                    result = job;
                }

            }else if(jobScore > maxScore){
                result = job;
                maxScore = jobScore;
            }
            System.out.println("Job :: " + job + " Score :: " + jobScore);
        }
        return result;
    }

}// end class
