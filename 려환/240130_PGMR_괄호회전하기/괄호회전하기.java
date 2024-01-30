import java.util.*;
// 뭔가 큐와 스택을 동시에 활용하면 되지 않을까 싶다.
class Solution {
    public int solution(String s) {
       Stack<Character> stack = new Stack<>();
        Queue<Character> que = new LinkedList<>();
        for(int i = 0; i< s.length(); i ++){
            que.offer(s.charAt(i));
        }
        char temp;
        int result = 0, count = 0;
        String tempString = "";
        boolean isPossible = true;
        for(int i = 0; i < s.length(); i++){
            isPossible = true;
            tempString = "";
            for (int j = 0; j < s.length(); j++) {
                temp = que.poll();
                tempString += temp;
                que.offer(temp);
            }
            for(int j = 0; j < s.length(); j ++){
                if(!isPossible){
                    break;
                }
                temp = tempString.charAt(j);
                switch(temp){
                    case '{':
                        stack.push('{');
                        break;
                    case '[':
                        stack.push('[');
                        break;
                    case '(':
                        stack.push('(');
                        break;
                    case '}':
                        if(stack.isEmpty()) {
                            isPossible = false;
                            break;
                        }
                        if(stack.peek() == '{') stack.pop();
                        else {
                            isPossible = false;
                        }
                        break;
                    case ']':
                        if(stack.isEmpty()) {
                            isPossible = false;
                            break;
                        }
                        if(stack.peek() == '[') stack.pop();
                        else {
                            isPossible = false;

                        }
                        break;
                    case ')':
                        if(stack.isEmpty()) {
                            isPossible = false;
                            break;
                        }
                        if(stack.peek() == '(') stack.pop();
                        else {
                            isPossible = false;
                        }
                        break;
                    default:
                        break;
                }
            }
            if(isPossible && stack.size() == 0){
                result += 1;
            }
            temp = que.poll();
            que.offer(temp);
            stack = new Stack<Character>();
        }
        return result;
    }
    
}