package week12_2404;

public class P135807숫자카드만들기_240430 {
    //최대공약수 구하는 법 서칭함....ㅠ
    class Solution {
        int answer;
        public int solution(int[] arrayA, int[] arrayB) {
            answer =0;
            int gcdA=arrayA[0];
            int gcdB=arrayB[0];
            for(int i=1;i<arrayA.length;i++){
                gcdA=gcd(gcdA,arrayA[i]);
                gcdB=gcd(gcdB,arrayB[i]);
            }

            check(arrayA,gcdB);
            check(arrayB,gcdA);
            return answer;
        }//method

        int gcd(int a,int b){
            while(b!=0){
                int tmp = b;
                b=a%b;
                a=tmp;
            }
            return a;
        }

        void check(int[]array, int gcd){
            boolean flag=true;
            for(int j:array){//array에서 1개 뽑아서 나눠지면 flag false로 바꾸고 빠져나가기.
                if(j%gcd==0){
                    flag=false;
                    break;
                }
            }
            //나눠지지 않은 경우, max값 비교하기
            if(flag){
                answer = Math.max(gcd,answer);
                return;
            }
        }
    }//class

/*    class Solution {
        HashSet<Integer>set;
        int answer;
        public int solution(int[] arrayA, int[] arrayB) {
            answer = 0;
            set = new HashSet<>();
            ArrayList<Integer>aList = new ArrayList();
            ArrayList<Integer>bList = new ArrayList();
            for(int i=0;i<arrayA.length;i++){
                for(int j=i+1;j<arrayA.length;j++){
                    cdv(arrayA[i],arrayA[j]);
                }
            }
            for(int i:set){
                aList.add(i);
            }
            aList.remove((Integer)1);
            Collections.sort(aList,Collections.reverseOrder());
            set = new HashSet<>();
            for(int i=0;i<arrayB.length;i++){
                for(int j=i+1;j<arrayB.length;j++){
                    cdv(arrayB[i],arrayB[j]);
                }
            }
            for(int i:set){
                bList.add(i);
            }
            bList.remove((Integer)1);
            Collections.sort(bList,Collections.reverseOrder());
            // System.out.println("a"+aList);
            // System.out.println("b"+bList);
            check(arrayA,bList);
            check(arrayB,aList);



            return answer;
        }//method
        void cdv(int a, int b){
            int sqrt = (int)Math.ceil(Math.sqrt(a));
            for(int i=1;i<sqrt;i++){
                if(a%i==0){
                    if(b%i==0){
                        set.add(i);
                    }
                    if(b%(a/i)==0){
                        set.add(a/i);
                    }
                }
            }
        }//commonDivisor

        void check(int[]array, ArrayList<Integer>list){
            //array는 원래 배열이고, list는 공약수
            if(list.size()==0)return;
            for(int i: list){
                boolean flag=false;
                for(int j:array){
                    if(i>j)continue;
                    if(j%i==0){
                        flag=true;
                        break;
                    }
                    // System.out.println(i+" "+j+" "+flag);
                }
                //한바퀴를 다 돈거면 이 친구는 가장 큰 수.
                if(!flag){
                    answer = Math.max(i,answer);

                }
                return;
            }
        }
    }//class
 
 */
}