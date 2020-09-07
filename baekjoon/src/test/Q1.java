package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1 {

	static int N;
	static int wSec;
	static int wCustomer;
	static boolean[] flag; //true = 안차있음 false = 차있음
	static int[][] customer;
	static ArrayList<Queue<Integer>> line =  new ArrayList<Queue<Integer>>();
	static Queue<Integer> cumNum;
	
	static public void bank(int idx, int sec){
			boolean isAllClean = true;
			boolean isAllFull = true;
			
			for(int i = 0; i < N; i++) {
			
				line.get(i).poll();
				flag[i] = line.get(i).size() == 0 ? true : false;
				if(flag[i] == false) isAllClean = false;
				else isAllFull = false;
				
			}
			
			System.out.println(isAllFull);
			
	        if(idx > customer.length-1 && isAllClean == true) return;

	        if(idx <= customer.length-1) {
		        if(customer[idx][0] <= sec){
		            //창구가 다 차 있을 때
		            if(isAllFull){
		            	System.out.println("idx : " + idx + "customer : " + cumNum.size() + " sec : " + sec + "**wsec");
		                wSec += (idx-cumNum.size()+1);
		                
		            }else {
		            	for(int i = 0; i < N; i++) {
			            	if(flag[i] == true) { // 비어있으면
			            		for(int j = 0; j < customer[idx][1]; j++){
			            			line.get(i).offer(idx);
				                }
			            		cumNum.add(idx);
			            		idx++;
			            		break;
			            	}
						}
		            }
		            
		        }
	        }
			
	        bank(idx, sec+1);
	    }
	
	public static void main(String[] args) {
		N = 1;
		int[][] simulation_data = {{2,3}, {5,4}, {6,3}, {7,4}};
//		N = 2;
//		int[][] simulation_data = {{0,3}, {2,5}, {4,2}, {5,3}};
		wSec = 0;
		flag = new boolean[N+1];
		for(int n = 0; n < N; n++) {
			line.add(new LinkedList<Integer>());
		}
		cumNum = new LinkedList<Integer>();
        customer = simulation_data;
//        line1 = new LinkedList<>();
//        line2 = new LinkedList<>();
        bank(0, 0);
        System.out.println(wSec);
		
	}
}
