/*
총평

1. participant와 completion 을 Arrays.sort 를 이용하여 정렬
2. 같은 인덱스끼리 값을 비교하면서 participant과 completion의 값이 일치할 경우 완주자로, 값이 일치하지 않을 경우 완주 못한것으로 판별
3. completion의 길이는 participant의 길이보다 1 작다의 의미 -> 항상 완주하지 못한 선수는 1명이다. 
4. temp(완주하지 못한자를 담는 변수)가 null이었을 경우는 맨 마지막 participant의 선수가 완주하지 못했다는 뜻
5. 
*/

import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        String temp = "";

        //participant와 completion을 같은 방식으로 정렬
        //같은 인덱스 = 같은 값이 오도록
        Arrays.sort(participant);
        Arrays.sort(completion);

        //completion(participant보다 1작은)의 크기만큼 루프를 돌려 값이 일치하는지 확인
        for(int i =0; i<completion.length; i++){
            if(!completion[i].equals(participant[i])){
                //일치하지 않을 경우에는 미 완주자로 간주하여 temp변수에 저장
                temp = participant[i];
                break;
            }
        }
        //temp 변수에 값이 없다는 것 -> participant의 마지막 선수가 미완주자라는 뜻 
        if(!temp.equals("")){
            answer = temp;
        }else{
            answer = participant[participant.length-1];
        }
        return answer;
    }
}
