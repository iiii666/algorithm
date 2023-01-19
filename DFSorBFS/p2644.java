package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2644 {
	/* 촌수계산 s2
	 * 유형 배열리스트를 사용한 bfs
	 * */
	static ArrayList<Integer>[] li;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();
	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int member1 = Integer.parseInt(st.nextToken());
		int member2 = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());

		li = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			li[i] = new ArrayList<>();
		}
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			li[num].add(num2);
			li[num2].add(num);
		}
		q.add(member1);
		visited[member1] = true;
		bfs(member1, member2);
		System.out.println(result);
	}

	public static void bfs(int member1, int member2) {

		while (!q.isEmpty()) {
			int size = q.size();
			for (int j = 0; j <size; j++) {
				int now = q.poll();
				for (int i = 0; i < li[now].size(); i++) {
					if (!visited[li[now].get(i)]) {
						visited[li[now].get(i)] = true;
						q.add(li[now].get(i));
						if (li[now].get(i) == member2) {// 찾으면
							result++;
							return;
						}
					}
				}
			}

			result++;

		}
		result = -1;
	}
}
