package level2;

public class ��ųƮ�� {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        
        loop : for(int n = 0; n < skill_trees.length; n++) {
            int tmp = -1;
            boolean[] check = new boolean[skill.length()];
            String skill_tree = skill_trees[n];  
            
            for(int i = 0; i < skill.length(); i++) {
                for(int j = 0; j < skill_tree.length(); j++){
                    
                    // ���ེų�� ��ųƮ���� ��ų�� ���� ���
                    if(skill.charAt(i) == skill_tree.charAt(j)){
                        // �ش� ���ེų üũ �迭�� üũ
                        check[i] = true;
                        
                        // �ش� ��ų�� ���� ��ų �� ����� ���� ��ų�� �ִٸ� �Ұ����� ��ųƮ��
                        for(int k = 0; k < i; k++){
                            if(check[k] == false){
                                answer--;
                                continue loop;
                            }
                        }
                        
                        // ��ų ������ Ʋ�� ��� �Ұ����� ��ųƮ��
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
