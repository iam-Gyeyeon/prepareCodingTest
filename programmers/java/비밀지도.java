/*
1. 둘다 0 일때는 0, 둘 중 하나라도 #일때는 #이다 -> OR 연산
2. 최종 형태를 "" 과 1로 변환을 하도록 요구 -> replaceAll (replace에서 기억이 안나서 검색해봤다)
3. 빈 자릿수를 채우기 위해 겹쳐진 수의 2진수 길이가 짧으면 ? -> 차이만큼 0을 붙여주자 



*/
public String[] solution(int n, int[] arr1, int[] arr2) {
        int[] map = new int[n];                    //arr1와 arr2를 합친(or연산을 하게 될) 맵
        String[] answer = new String[n];
        
        for(int i = 0 ; i < n; i++) {
            map[i] = arr1[i] | arr2[i];            //or 연산
        }
        
        for(int i = 0 ; i < map.length; i++) {
            String temp = Integer.toBinaryString(map[i]);   //or연산한 수를 이진수로 반환. (이거 검색해봤음)
            if(temp.length() < n) {                         //자리수가 꽉 차지 않는다면 
                int cha = n - temp.length();                
                for(int j =0 ; j < cha; j++) {                //차이가 나는 만큼 앞에 0을 붙혀줌.
                    temp = "0"+temp;
                }
            }
            temp = temp.replaceAll("1", "#");                  //1은 #으로 0은 공백으로
            temp = temp.replaceAll("0", " ");
            answer[i] = temp;
        }
        return answer;
    }
