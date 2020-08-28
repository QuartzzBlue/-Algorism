package Sorting;

import java.io.*;
import java.util.*;

public class Q2108 {
	static int[] array = null;
	static Set<Integer> set = null;
	static int N = 0;
	
	static int getAvg() {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return (int) (Math.round(sum / (double) array.length));
	}

	static int getCenter() {
		int center = array.length / 2;

		return array[center];
	}

	static int getMode() {
		Iterator<Integer> iter = set.iterator();
		int num = 0;
		int max = 0;
		
		while(iter.hasNext()) {
			int tmp = iter.next();
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				if(tmp == array[i]) {
					cnt++;
				}
			}
			if(max < cnt) {
				max = cnt;
				num = tmp;
			}
		}
		return num;
	}

	static int getRange() {
		int min = array[0];
		int max = array[array.length - 1];

		return max - min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		array = new int[N];
		set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
			set.add(array[i]);
		}

		Arrays.sort(array);

		bw.write(getAvg() + "\n" + getCenter() + "\n" + getMode() + "\n" + getRange());
		bw.flush();
		
		bw.close();
		br.close();
		
	}
}