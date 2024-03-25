package 단두대스터디;

import java.util.HashMap;

public class 가장많이받은선물 {

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String,Integer> nameTable =new HashMap<>();//이름->숫자 변환을 위한 테이블
        HashMap<Integer,Integer> giftPoint=new HashMap<>();//각각의 선물포인트 기록
        int[][]giftMap=new int[friends.length+1][friends.length+1];//1~N까지 사용 선물을 주고받은 관계 기록

        for(int i=1;i<=friends.length;i++){
            nameTable.put(friends[i-1],i);//네임테이블에 이름/번호 순차저장
            giftPoint.put(i,0);//선물포인트 0으로 초기화
        }
        for(int i=0;i<gifts.length;i++){
            String[] giftList=gifts[i].split(" ");
            int giv=nameTable.get(giftList[0]);//선물 준 사람 이름 -> 숫자로 변환
            int rec=nameTable.get(giftList[1]);//선물 받은 사람 이름 -> 숫자로 변환
            giftMap[giv][rec]++;
            giftPoint.put(giv,giftPoint.get(giv)+1);//준 사람 포인트 +1
            giftPoint.put(rec,giftPoint.get(rec)-1);//받은 사람 포인트 -1
        }
        for(int i=1;i<=friends.length;i++){
            int count=0;//현재 이름의 다음달 선물 개수 체크
            for(int j=1;j<=friends.length;j++){
                if(giftMap[i][j]>giftMap[j][i]){//내가 준게 받은거보다 많다
                    count++;//다음달에 선물받음
                }
                else if (giftMap[i][j]==giftMap[j][i]){//주고받은 선물이 똑같으면
                    //포인트 비교
                    if(giftPoint.get(i)>giftPoint.get(j)){//내 포인트가 높으면 +1
                        count++;
                    }
                }
            }
            if(answer<count){
                answer=count;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] friends={"muzi", "ryan", "frodo", "neo"};
        String[] gifts={"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        solution(friends,gifts);
    }
}
