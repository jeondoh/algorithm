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
        // System.out.println(solution(table2, languages2, preference2));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        List<HashMap<String, Object>> tableDataList = new ArrayList<HashMap<String, Object>>();
        setHashMapData(tableDataList, table); // hashMap에 


        return "";
    }

    public static void setHashMapData(List<HashMap<String, Object>> tableDataList, String[] table){
        int score = 5; // 언어 선호도 점수
        int tableSize = table.length;
  
        for(int i=0; i<tableSize; i++){
            HashMap<String, Object> dataMap = new HashMap<String, Object>();
            String[] data = table[i].split("\\s");
            int dataSize = data.length;
            
            for(int j=0; j<dataSize; j++){
                // 직업군
                if(j==0){
                    Object[] jobArr = new Object[2];
                    jobArr[0] = data[j];
                    jobArr[1] = 0;
                    dataMap.put("job", jobArr);
                }else{
                    dataMap.put(data[j], score-j);
                } // end if (j==0)
            } // end for j
            tableDataList.add(dataMap);
        }// end for i
    }

}// end class
