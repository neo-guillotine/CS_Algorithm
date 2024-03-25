package 단두대스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 뒤에있는큰수찾기 {

        public static int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<Integer> stack=new Stack<>();
            for(int i=numbers.length-1;i>=0;i--) {//큰 탑을 남길거니까 방향은 반대로 체크
                int top = numbers[i];//현재 탑의 높이
                while(!stack.isEmpty()) {//스택에 저장된 탑을 전체확인
                    if(stack.peek() > top) {//현재 스택에 있는 탑이 내 탑보다 크다 -> 해당 탑의 뒤에 있는 큰 수
                        answer[i]=stack.peek();//답에 저장
                        break;
                    }
                    stack.pop();//나보다 작은 수는 가지고 있을 필요 X
                }
                if(stack.isEmpty()) {//스택이 비어있으면 레이져 맞는거 X
                    answer[i]=-1;// 0 출력
                }
                stack.push(numbers[i]); //현재 값 스택에 저장
            }
            for(int i=0;i<answer.length;i++){
                System.out.print(answer[i]+" ");

            } System.out.println();
            return answer;
        }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String st=br.readLine();
        int[] numbers = new int[st.length()];

        for( int i = 0; i < st.length(); i++ ) {

            numbers[i] = st.charAt(i) - '0';
        }
        solution(numbers);
    }
}
