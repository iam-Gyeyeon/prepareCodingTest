/*
총평
- 처음 세 학생의 찍기 루틴을 직접 입력해주는 형태로 했는데 이것의 규칙을 찾아서 하는 방법은 없을까?
- 중간에 check 배열에 맞은 개수 누적시키는건 좀 쉬웠음
- 가장 많이 맞춘 사람을 찾기 위해 Math.max 사용 (처음에 버블sort로 찾으려다가 소스가 길어져서 함수 사용)
- Collections.sort를 이용해서 동점자의 경우 오름차순 정렬

- 아직 함수들을 금방 떠오르는게 익숙지 않아서 처음 설계한 소스가 겉잡을수 없이 길었음
- 편의에 따라 .add 같은걸 사용할땐 ArrayList를 사용하는것과 같이 유동적으로 사용해야겠다고 생각
*/

import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int firstStudent[] = {1,2,3,4,5};
        int secondStudent[] = {2,1,2,3,2,4,2,5};
        int thirdStudent[] = {3,3,1,1,2,2,4,4,5,5};       //이부분을 직접 입력 말고 규칙을 찾아서 값을 무한으로 생성해준다면?
        
        int check[] = new int[3];
        
      
        //정답(answers[])과 각 학생들의 답이 일치할 경우 check[]의 값을 증가시켜준다.
        for(int i =0; i<answers.length;i++){
            if(answers[i]==firstStudent[i%firstStudent.length]){check[0]++;}
            if(answers[i]==secondStudent[i%secondStudent.length]){check[1]++;}
            if(answers[i]==thirdStudent[i%thirdStudent.length]){check[2]++;}
        }

        //sort를 사용하기 위해 ArrayList에 담아주었다
        ArrayList<Integer> temp = new ArrayList<>();
        
        //check 배열에서 최대값을 찾는 과정
        int max = Math.max(Math.max(check[0], check[1]),check[2]);  
         
        //최대값과 같으면 temp에 값 add
        if(max == check[0]){temp.add(1);}
        if(max == check[1]){temp.add(2);}
        if(max == check[2]){temp.add(3);}
        
        //같은 값이 있을 경우 오름차순 정렬을 위해 Collections.sort 사용
        Collections.sort(temp);
        
        //배열 크기를 지정해주지 않고 돌렸다가 값이 안들어가서 오래걸렸다.
        //꼭 잊지말기
        answer = new int[temp.size()];
        
        for(int i=0; i<answer.length;i++)
            answer[i]=temp.get(i);
        
        return answer;
    }
}
