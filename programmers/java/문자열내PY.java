/*
총평
1. 요새 평이한 난이도의 문제만 고르는거 같음...
2. 소문자와 대문자를 같다고 판별한다는 조건 -> LowerCase 혹은 UpperCase로 
*/

class Solution {
    boolean solution(String s) {
        int size = s.length(), pCount = 0, yCount = 0;
        //문자열의 길이만큼 loop
        for(int i=0; i<size; i++){
            //P일때 Y일때 혹은 그 외의 문자일때
            //1. 문자열 s의 chartAt(i)를 통해 한글자식 판별 
            //2. 모두 대문자로 치환(toUpperCase())
            switch(String.valueOf(s.charAt(i)).toUpperCase()){
                case "P": pCount++; break;
                case "Y": yCount++; break;
                default: break;
            }
        }
        //true 일 때
        //1. 둘다 O일때(P와Y갯수가 0일때)
        //2. P와 Y갯수가 같을 때
        //이 경우외에는 전부 false
        if(pCount==0 && yCount==0) return true;
        return (pCount==yCount)?true:false;
    }
}
