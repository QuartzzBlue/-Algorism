package level2;
import java.util.*;
public class ������ {

}

class Solution {
    public int solution(int[] priorities, int location) {
        ArrayList<Document> list = new ArrayList<>();
        Queue<Document> docuQueue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            list.add(new Document(i, priorities[i]));
            docuQueue.add(new Document(i, priorities[i]));
        }
        Arrays.sort(priorities);
        int index = 0;
        while(!docuQueue.isEmpty()){
            Document thisDocument = docuQueue.poll();
            int loc = thisDocument.getIndex();
            int priority = thisDocument.getPriority();
            if(priority == priorities[priorities.length - (index + 1)]){
                // System.out.println(priority + " : "+ priorities[index] + ", " + index);
                if(loc == location){
                    index++;
                    break;
                }
                index++;
            }else{
                docuQueue.add(thisDocument);
            }
            
            
        }
        
        return index;
    }
}

class Document {
    private int index;
    private int priority;
    
    Document(int index, int priority){
        this.index = index;
        this.priority = priority;
    }
    
    public int getIndex() {
        return this.index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getPriority() {
        return this.priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
}
//class Solution {
//    public int solution(int[] priorities, int location) {
//        int answer = 0;
//        
//        ArrayList<Integer> pri = new ArrayList<>();
//        int len = priorities.length - 1;
//        
//        for(int j = 0; j <= len; j++) {
//        	pri.add(priorities[j]);
//        }
//        int max = 0;
//
//        int j = 0;
//        A: while(true) {
//        		max = Collections.max(pri);
//
//        		if(pri.get(j) == max) {	/* ���� max�� �� */
//        			if(j == location) { // ������ j�� ����Ű�� �迭�ε����� location�� ������
//        				answer++;       // answer �ø��� while�� ��������
//        				break A;	
//        			}else {             /* ���� max�ε� j�� ����Ű�� �ε����� location�� ���� ������ */
//        				answer++;       // answer �ø���
//                                                 /*�迭 ���� ���� ��ó��*/
//        				if(j < location) {       //������ j�� ����Ű�� �迭 �ε����� location���� ������   
//        					location -= 1;       
//        				}
//    					len -= 1;                //��ü �迭 ���� -1
//        				pri.remove(j);           //���� ���� ũ�� ��� �ִ� arraylist ����
//        				if(j > len) {            //���� ������ �Ŀ� ������ j�� ����Ű�� ���� �迭 �ۿ� �ִٸ�
//        					j = 0;               //������ j�� �迭 ó������ �ʱ�ȭ
//        				}    				
//        			}
//        		}else{                   /* j�� ����Ű�� ���� max���� �ƴ� ��� ���� �迭�� �Ѿ */
//        			j++;
//                    if(j > len) {          //��, ������ j�� ����Ű�� ���� �迭 �ۿ� �ִٸ� �迭 ó������ �ʱ�ȭ
//                	    j = 0;
//        			}
//        		}
//       } 
//        
//        return answer;
//    }
//}