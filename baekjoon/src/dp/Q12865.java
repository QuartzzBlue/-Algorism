package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
8 4
1 3
1 6
1 3
1 3
1 3
1 2
1 5
1 8
 */

/*
22
 */

public class Q12865 {
	int itemNum;
	int weightLimit;
	int[][] cache;
 	HashMap<Integer, Item> items;	// 키 값이 1부터 시작
	
 	Q12865(int itemNum, int weightLimit){
		this.itemNum = itemNum;
		this.weightLimit = weightLimit;
		this.cache = new int[100001][101]; // cache[capacity 여유공간][n 선택한 아이템 갯수] = 가치합
		for(int[] tmp : cache) {
			Arrays.fill(tmp, -1);
		}
		this.items = new HashMap<Integer, Item>();
	}
 	
 	public int getMaxValue(int n, int capacity, int idx) {
// 		System.out.println(n + " " + capacity + " " + idx);
 		if(n > itemNum || capacity < 0 || idx > itemNum) {
 			return 0;
 		}
 		if(cache[capacity][n] != -1) {
 			return cache[capacity][n];
 		}
 		int tmpVal1 = getMaxValue(n, capacity, idx+1);
 		int tmpVal2 = -1;
 		if(capacity-items.get(idx).getWeight() >= 0) {
 			tmpVal2 = getMaxValue(n+1, capacity-items.get(idx).getWeight(), idx+1)
 						+ items.get(idx).getValue();
 		}
 		cache[capacity][n] = Math.max(tmpVal1, tmpVal2);
 		System.out.println("** " + cache[capacity][n]);
 		return cache[capacity][n];
// 		return Math.max(tmpVal1, tmpVal2);
 		
 		
 	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int itemNum = Integer.parseInt(st.nextToken());
		int weightLimit = Integer.parseInt(st.nextToken());
		Q12865 m = new Q12865(itemNum, weightLimit);
			
		for(int i = 1; i <= itemNum; i++) {
			st = new StringTokenizer(br.readLine());
			int wei = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			m.items.put(i, new Item(wei, val));
		}
		System.out.println(m.getMaxValue(0, weightLimit, 1));
	}

}

class Item {
	private int weight;
	private int value;
	
	Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
