
// 2021-07-18(일)
// 코딩테스트 연습 > 2021 KAKAO BLIND RECRUITMENT > 신규 아이디 추천
public class kakao_NewIdSuggest {

    public static void main(String[] args) {
        String[] newIdArr = {"...!@BaT#*..y.abcdefghijklm", "z-+.^.", "=.=", "123_.def", "abcdefghijklmn.p"};
        for(String newId : newIdArr){
            System.out.println(solution(newId));
        }
    }

    public static String solution(String new_id) {
        return newIdSov7(new_id);
    }

    // 모든 대문자를 대응되는 소문자로 치환
    public static String newIdSov1(String new_id){
        return new_id.toLowerCase();
    }

    // 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제외
    public static String newIdSov2(String new_id){
        String result = newIdSov1(new_id);
        String regex = "[^\\w\\-_.]*"; // 정규식 \\w가 a-z0-9와 같음 (알파벳, 숫자)
//        String regex = "[^a-z0-9\\-_.]*";
        return result.replaceAll(regex, "");
    }

    // 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
    public static String newIdSov3(String new_id){
        String result = newIdSov2(new_id);
        String regex = "\\.{2,}"; // {n,} = 최소한 n개
        return result.replaceAll(regex, ".");
    }

    // 마침표(.)가 처음이나 끝에 위치한다면 제거
    public static String newIdSov4(String new_id){
        String result = newIdSov3(new_id);
        if(result.startsWith(".")){
            result = result.substring(1);
        }
        if(result.endsWith(".")){
            result = result.substring(0, result.length() -1);
        }
        return result;
    }

    // 빈 문자열이라면, new_id에 "a"를 대입
    public static String newIdSov5(String new_id){
        String result = newIdSov4(new_id);
        if(result.length() == 0){
            return "a";
        }
        return result;
    }

    // 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
    // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
    public static String newIdSov6(String new_id){
        String result = newIdSov5(new_id);
        if(result.length()>=16){
            result = result.substring(0, 15);
        }
        return newIdSov4(result);
    }

    // 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙임
    public static String newIdSov7(String new_id){
        StringBuilder result = new StringBuilder(newIdSov6(new_id));
        String lastStr = result.substring(result.length()-1);
        while(result.length()<3){
            result.append(lastStr);
        }
        return result.toString();
    }

}// end class
