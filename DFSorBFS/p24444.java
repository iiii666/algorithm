package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p24444 {
	static List<Integer>[] li;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();
	static List<Integer> result = new ArrayList<>();
	static int[] v;
	static int visitCnt = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		li = new ArrayList[N + 1];
		 v = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i < N + 1; i++) {
			li[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			li[v].add(e);
			li[e].add(v);
		}
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(li[i]);
		}
		q.add(R);
		v[R] = visitCnt;
		bfs(R);

		for (int i = 1; i <= N; i++) {
            sb.append(v[i]).append('\n');
        }
        System.out.print(sb);
	}

	private static void bfs(int r) {
		
		while (!q.isEmpty()) {
			int temp = q.poll();
			result.add(temp);
			
			visited[temp] = true;
			for (int i = 0; i < li[temp].size(); i++) {
				if (visited[li[temp].get(i)] == false) {
					visited[li[temp].get(i)] = true;
					v[li[temp].get(i)] = ++visitCnt;
					q.add(li[temp].get(i));
				}
			}
		}
	}
}
