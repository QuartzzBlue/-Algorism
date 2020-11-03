package level2;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        
        loop : for(int n = 0; n < skill_trees.length; n++) {
            int tmp = -1;
            boolean[] check = new boolean[skill.length()];
            String skill_tree = skill_trees[n];  
            
            for(int i = 0; i < skill.length(); i++) {
                for(int j = 0; j < skill_tree.length(); j++){
                    
                    // 선행스킬과 스킬트리의 스킬이 같은 경우
                    if(skill.charAt(i) == skill_tree.charAt(j)){
                        // 해당 선행스킬 체크 배열에 체크
                        check[i] = true;
                        
                        // 해당 스킬의 선행 스킬 중 배우지 않은 스킬이 있다면 불가능한 스킬트리
                        for(int k = 0; k < i; k++){
                            if(check[k] == false){
                                answer--;
                                continue loop;
                            }
                        }
                        
                        // 스킬 순서가 틀린 경우 불가능한 스킬트리
                        if(tmp > j){
                            answer--;
                            continue loop;
                        }
                        
                        tmp = j;
                    }
                }
            }
        }
        
        return answer;
    }
}
