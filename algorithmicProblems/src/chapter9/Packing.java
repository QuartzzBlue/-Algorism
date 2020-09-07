package chapter9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// 와진짜 개어렵다
// 항상 기저사례 먼저 생각하자


/*
<Input>
2
6 10
laptop 4 7
camera 2 10
xbox 6 6
grinder 4 7
dumbell 2 5
encyclopedia 10 4
6 17
laptop 4 7
camera 2 10
xbox 6 6
grinder 4 7
dumbell 2 5
encyclopedia 10 4
 */

/*
2
6 10
laptop 4 7
camera 2 10
xbox 6 6
grinder 4 7
dumbell 2 5
encyclopedia 10 4
6 17
laptop 4 7
camera 2 10
xbox 6 6
grinder 4 7
dumbell 2 5
encyclopedia 10 4
 */
/*
<Output>
24 3
laptop
camera
grinder
30 4
laptop
camra
xbox
grinder
 */

public class Packing {
	int itemNum;
	int carrierVolume;
	int[][] cache;
	ArrayList<String> itemlist;
 	HashMap<Integer, Package> items;	// 키 값이 1부터 시작
	
	
	Packing(int itemNum, int carrierVolume){
		this.itemNum = itemNum;
		this.carrierVolume = carrierVolume;
		this.cache = new int[1001][101]; // cache [capacity 여유공간] [n 선택한 아이템 갯수] = 절박도
		for(int[] tmp : cache) {
			Arrays.fill(tmp, -1);
		}
		itemlist = new ArrayList<String>();
		this.items = new HashMap<Integer, Package>();
	}
	
	public int getPack(int n, int itemIdx, int capacity) { 
		if(n == itemNum || capacity <= 0 || itemIdx > itemNum) return 0; //아이템을 다 담았거나, 여유공간이 0 이하거나, 아이템 인덱스가 아이템 수를 초과하는 경우
		if(cache[capacity][n] != -1) return cache[capacity][n];
		
		int tmpUrg1 = getPack(n, itemIdx+1, capacity);
		int tmpUrg2 = -1;
		int itemVol = items.get(itemIdx).getVolume();
		int itemUrg = items.get(itemIdx).getUrgency();
		
		if(capacity - itemVol >= 0) {
			tmpUrg2 = getPack(n+1, itemIdx+1, capacity-itemVol) + itemUrg;
			cache[capacity][n] = Math.max(tmpUrg1, tmpUrg2);
		}
//		cache[capacity][n] = Math.max(tmpUrg1, tmpUrg2);
//		return Math.max(tmpUrg1, tmpUrg2);
		return cache[capacity][n];
	}
	
	public void getItemlist(int n, int itemIdx, int capacity) {
		if(n == itemNum || capacity <= 0 || itemIdx > itemNum) return;
		
		if(getPack(n, itemIdx, capacity) == getPack(n, itemIdx+1, capacity)) {
			getItemlist(n, itemIdx+1, capacity);
		}else {

			itemlist.add(items.get(itemIdx).getName());
			getItemlist(n+1, itemIdx+1, capacity-items.get(itemIdx).getUrgency());
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int caseNum = Integer.parseInt(br.readLine());

		for(int n = 0; n < caseNum; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int itemNum = Integer.parseInt(st.nextToken());
			int carrierVolume = Integer.parseInt(st.nextToken());
			Packing pack = new Packing(itemNum, carrierVolume);
			
			for(int i = 1; i <= itemNum; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				int vol = Integer.parseInt(st.nextToken());
				int urg = Integer.parseInt(st.nextToken());
				pack.items.put(i, new Package(name, vol, urg));
			}
			
			int totalUrg = pack.getPack(0, 1, carrierVolume);
			pack.getItemlist(0, 1, carrierVolume);
			bw.append(totalUrg + " " + pack.itemlist.size() + "\n");
			
			for(int j = 0; j < pack.itemlist.size(); j++) {
				bw.append(pack.itemlist.get(j) + "\n");
			}
			
		}
		bw.flush();
		br.close();
		bw.close();
	}

}

class Package {
	private String name;
	private int volume;
	private int urgency;
	
	Package(String name, int volume, int urgency) {
		this.name = name;
		this.volume = volume;
		this.urgency = urgency;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getUrgency() {
		return urgency;
	}
	public void setUrgency(int urgency) {
		this.urgency = urgency;
	}

	@Override
	public String toString() {
		return "Package [name=" + name + ", volume=" + volume + ", urgency=" + urgency + "]";
	}

	
	
}
