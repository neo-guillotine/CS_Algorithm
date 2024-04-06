import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // skill에 해당하는 문자들만 남기기
        // ex : "BCD", "CBD", "CB", "BD"
        String[] n_skill_trees = new String[skill_trees.length];
        Arrays.fill(n_skill_trees,"");
        for(int i = 0; i < skill_trees.length; i++) {
            for(int j = 0; j < skill_trees[i].length(); j++) {
                for(int s = 0; s < skill.length(); s++) {
                    if(skill.charAt(s) == skill_trees[i].charAt(j)) {
                        n_skill_trees[i] += skill_trees[i].charAt(j);
                    }
                }
            }
        }
        
        boolean[] b_skill_trees = new boolean[skill_trees.length];
        Arrays.fill(b_skill_trees,true);
        Queue<Character> q = new ArrayDeque<>();
        for(int i = 0; i < n_skill_trees.length; i++) {
            // skill에 해당하는 문자들만 남은 것들을 q에 넣고
            for(int j = 0; j < n_skill_trees[i].length(); j++) {
                q.add(n_skill_trees[i].charAt(j));
            }
            // skill의 순서대로 안돼있으면 false로 만들어서 그 skill_trees는 건너뛰기
            // true인 것들 중 skill 순서대로 있으면 q에서 빼주기
            for(int s = 0; s < skill.length(); s++) {
                if(q.size() != 0 && b_skill_trees[i]) {
                    if(q.peek() != skill.charAt(s)) b_skill_trees[i] = false;
                    else if(q.peek() == skill.charAt(s)) q.poll();
                }
            }
            // q가 비어있다 = skill 순서대로 돼있었다
            if(q.size() == 0) answer++;
            
            q.clear();
        }
        
        return answer;
    }
}
