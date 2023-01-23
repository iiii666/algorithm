package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class p3 {
	static List<Integer>[] li;
	static int M;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		li = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			li[i] = new ArrayList<>();
			li[i].add(temp);
			li[i].add(temp2);
		}

		dfs(0, 0, 0);
		System.out.println(max);
	}

	public static void dfs(int depth, int count, int time) {
		if (time > M) {
			return;
		}
		if (depth == li.length) {
			if(max<count) {
				max = count;
			}

			return;

		} else {
			
				dfs(depth + 1, count + li[depth].get(0), time + li[depth].get(1));
				dfs(depth + 1, count, time);
			

		}

	}

}
