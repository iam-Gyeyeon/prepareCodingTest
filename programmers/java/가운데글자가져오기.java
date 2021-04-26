/*
총평
1. 문제는 아주아주 쉬웠음
  1-1. 문자열의 길이가 짝수일 때 / 홀수일 때 가운데를 찾는 식을 생각했음
2. 그렇기 때문에 걸리는 시간에 대해 생각할 수 있는 여유가 있었음
3. 삼항연산자에 대해서도 생각해봤지만,, 속도를 향상시키는 방법은 아닌듯
*/
class Solution{
    public String solution(String s){
        String answer = "";
        int length = s.length()/2;      //이렇게 하면 속도가 향상될까 하여,,
      
        //문자열의 길이가 짝수일 때
        if(s.length()%2==0){
            answer = s.substring(length-1, length+1);
        }
        //문자열의 길이가 홀수일 때
        else{
            answer = s.substring(length,length+1);
        }

        return answer;
    }
}

//삼항연산자 버전으로 생각해낸 것
class Solution{
    public String solution(String s){
      int length = s.length();
      int index = length / 2;
      return (length%2==0) ? s.substring(index-1, index+1) : s.substring(index, index+1);
    }
}
