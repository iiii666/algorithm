package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p11725 {
	/*트리의 부모 찾기 s2
	 * 
	 * 유형 : bfs 로 부모찾기 ,한 단계 식 위로 가면 부모
	 * 
	 * */
	static List<Integer>[] li;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();
	static int[] results;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		li = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		results = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			li[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			li[temp].add(temp2);
			li[temp2].add(temp);
		}
		visited[1] = true;
		q.add(1);

		bfs();
		for (int i = 2; i < results.length; i++) {
			System.out.println(results[i]);
		}
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < li[now].size(); i++) {
				if (visited[li[now].get(i)]) {
					continue;
				} else {
					visited[li[now].get(i)] = true;
					q.add(li[now].get(i));
					results[li[now].get(i)] = now;
				}
			}
		}

	}
}
