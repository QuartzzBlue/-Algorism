package level2;
import java.util.*;
public class 프린터 {

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
//        		if(pri.get(j) == max) {	/* 값이 max일 때 */
//        			if(j == location) { // 포인터 j가 가리키는 배열인덱스가 location과 같으면
//        				answer++;       // answer 올리고 while문 빠져나감
//        				break A;	
//        			}else {             /* 값이 max인데 j가 가리키는 인덱스가 location과 같지 않으면 */
//        				answer++;       // answer 올리고
//                                                 /*배열 삭제 전의 전처리*/
//        				if(j < location) {       //포인터 j가 가리키는 배열 인덱스가 location보다 작으면   
//        					location -= 1;       
//        				}
//    					len -= 1;                //전체 배열 길이 -1
//        				pri.remove(j);           //값이 제일 크게 들어 있는 arraylist 삭제
//        				if(j > len) {            //만약 삭제된 후에 포인터 j가 가리키는 값이 배열 밖에 있다면
//        					j = 0;               //포인터 j를 배열 처음으로 초기화
//        				}    				
//        			}
//        		}else{                   /* j가 가리키는 값이 max값이 아닐 경우 다음 배열로 넘어감 */
//        			j++;
//                    if(j > len) {          //단, 포인터 j가 가리키는 값이 배열 밖에 있다면 배열 처음으로 초기화
//                	    j = 0;
//        			}
//        		}
//       } 
//        
//        return answer;
//    }
//}